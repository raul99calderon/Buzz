import java.util.ArrayList;
import java.util.List;

public class Game {
	
    private FrameController frame;
    private List<Question> questions;
    private List<Buzzer> buzzers;
    private PressedKeys pressedKeys;
    private boolean buzzersOppened;
    private Question actualQuestion;
    private int numPlayers;

    public Game() {
    	this.numPlayers = 0;
    	this.questions = new ArrayList<Question>();
    	this.buzzers = new ArrayList<>();
    	this.pressedKeys = new PressedKeys();
    	this.loadData();
    	this.loadBuzzers();
    	this.frame = new FrameController(this);
        this.buzzersOppened = false;
        
    }
    
	public void start() throws InterruptedException {
		frame.askNumPlayers();
		while (numPlayers == 0) {
			Thread.sleep(100);
		}
		startGame1();
	}
	
	public void startGame1() throws InterruptedException {
		frame.initFrame1();
		
		for (Question question : questions) {
        	pressedKeys = new PressedKeys();
        	actualQuestion = question;
            
        	frame.appendText(question.getQuestion() + '\n');
        	for(int i = 0; i < question.getAnswers().size(); i++) {
            	frame.appendText(question.getAnswers().get(i).getColor() + ": " + question.getAnswers().get(i).getText() + '\n');
            }

            buzzersOppened = true;
    		Thread.sleep(5000);
			buzzersOppened = false;
            
            for (PressedKey pressedKey : pressedKeys.getPressedKeys()) {
            	frame.appendText("El buzzer " + pressedKey.getBuzzer().getId() + " ha presionado el color: " + pressedKey.getPressedButton().getColor().toString() +", respondiendo: " + pressedKey.getPressedAnswer().getText());
            	if (question.getCorrectAnswer().equals(pressedKey.getPressedAnswer()))
            		frame.appendText(" y ha acertado!"+ '\n');
            	else
            		frame.appendText(" y ha fallado!" + '\n');
            }
            Thread.sleep(2000);
            frame.appendText("\n-----------------------------\n\n");
        }
	}
	
	
	public boolean isBuzzersOpened() {
		return this.buzzersOppened;
	}
	
	public void processKeyPressedGame1(int keyCode) {
		PressedKey pressedKey = new PressedKey();
    	for (Buzzer buzzer : buzzers) {
    		if (buzzer.containsKeyCode(keyCode)) {
    			pressedKey.setBuzzer(buzzer);
    			pressedKey.setPressedButton(buzzer.getButton(keyCode));
    			pressedKey.setPressedAnswer(actualQuestion.getAnswer(buzzer.getButton(keyCode).getColor()));
    			
    			System.out.println("Mando " + pressedKey.getBuzzer().getId() + " ha pulsado el " + pressedKey.getPressedButton().getColor().toString());
                
                if (pressedKey.getPressedButton().getColor() != Color.RED)
                	pressedKeys.addPressedKey(pressedKey);
    		}
    	}
	}
	
	private void loadData() {
		List<Answer> answers = new ArrayList<>();
		answers.add(new Answer("Gandalf",true, Color.BLUE));
		answers.add(new Answer("Gimli",false, Color.ORANGE));
		answers.add(new Answer("Legolas",false, Color.GREEN));
		answers.add(new Answer("Aragorn",false, Color.YELLOW));
		questions.add(new Question(answers, "¿Quién es un mago?"));
		
		answers = new ArrayList<>();
		answers.add(new Answer("Bolsón cerrado",false, Color.BLUE));
		answers.add(new Answer("Bree",true, Color.ORANGE));
		answers.add(new Answer("La Comarca",false, Color.GREEN));
		answers.add(new Answer("Mordor",false, Color.YELLOW));
		questions.add(new Question(answers, "¿Cómo se llama la aldea en la que se encuentra La Posada del Pony Pisador?"));
		
		answers = new ArrayList<>();
		answers.add(new Answer("Thorin",false, Color.BLUE));
		answers.add(new Answer("Thrain",false, Color.ORANGE));
		answers.add(new Answer("Gimli",false, Color.GREEN));
		answers.add(new Answer("Balin",true, Color.YELLOW));
		questions.add(new Question(answers, "¿Cómo se llama el último Señor de Moria?"));
		
		answers = new ArrayList<>();
		answers.add(new Answer("5",true, Color.BLUE));
		answers.add(new Answer("3",false, Color.ORANGE));
		answers.add(new Answer("4",false, Color.GREEN));
		answers.add(new Answer("0",false, Color.YELLOW));
		questions.add(new Question(answers, "¿Cuántos magos pertenecen en la orden?"));
		
		answers = new ArrayList<>();
		answers.add(new Answer("Eleanor Gamyi",false, Color.BLUE));
		answers.add(new Answer("Rizos de Oro",false, Color.ORANGE));
		answers.add(new Answer("Rosita Coto",true, Color.GREEN));
		answers.add(new Answer("Margarita Ciñatiesa",false, Color.YELLOW));
		questions.add(new Question(answers, "¿De quién estaba enamorado Sam?"));
	}
	
	private void loadBuzzers() {
		Buzzer buzzer1 = new Buzzer(1, new char[] {'1','2','3','4','5'});
		Buzzer buzzer2 = new Buzzer(2, new char[] {'q','w','e','r','t'});
		Buzzer buzzer3 = new Buzzer(3, new char[] {'a','s','d','f','g'});
		Buzzer buzzer4 = new Buzzer(4, new char[] {'z','x','c','v','b'});
		buzzers.add(buzzer1);
		buzzers.add(buzzer2);
		buzzers.add(buzzer3);
		buzzers.add(buzzer4);
		for(Buzzer buzzer : buzzers) {
			System.out.println(buzzer.toString());
		}
	}
	
	public Color getColorButtonPressedBuzzer1(int keyCode) {
		Buzzer buzzer = buzzers.get(0);
		if (buzzer.containsKeyCode(keyCode)) {
			System.out.println("PULSANDO " + buzzer.getButton(keyCode).getColor().toString());
			return buzzer.getButton(keyCode).getColor();
		}
		return null;
	}
	
	public void setNumPlayers(int numPlayers) throws InterruptedException {
		System.out.println("E");
		this.numPlayers = numPlayers;
		System.out.println("F");
	}
	
}
