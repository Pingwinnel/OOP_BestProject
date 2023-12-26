package test;

import java.io.IOException;

import MenuPages.*;
import staff.Admin;
import student.Student;

public class TestStudentMenu {

	public static void main(String[] args) throws Exception {
		Student s=new Student("Yerasyil","Omirzhanov");
		
		StudentMenu stuMenu=new StudentMenu(s);
		stuMenu.run();

	}

}
