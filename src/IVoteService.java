import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;


public class IVoteService {
	private MultipleChoiceQuestion qstn1;
	private YesNoQuestion qstn2;
	private int questionType;
	//store the arguments in SimulationDriver to the corresponding Question Type.
	void configQA(int t, String qstn, ArrayList<String> o, ArrayList<String> ans) {
		questionType = t;
		if (questionType == 0) {
			qstn1 = new MultipleChoiceQuestion();
			qstn1.setQuestion(qstn);
			qstn1.setOptions(o);
			qstn1.setAnswers(ans);
		}
		else if (questionType == 1) {
			qstn2 = new YesNoQuestion();
			qstn2.setQuestion(qstn);
			qstn2.setOptions(o);
			qstn2.setAnswers(ans);
		} else {
			System.out.println("No such question type");
		}
		printQuestion();
		
	}
	void printQuestion() {
		if (questionType == 0) {
			System.out.println(qstn1.getQuestion());
			for(int i = 0; i < qstn1.getOptions().size();i++){
				System.out.println(qstn1.getOptions().get(i));
			}
		}
		else if (questionType == 1) {
			System.out.println(qstn2.getQuestion());
			for(int i = 0; i < qstn2.getOptions().size();i++){
				System.out.println(qstn2.getOptions().get(i));
			}
		} else {
			System.out.println("Invalid question type");
		}
	}
	void voteProcess(Hashtable<Integer, Student> table) {
		Iterator<Entry<Integer, Student>> itr;
		Entry<Integer, Student> temp;
		String stuAns;
		int[] fullResult;
		String[] realAnswer = null;
		
		if (questionType == 0) {
			realAnswer = new String[] {"A", "B", "C", "D"};
		}
		else if (questionType == 1) {
			realAnswer = new String[] {"1", "2"};
		}
		else
			System.out.println("Invalid question type");
		
		fullResult = new int[realAnswer.length];
		itr = table.entrySet().iterator();
		//stuAns get the answers of the student. splitAns will split the string out to separate
		//indexes. The character in each index is then compared to the character for each possible
		//answer. If they are equal, the total for that character is incremented. Otherwise, keep
		//running through the students remaining answer.
		while (itr.hasNext()) {
		    temp = itr.next();
		    stuAns = temp.getValue().getAnswers();
		    String[] splitAns = stuAns.split("");
			for (int i = 0; i < splitAns.length; i++) {
				for (int j = 0; j < realAnswer.length; j++) {
					if (splitAns[i].equals(realAnswer[j])) {
						fullResult[j]++;
					}
				}
			}
		}
		
		printResults(realAnswer, fullResult);
		printAnswers();
	}
		void printResults(String[] realAnswer, int[] fullResult) {
			int totalCount = 0;
			System.out.println("Results:");
			for (int i = 0; i < realAnswer.length; i++) {
				System.out.println(realAnswer[i] + " : " + fullResult[i] + "");
				totalCount = totalCount + fullResult[i];
			}			
			System.out.println("Number of students answers: " + totalCount);
		}
		
		void printAnswers() {
			if (questionType == 0) {
				System.out.println("Answer: " + qstn1.getAnswers());
			}
			else if (questionType == 1) {
				System.out.println("Answer: " + qstn2.getAnswers());
			} else {
				System.out.println("Invalid answer");
			}
		}
}
