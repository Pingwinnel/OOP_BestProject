package Teacher;

import Staff.Employee;
import Student.Course;
import Student.Days;
import Student.Mark;
import Student.Student;

public class Teacher extends Employee{
 public void putMark(Student s,Course cou,String str) {
	 double grade;
	 boolean toStr=false;
	 try {
		grade=Double.parseDouble(str);
	} catch (Exception e) {
		System.out.println("Somthing went wrong");
		toStr=true;
	}
	if(toStr) {
		s.setMarks(new Mark(str), cou);
		toStr=false;
	}
	}
 }
