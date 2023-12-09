package wproject;

import Main.Admin;
import Staff.Employee;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Employee e = new Employee(1, "Seidazym", "Aknur", "a_se", "1234", 200000);
		Employee e1 = new Employee(2, "Seidazym", "B", "a_se", "1234", 200000);
		Admin a = new Admin();
		a.addUser(e);
		a.addUser(e1);
		
		a.removeUser(e);
		System.out.println("----------");
		System.out.println(a.getUsers());
		

	}

}
