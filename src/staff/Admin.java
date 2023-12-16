package staff;

import java.util.Vector;

import utilities.DataSingleton;

public class Admin extends Employee{
	DataSingleton s = DataSingleton.getInstance();
	
	public Admin() {
		
	}
	
	public Admin(String surname, String name, double salary) {
		super(surname, name, salary);
		
	}
	
	public void addUser(User u) throws Exception {
		s.addUser(u);
	}
	
	public DataSingleton getUsers() throws Exception {
		return s.getUsers();
	}
	
	public void changeUsers(User changedUser) throws Exception {
	
	}
	public void removeUser(User u) throws Exception {
		s.removeUser(u);
		
	}
	
	

	
}
