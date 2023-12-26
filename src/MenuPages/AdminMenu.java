package MenuPages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import staff.Admin;
import teacher.Teacher;
import utilities.DataSingleton;

public class AdminMenu {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	private void write() throws IOException{
		DataSingleton.write();
	}
	
	private void exit() {
		System.out.println("Bye bye");
		try {
			DataSingleton.write();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public AdminMenu(Admin a) throws NumberFormatException, IOException {
		menu: while(true) {
			System.out.println("Welcome, what do you want to do? \n 1) Add user \n 2) Remove user by id");
			int choice = Integer.parseInt(bf.readLine());
			if(choice == 1) {
				addUser: while(true) {
					System.out.println("1) Teacher \n 2) Manager \n 3) Student \n 4) Dean \n 5) Techsupport specialist \n 6) Employee Researcher");
					String userType = bf.readLine();
					System.out.println("Name: ");
					String userName = bf.readLine();
					System.out.println("Surname: ");
					String userSurname = bf.readLine();
					if(userType.equals("Teacher")) {
						System.out.println("School: SAM/SITE/BS");
						//Schools school = bf.readLine();
						Teacher t = new Teacher(userSurname, userName);
					}
					
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
			}
		}
		
	}
	
	
	
}
