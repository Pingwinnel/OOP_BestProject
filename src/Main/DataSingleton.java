package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public final class DataSingleton{
	private static final DataSingleton DB = new DataSingleton();
	private static Vector<User> users;
	private DataSingleton() {
		
	}
	
	public static DataSingleton getInstance() {
		return DB;
	}
	
	static {
		if(new File("data.ser").exists()) {
			try {
				users = readUsers();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else users = new Vector<User>();
	}

	public static Vector<User> readUsers() throws Exception {
		FileInputStream fis = new FileInputStream("data.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Vector<User> users = (Vector<User>)ois.readObject();
		fis.close(); ois.close();
		return users;
	}
	
	public void saveUsers() throws Exception {
		FileOutputStream fos = new FileOutputStream("data.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(users);
		oos.close(); fos.close();
	}
	
	public void addUser(User u) throws Exception {
		users.add(u);
		saveUsers();
		
	}
	public Vector<User> getUsers() throws Exception {
		return readUsers();
	}
//	
//	public void getUser() {
//		for(User e: users) {
//			System.out.println(e);
//		}
//	}
//	
	public void removeUser(User u) {
		users.remove(u);
		
		
	}
}
