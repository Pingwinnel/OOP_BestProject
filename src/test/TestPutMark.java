package test;

import course.Course;
import staff.Admin;
import staff.Manager;
import student.Schools;
import student.Student;
import teacher.Teacher;
import utilities.ResearchUniversity;

public class TestPutMark {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// for now doesnt work, because it was adapted to menu
		Admin a = new Admin();
		Student s = new Student("Akn", "Pakn");
		Teacher t = new Teacher("T", "U", Schools.SITE);
//		a.addUser(t);
//		System.out.println(a.getUsers());
		Manager m = new Manager();
//		System.out.println(m.viewInfoTeacher());
		
//		a.removeUser(3); //we delete users by ID
	
//		System.out.println(a.getUsers());
		
		Course oop = new Course("OOP", "CS10", Schools.SITE, 5);
		s.registerCourses(oop);
		
//		t.putMark(oop, s, 29.6);
		
		ResearchUniversity.INSTANCE.setWeek(15);
//		t.putMark(oop, s, 14.6);
		
		s.getMarks().entrySet().stream().forEach(n->System.out.println(n.getKey() + " " + n.getValue()));

	}

}
