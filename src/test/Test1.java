package test;

import staff.Admin;
import student.Student;


public class Test1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Student s1 = new Student("John", "Mickey");
		System.out.println(s1.getCorparateEmail());
		System.out.println(s1.getPassword());
		System.out.println(s1.getId());
		
		Student s2 = new Student("Blow", "Mind");
		System.out.println(s2.getId());
		
		// test inner class researcher
		Student.ResearcherStudent researcherStudent = s1.new ResearcherStudent();
		researcherStudent.printPapers();
		
		
		Admin a = new Admin();
//		a.addUser(s1);
//		System.out.println( s1.getName());		
		System.out.println(a.getUsers());

	}

}
