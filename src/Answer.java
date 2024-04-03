
public class Answer {
	
	private String text;
	private boolean isCorrect;
	private Color color;
	
	public Answer(String text, boolean isCorrect, Color color) {
		this.text = text;
		this.isCorrect = isCorrect;
		this.color = color;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String answer) {
		this.text = answer;
	}
	
	public boolean isCorrect() {
		return isCorrect;
	}
	
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
