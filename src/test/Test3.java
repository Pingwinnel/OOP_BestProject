package test;


import researcher.EmployeeResearcher;
import researcher.ResearchPaper;
import student.GraduateStudent;
import student.Student;
import teacher.Professor;
import teacher.Teacher;
import utilities.DataSingleton;

public class Test3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		EmployeeResearcher emr = new EmployeeResearcher();
		Student s1 = new Student("My", "First");
		Student.ResearcherStudent sr1 = s1.new ResearcherStudent();
		GraduateStudent g1 = new GraduateStudent();
		Teacher t1 = new Teacher();
		Professor p1 = new Professor();
		
		ResearchPaper r1 = new ResearchPaper("Emotions", 60, 5, "SGS6889HH");
		DataSingleton.INSTANCE.addResearchPapers(r1);
		r1.addAuthor(emr);
		ResearchPaper r2 = new ResearchPaper("Emotions", 60, 10, "SGS6889HH");
		DataSingleton.INSTANCE.addResearchPapers(r2);
		r2.addAuthor(emr);
		ResearchPaper r3 = new ResearchPaper("Emotions", 60, 3, "SGS6889HH");
		DataSingleton.INSTANCE.addResearchPapers(r3);
		r3.addAuthor(emr);
		ResearchPaper r4 = new ResearchPaper("Emotions", 60, 2, "SGS6889HH");
		DataSingleton.INSTANCE.addResearchPapers(r4);
		r4.addAuthor(emr);
		ResearchPaper r5 = new ResearchPaper("Emotions", 60, 9, "SGS6889HH");
		DataSingleton.INSTANCE.addResearchPapers(r5);
		r5.addAuthor(emr);
		
		
		System.out.println(emr.calculateHIndex());
		

	}

}
