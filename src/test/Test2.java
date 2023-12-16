package test;

import course.Course;
import course.School;
import staff.Manager;
import staff.ManagerType;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Course oop = new Course("OOP", "CS201", School.FIT, 4);
		
		Manager m1 = new Manager("Saule", "Marat", 10000, ManagerType.OR);
		m1.addCoursesForRegis(oop);
		
		


	}

}
