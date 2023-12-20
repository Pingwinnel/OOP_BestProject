package test;

import java.io.IOException;

import course.Course;
import staff.Manager;
import student.Major;
import student.Schools;
import student.Student;
import teacher.Teacher;

public class testTranscript {

	public static void main(String[] args) throws IOException {
		Student s=new Student("Omirzhanov","Yerasyil",Schools.FIT,Major.IS);
		Manager m=new Manager();
		Course oop=new Course("OOP","IS24132",Schools.FIT,3);
		Teacher t1=new Teacher();
		t1.putMark(oop, s, null);
		m.addCoursesForRegis(oop);
		s.registerCourses(oop);
	}

}
