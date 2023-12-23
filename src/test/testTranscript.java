package test;

import java.io.IOException;

import course.Course;
import staff.Manager;
import student.Major;
import student.Schools;
import student.Student;
import teacher.Teacher;
import utilities.Mark;

public class testTranscript {

	public static void main(String[] args) throws IOException {
		Student s=new Student("Omirzhanov","Yerasyil",Schools.SITE,Major.IS);
		Manager m=new Manager();
		Course oop=new Course("OOP","IS24132",Schools.SITE,3);
		Teacher t1=new Teacher();
		s.getMarks().put(oop, new Mark(30,30,36));
		s.viewTranscript();
	}

}
