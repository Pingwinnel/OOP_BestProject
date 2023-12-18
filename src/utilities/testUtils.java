package utilities;

import student.Major;
import student.Schools;
import student.Student;
import staff.Admin;

public class testUtils  {

	public static void main(String[] args) throws Exception {
		Admin ad=new Admin();
		Student s=new Student("Omirzhanov", "Yerasyl",Schools.BS,Major.IS);
		ad.addUser(s);
		System.out.println(DataSingleton.INSTANCE.getStudents());
	}

}
