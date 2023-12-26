package staff;

import java.util.Vector;

import utilities.DataSingleton;
import utilities.Utils;

/**
 * The Admin class represents an administrator who has access to user management and log file viewing
 * @author Code Symphony
 */
public class Admin extends Employee{
	
	private static final long serialVersionUID = -5079377241382479154L;

	/**
	 * Default empty constructor for the Admin class
	 */
	public Admin() {
		
	}
	
	/**
	 * Parameterized constructor for the Admin class
	 * @param surname
	 * @param name
	 * @param salary
	 */
	public Admin(String surname, String name, double salary) {
		super(surname, name, salary);
		
	}
	
	/**
     * Adds a user to the system
     * @param u The user to be added
     * @throws Exception If an error occurs while adding the user
     */
	public void addUser(User u) throws Exception {
		DataSingleton.INSTANCE.addUser(u);
	}
	
	/**
     * Retrieves a vector containing all users in the system
     * @return A vector containing all users in the system
     * @throws Exception If an error occurs while retrieving users
     */
	public Vector<User> getUsers() throws Exception {
		return DataSingleton.INSTANCE.getUsers();
	}
	
	//idk how to do it
//	public void changeUsers(User changedUser) throws Exception {
//	
//	}
	 /**
     * Removes a user from the system based on the specified ID
     * @param id The ID of the user to be removed
     * @throws Exception If an error occurs while removing the user
     */
	public void removeUser(int id) throws Exception {
		DataSingleton.INSTANCE.removeUser(id);
		
	}
	
	/**
     * Displays log files
     */
	public void seeLogFiles() {
		Utils.printList(DataSingleton.INSTANCE.getLogs());
	}

	
}
