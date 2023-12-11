package wproject;

import Main.Admin;
import Main.UserFactory;
import Staff.Employee;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Employee e = new Employee(1, "Seidazym", "Aknur", "a_se", "1234", 200000);
		Employee e2 = (Employee) UserFactory.getUser("Employee");
		Admin a = new Admin();
		System.out.println(e2);
		System.out.println("----------");
	}

}
