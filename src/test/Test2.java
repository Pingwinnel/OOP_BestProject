package test;

import java.io.IOException;

import course.Course;
import staff.Manager;
import staff.ManagerType;
import student.Schools;

public class Test2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Course oop = new Course("OOP", "CS201", Schools.SITE, 4);
		
		Manager m1 = new Manager("Saule", "Marat", 10000, ManagerType.OR);
		m1.addCoursesForRegis(oop);
		
		


	}

}
