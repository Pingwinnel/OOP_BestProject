package test;

import java.io.IOException;

import MenuPages.*;
import student.Student;

public class testStudentMenu {

	public static void main(String[] args) throws Exception {
		Student s=new Student("Yerasyil","Omirzhanov");
		studentMenu stuMenu=new studentMenu(s);
		stuMenu.run();

	}

}
