package MenuPages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import staff.Admin;
import student.Schools;
import teacher.Degree;
import teacher.Professor;
import teacher.Teacher;
import utilities.DataSingleton;

/**
 * The AdminMenu class provides a menu interface for an admin user to perform various actions such as
 * adding and removing users.
 */
public class AdminMenu {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * The write() function calls the write() method of the DataSingleton class and handles any
	 * IOException that may occur.
	 */
	private void write() throws IOException{
		DataSingleton.write();
	}
	
	/**
	 * The exit() function prints "Bye bye" and then calls the write() function from the DataSingleton
	 * class to write data to a file.
	 */
	private void exit() {
		System.out.println("Bye bye");
		try {
			DataSingleton.write();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * The admin menu start runner
	 * @param a
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public AdminMenu(Admin a) throws NumberFormatException, IOException {
		menu: while(true) {
			System.out.println("Welcome, what do you want to do? \n 1) Add user \n 2) Remove user by id");
			int choice = Integer.parseInt(bf.readLine());
			if(choice == 1) {
				addUser: while(true) {
					System.out.println("1) Teacher \n 2) Manager \n 3) Student \n 4) Dean \n 5) Techsupport specialist \n 6) Employee Researcher \n 7) Return back \n 8) Exit");
					String userType = bf.readLine();
					System.out.println("Name: ");
					String userName = bf.readLine();
					System.out.println("Surname: ");
					String userSurname = bf.readLine();
					if(userType.equals("Teacher")) {
						System.out.println("School: SAM/SITE/BS");
						Schools school = Schools.valueOf(bf.readLine()); 
						System.out.println("Degree: TUTOR / LECTURER / SENIOR_LECTURER / PROFESSOR");
						Degree degree = Degree.valueOf(bf.readLine());
						if(degree.equals(Degree.PROFESSOR)) {
							Professor p = new Professor(userName, userSurname, school);
						}else {
							Teacher t = new Teacher(userSurname, userName, school, degree);
						}
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
