package wproject;

import java.util.Vector;

public class Admin extends Employee{
	DataSingleton s = DataSingleton.getInstance();
	
	public Admin() {
		super();
	}
	
	public Admin(int id, String surname, String name, String corparateEmail, String password, double salary) {
		super(id, surname, name, corparateEmail, password, salary);
		
	}
	
	public void addUser(User u) throws Exception {
		s.addUser(u);
	}
	
	public Vector<User> getUsers() throws Exception {
		return s.getUsers();
	}
	
	public void removeUser(User u) {
		s.removeUser(u);
	}

	
	
	
	
}
