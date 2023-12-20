package test;

import utilities.Mark;

public class TestLetterGrade {

	public static void main(String[] args) {
		Mark m1 = new Mark();
		m1.setAtt1(15);
		m1.setAtt2(15);
		m1.setFinalExamScore(36);
		
		System.out.println(m1.getScore());
		System.out.println(m1.getLetterGrade());
		
		Mark m2 = new Mark(26, 29, 40);
		System.out.println(m2);
		

	}

}
