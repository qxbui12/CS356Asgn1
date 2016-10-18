import java.util.ArrayList;

public class YesNoQuestion {
	private String question;
	private ArrayList<String> options;
	private ArrayList<String> answers;
	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}
	
	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}

	public ArrayList<String> getOptions() {
		return options;
	}

	public void setAnswers(ArrayList<String> Ans) {
		answers = Ans;
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}
	
}
