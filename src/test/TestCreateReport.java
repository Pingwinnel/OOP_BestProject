package tests;

import staff.Manager;
import student.Schools;
import student.Student;
import utilities.DataSingleton;

public class TestCreateReport {

	public static void main(String[] args) throws Exception {
		Manager manager = new Manager();

        DataSingleton.INSTANCE.addUser(new Student("Tuba", 3.3, Schools.SITE));
        DataSingleton.INSTANCE.addUser(new Student("Aknur", 4.0, Schools.BS));
        DataSingleton.INSTANCE.addUser(new Student("Adina", 3.6, Schools.SITE));
        DataSingleton.INSTANCE.addUser(new Student("Yerasyl", 3.5, Schools.BS));

        System.out.println(manager.createReportBySchool(Schools.SITE));
        System.out.println(manager.createReportBySchool(Schools.BS));
	}

}
