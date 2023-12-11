package utilities;

import java.util.Comparator;


import Student.Student;

public class GpaComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return Double.compare(o1.getGpa(), o2.getGpa());
	}

}
