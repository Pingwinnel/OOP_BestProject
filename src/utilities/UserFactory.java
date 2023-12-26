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

/**
 * The UserFactory class is responsible for creating instances of various user types
 * @author Code Symphony
 */
public  class  UserFactory {
	/**
     * Creates and returns an instance of the specified user type
     * @param userType
     * @return An instance of the specified user type or null if the user type is not recognized
     * @throws IOException If an I/O error occurs while creating the user instance
     */
public static User getUser(String userType) throws IOException {
	if(userType.equals("Employee Researcher")) {return new EmployeeResearcher();}
	if(userType.equals("Dean")) {return new Dean();}
	if(userType.equals("Manager")) {return new Manager();}
	if(userType.equals("TechSupportSpecialist")) {return new TechSupportSpecialist();}
	if(userType.equals("Student")) {return new Student();}
	if(userType.equals("Teacher")) {return new Teacher();}
	return null;
}
}
