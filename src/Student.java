// Student class with constructor for studentID and student answers
public class Student {

	private int ID;
	private String answer;
	
	public Student(int studentID, String studentAnswers) {
		ID = studentID;
		answer = studentAnswers;
	}

	void setStudentID(int studentID) {
		ID = studentID;
	}
	
	int getStudentID() {
		return ID;
	}
	
	void setAnswers(String answer) {
		this.answer = answer;
	}
	
	String getAnswers() {
		return answer;
	}
}