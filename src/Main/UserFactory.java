package Main;

import Researcher.Researcher;
import Staff.Dean;
import Staff.Employee;
import Staff.Manager;
import Staff.TechSupportSpecialist;
import Student.Student;
import Teacher.Teacher;

public class UserFactory {
public User getUser(String userType) {
	if(userType.equals("User")) return new User() ;
	if(userType.equals("Employee")) return new Employee();
	if(userType.equals("Researcher")) return new Researcher();
	if(userType.equals("Dean")) return new Dean();
	if(userType.equals("Manager")) return new Manager();
	if(userType.equals("TechSupportSpecialist")) return new TechSupportSpecialist();
	if(userType.equals("Student")) return new Student() ;
	if(userType.equals("Teacher")) return new Teacher() ;
	return null;
}
}
