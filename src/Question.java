import java.util.List;

public class Question {
	private List<Answer> answers;
	private String question;
	
	public Question(List<Answer> answers, String question) {
		this.answers = answers;
		this.question = question;
	}
	
	public List<Answer> getAnswers() {
		return answers;
	}
	
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public Answer getCorrectAnswer() {
		for (Answer answer : answers) {
			if (answer.isCorrect()) {
				return answer;
			}
		}
		return null;
	}
	
	public Answer getAnswer(Color color) {
		for (Answer answer : answers) {
			if (answer.getColor().equals(color)) {
				return answer;
			}
		}
		return null;
	}
}
