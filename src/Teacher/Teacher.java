package Teacher;

import Staff.Employee;
import Student.Course;
import Student.Days;
import Student.Mark;
import Student.Student;

public class Teacher extends Employee{
 public void putMark(Student s,Course cou,Double grade) {
	  s.getMarks().get(cou).setDigitGrades(grade);
	}
 }
