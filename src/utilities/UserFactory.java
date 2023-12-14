package utilities;


import java.io.IOException;
import staff.Dean;
import staff.Employee;
import staff.Manager;
import staff.TechSupportSpecialist;
import staff.User;
import student.Student;
import teacher.Teacher;
import researcher.EmployeeResearcher;


public  class  UserFactory {
public static User getUser(String userType) throws IOException {
	if(userType.equals("Employee")) 	{return new Employee();}
	if(userType.equals("Employee Researcher")) {return new EmployeeResearcher();}
	if(userType.equals("Dean")) {return new Dean();}
	if(userType.equals("Manager")) {return new Manager();}
	if(userType.equals("TechSupportSpecialist")) {return new TechSupportSpecialist();}
	if(userType.equals("Student")) {return new Student();}
	if(userType.equals("Teacher")) {return new Teacher();}
	return null;
}
}
