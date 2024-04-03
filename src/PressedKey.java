
public class PressedKey {
	
	private Buzzer buzzer;
	private Answer answer;
	private Button pressedButton;
	
	public PressedKey(Buzzer buzzer, Answer answer, Button pressedButton) {
		this.buzzer = buzzer;
		this.answer = answer;
		this.pressedButton = pressedButton;
	}

	public PressedKey() {
		// TODO Auto-generated constructor stub
	}

	public Buzzer getBuzzer() {
		return buzzer;
	}
	
	public void setBuzzer(Buzzer buzzer) {
		this.buzzer = buzzer;
	}
	
	public Answer getPressedAnswer() {
		return answer;
	}
	
	public void setPressedAnswer(Answer answer) {
		this.answer = answer;
	}

	public Button getPressedButton() {
		return pressedButton;
	}

	public void setPressedButton(Button pressedButton) {
		this.pressedButton = pressedButton;
	}
	
	
	
}
