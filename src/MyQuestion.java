import java.util.ArrayList;

interface MyQuestion {

	public void setQuestion(String question);
	
	public void setOptions(ArrayList<String> options);
	
	public void setAnswers(ArrayList<String> Ans);
	
	public String getQuestion();
	
	public ArrayList<String> getOptions();
	
	public ArrayList<String> getAnswers();
	
}