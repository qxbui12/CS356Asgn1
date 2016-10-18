import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

//SimulationDriver is used to run the program. Two cases are tested, one using multiple choice
//answer, the other one using single choice yes no answer.

public class SimulationDriver {
	
	private static Random random = new Random();
	private static int questionType;
	private static IVoteService run;
	private static Hashtable<Integer, Student> table;
	
	public static void main(String[] args) {
		iVoteProgram();
	}
	
	// Start iClickerServices and initialize questions and answers
	private static void iVoteProgram() {
		run = new IVoteService();
		
		System.out.println("Multiple Choice Question");
		questionType = 0;
		String qstn1 = "Which of the following are car makers?";
		//Answer choices
		ArrayList<String> choice1 = new ArrayList<String>();
		choice1.add("A. Mercedes Benz");
		choice1.add("B. Viper");
		choice1.add("C. Jaguar");
		choice1.add("D. Lion");
		//Correct answers
		ArrayList<String> ans1 = new ArrayList<String>();
		ans1.add("A");
		ans1.add("C");
		//add question, choices, and answers to the question class
		run.configQA(questionType, qstn1, choice1, ans1);
		randomStudentAnswers();
		
		System.out.println();
		
		System.out.println("Yes No Question");
		questionType = 1;
		String qstn2 = "Are you a human?";  
		ArrayList<String> choice2 = new ArrayList<String>();
		choice2.add("1. Yes");
		choice2.add("2. No");
		ArrayList<String> ans2 = new ArrayList<String>();
		ans2.add("1");
		//add question, choices, and answers to the question class
		run.configQA(questionType, qstn2, choice2, ans2);
		randomStudentAnswers();
	}
	
	
	// Generates student IDs and answers and stores data to hashtable
	private static void randomStudentAnswers() {
		int numberOfStudentsAns = random.nextInt(32) + 3;
		table = new Hashtable<Integer, Student>();
		for (int i = 0; i <= numberOfStudentsAns; i++) {
			int studentID = random.nextInt(50) + 1;
			int studentChoices = 0;
			String possibleAns = "";
			char[] temporaryAnswer;
			char selectRandom;
			
			//In multiple choice question, students can have maximum all 4 choices
			//In single choice question, students can only have 1 choice.
			if (questionType == 0) {
				possibleAns = "ABCD";
				studentChoices = random.nextInt(4) + 1;
			} else if (questionType == 1) {
				possibleAns = "12";
				studentChoices = 1;
			} else {
				System.out.println("Invalid question type");
			}
			temporaryAnswer = new char[studentChoices];
			
			//This is use to simulate student answers. 
			// selectRandom get a random character from possibleAns. Then temporaryAnswer checks
			// if that character has been stored. If not, it will store that character. Otherwise,
			// another random character will be selected. This makes sure that a student won't
			//have the same answer repeated.
			for (int j = 0; j < temporaryAnswer.length; j++) {
				 selectRandom= possibleAns.charAt(random.nextInt(possibleAns.length()));
				while ((String.valueOf(temporaryAnswer).contains(String.valueOf(selectRandom)))) {
					selectRandom = possibleAns.charAt(random.nextInt(possibleAns.length()));
				}
				temporaryAnswer[j] = selectRandom;
			}
			
			String studentAnswers = new String(temporaryAnswer);
			
			// If studentID is not unique, remove the old studentID in the table, then overwrite it
			//with the new key.
			if (table.containsKey(studentID)) {
				table.remove(studentID);
			}
			table.put(studentID, new Student(studentID, studentAnswers));
			
		}
		System.out.println("Number of students: " + table.size());
		
		// Process all students vote in the Hashtable
		run.voteProcess(table);
		
	}

}
