package Researcher;

import Staff.Employee;
import Student.Student;

public class TestResercher {

	public static void main(String[] args) {
		Employee e = new Employee(1, "Seidazym", "Aknur", "a_se", "1234", 200000);
		Student s = new Student();
//		Researcher r = ResearchFactory.makeResearcher(e);
//		r.getResearchPapers();
		
//		Researcher r1 = (Researcher) e;
//		r1.getResearchPapers();
		
//		Researcher r = (Researcher)Employee.makeMeRes(e);
//		System.out.println(r);
//		System.out.println(r.getSalary());
//		r.getResearchPapers();
		
		Researcher e1 = new Researcher(e.getId(), e.getSurname(), e.getName(), e.getCorparateEmail(), e.getPassword(), e.getSalary());
		e1.setName("Aknur emes");
		
		System.out.println(e1);
		
//		e1.getResearchPapers();
		
		System.out.println(e);
		
		
		

	}

}
