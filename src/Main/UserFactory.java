package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import Researcher.EmployeeResearcher;
import Researcher.Researcher;
import Staff.Dean;
import Staff.Employee;
import Staff.Manager;
import Staff.TechSupportSpecialist;
import Staff.managerType;
import Student.Student;
import Teacher.Teacher;

public  class  UserFactory {
@SuppressWarnings("deprecation")
public static User getUser(String userType) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	if(userType.equals("User")) return UserFacade.userSetter() ;
	if(userType.equals("Employee")) { 
		User u1=new Employee();
		u1=UserFacade.userSetter();
		Employee e1=(Employee)u1;
		System.out.println("Please enter salary:");
		e1.setSalary(Double.parseDouble( br.readLine()));
		System.out.println("Please enter hire date:");
		e1.setHireDate( new Date(br.readLine()));
		return e1;
		}
	if(userType.equals("Employee Researcher")) { 
		return (EmployeeResearcher)UserFacade.userSetter();
	
	}
	if(userType.equals("Dean")) {
		return  (Dean)UserFacade.userSetter();
	}
	if(userType.equals("Manager")) {
		User u2=UserFacade.userSetter();
		Manager m1=(Manager)u2;
		System.out.println("Please enter Type {OR, Department, Faculty} :");
		m1.setType(managerType.valueOf(br.readLine()));
		return new Manager();
	}
	if(userType.equals("TechSupportSpecialist")) { 
		return (TechSupportSpecialist)UserFacade.userSetter();
	}
	if(userType.equals("Student")) { 
		return (Student)UserFacade.userSetter();
	}
	if(userType.equals("Teacher")) { 
		User u3=UserFacade.userSetter();
		Employee e1=(Employee)u3;
		System.out.println("Please enter salary:");
		e1.setSalary(Double.parseDouble( br.readLine()));
		System.out.println("Please enter hire date:");
		e1.setHireDate( new Date(br.readLine()));
		return e1;
	}
	return null;
}
}
