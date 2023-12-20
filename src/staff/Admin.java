package staff;

import java.util.Vector;

import utilities.DataSingleton;
import utilities.Utils;

public class Admin extends Employee{
	
	public Admin() {
		
	}
	
	public Admin(String surname, String name, double salary) {
		super(surname, name, salary);
		
	}
	
	public void addUser(User u) throws Exception {
		DataSingleton.INSTANCE.addUser(u);
	}
	
	public Vector<User> getUsers() throws Exception {
		return DataSingleton.INSTANCE.getUsers();
	}
	
	//idk how to do it
//	public void changeUsers(User changedUser) throws Exception {
//	
//	}
	public void removeUser(int id) throws Exception {
		DataSingleton.INSTANCE.removeUser(id);
		
	}
	
	public void seeLogFiles() {
		Utils.printList(DataSingleton.INSTANCE.getLogs());
	}

	
}
