package com.frank;

import java.util.HashMap;
import java.util.Map;

public class StudentDatabase {

	public static final int NUM_QUIZZES = 10;
	public static final int MIN_GRADE = 0;
	public static final int MAX_GRADE = 100;
	
	private HashMap<String, int[]>quizMarks = new HashMap<>();
	
	private String formatName(String name) {
		return name;
	}
	
	
	public void addStudent(String studentName) {
		quizMarks.put(studentName, new int[] {MIN_GRADE, MIN_GRADE, MIN_GRADE,MIN_GRADE, MIN_GRADE, MIN_GRADE,MIN_GRADE, MIN_GRADE, MIN_GRADE, MIN_GRADE});
	}
	
	public void displayQuizzes(String student) {
		System.out.println(quizMarks.get(student));
	}

	public void changeQuizMark(String studentName, int whichQuiz, int newMark) throws Exception {
		int[] tmp = quizMarks.get(studentName);
		
		if( tmp == null) {
			throw new Exception("There is no student by that name fucker!!!");
		}
		
		if( whichQuiz >= tmp.length) {
			throw new Exception("There is no quiz with that number fucker!!!");
		}
		
		
		tmp[whichQuiz] = newMark;
		quizMarks.put(studentName, tmp);
	}
	
	public void showQuizMarks() {
		for(Map.Entry<String, int[]> entry: quizMarks.entrySet()) {
			String key = entry.getKey();
			int[] num = entry.getValue();
			System.out.println("Quiz marks for : "+ key);
			for(int i =0; i < num.length; i++) {
				System.out.print(num[i] +" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception {
		StudentDatabase sd = new StudentDatabase();
		
		sd.addStudent("Frank");
		sd.addStudent("Ham");
		sd.addStudent("SexySinny");
		
		sd.changeQuizMark("SexySinny", 0, 100);
		sd.changeQuizMark("SexySinny", 1, 100);
		sd.changeQuizMark("SexySinny", 2, 100);
		sd.changeQuizMark("SexySinny", 3, 100);
		sd.changeQuizMark("SexySinny", 4, 100);
		sd.changeQuizMark("SexySinny", 5, 100);
		sd.changeQuizMark("SexySinny", 6, 100);
		sd.changeQuizMark("SexySinny", 7, 100);
		sd.changeQuizMark("SexySinny", 8, 100);
		sd.changeQuizMark("SexySinny", 9, 100);
		
		sd.showQuizMarks();
	}
}
