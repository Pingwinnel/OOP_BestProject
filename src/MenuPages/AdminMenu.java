package MenuPages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import researcher.EmployeeResearcher;
import staff.Admin;
import staff.Dean;
import staff.Manager;
import staff.ManagerType;
import staff.TechSupportSpecialist;
import student.Major;
import student.Schools;
import student.Student;
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
	 * @throws Exception 
	 */
	public AdminMenu(Admin a) throws Exception {
		menu: while(true) {
			System.out.println("Welcome, what do you want to do? \n 1) Add user \n 2) Remove user by id \n 3) Exit");
			int choice = Integer.parseInt(bf.readLine());
			if(choice == 1) {
				addUser: while(true) {
					System.out.println("1) Teacher \n 2) Manager \n 3) Student \n 4) Dean \n 5) TechSupportSpecialist \n 6) EmployeeResearcher \n 7) Create another user \n 8) Return back \n 9) Exit");
					choice = Integer.parseInt(bf.readLine());
					System.out.println("Surname: ");
					String userSurname = bf.readLine();
					System.out.println("Name: ");
					String userName = bf.readLine();
					System.out.println("Password: ");
					String pass = bf.readLine();
					
					if(choice == 1) {
						System.out.println("School: SAM/SITE/BS:");
						Schools school = Schools.valueOf(bf.readLine()); 
						System.out.println("Degree: TUTOR / LECTURER / SENIOR_LECTURER / PROFESSOR:");
						Degree degree = Degree.valueOf(bf.readLine());
						if(degree.equals(Degree.PROFESSOR)) {
							Professor p = new Professor(userName, userSurname, school);
							p.changePassword(pass);
							a.addUser(p);
						}else {
							Teacher t = new Teacher(userSurname, userName, school, degree);
							t.changePassword(pass);
							a.addUser(t);
						}
					}
					if(choice == 2) {
						System.out.println("ManagerType: OR, DEPARTMENT, SCHOOL:");
						ManagerType mt = ManagerType.valueOf(bf.readLine());
						Manager m = new Manager(userSurname, userName, mt);
						m.changePassword(pass);
						a.addUser(m);
					}
					if(choice == 3) {
						System.out.println("School: SAM/SITE/BS:");
						Schools school = Schools.valueOf(bf.readLine()); 
						System.out.println("Major: IS, AaC, CSaS, IM:");
						Major major = Major.valueOf(bf.readLine()); 
						System.out.println("Year of study: ");
						int yos = Integer.parseInt(bf.readLine());
						Student m = new Student(userSurname, userName, school, major, yos);
						m.changePassword(pass);
						a.addUser(m);
					}
					if(choice == 4) {
						System.out.println("School: SAM/SITE/BS:");
						Schools school = Schools.valueOf(bf.readLine()); 
						Dean m = new Dean(userSurname, userName, school);
						m.changePassword(pass);
						a.addUser(m);
					}
					if(choice == 5) {
						TechSupportSpecialist m = new TechSupportSpecialist(userSurname, userName);
						m.changePassword(pass);
						a.addUser(m);
					}
					if(choice == 6) {
						EmployeeResearcher m = new EmployeeResearcher(userSurname, userName);
						m.changePassword(pass);
						a.addUser(m);
					}
					
					if(choice==7) continue addUser;
					if(choice==8) continue menu;
					if(choice==9) {exit();  break menu;}
					break;
					
				}
			}
			if(choice == 2) {
				removeUser: while(true) {
					System.out.println("ID of a user you want to delete");
					int id = Integer.parseInt(bf.readLine());
					a.removeUser(id);
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
			}
			if(choice==3) {exit();  break menu;}
		}
		
	}
	
	
	
}
