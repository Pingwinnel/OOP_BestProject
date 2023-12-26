package MenuPages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import course.Course;
import student.Student;
import utilities.DataSingleton;
import utilities.Mark;

public class StudentMenu extends UserMenu{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	Student s;
	
	public StudentMenu(Student s) {
		this.s=s;
	}
	public boolean showCourses(){
		if(DataSingleton.INSTANCE.getCourse().isEmpty()) {
			System.out.println("No courses yet...");
			return false;
		}
		utilities.Utils.printList(DataSingleton.INSTANCE.getCourse());
		return true;
	}
	private void save() throws IOException {
		DataSingleton.write();
	}
	private void exit() {
		System.out.println("Bye bye");
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void addCourse() throws IOException {
		System.out.println("Enter name of the course: ");
		DataSingleton.INSTANCE.getCourse().add(new Course(bf.readLine()));
		System.out.println("Course added! ");		
	}
	private void addCourseToStudent(Student s) throws NumberFormatException, IOException {
		int i = Integer.parseInt(bf.readLine())-1;
		Course c = DataSingleton.INSTANCE.getCourse().get(i);
		if(!s.getMarks().containsKey(c)) {
			s.getMarks().put(c, new Mark());
			System.out.println("Course "+DataSingleton.INSTANCE.getCourse().get(i) +" added to  "+s.getName());	
		}
		else System.out.println("Student " + s.getName()+ " already registered to "+c);
	}
	public void run() throws IOException {
		try {
			welcomeMessage();
			menu : while(true){
				System.out.println("What do you want to do? \n 1) Add course \n 2) View transcript \n 3) Change password  \n 4) Exit");
				int choice = Integer.parseInt(bf.readLine());
					if (choice==1){
					addCourse: while(true){
						addCourse();
						System.out.println("\n 1) Add another course  \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(bf.readLine());
						if(choice==1) continue addCourse;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
					else if (choice==2){
						s.viewTranscript();
						System.out.println("\n 1) Return back \n 2) Exit");
						transcript : while (true) {
						choice=Integer.parseInt(bf.readLine());
						if(choice==1) continue menu;
						if(choice==2) {exit();  break menu;}
						break;
							
						}
					}
					else if (choice==3){
						System.out.println("Print new passord: ");
						String pass=bf.readLine();
						s.changePassword(pass);
						System.out.println("Password succesfuly changed");
					}
				else if (choice==4){
					exit();
					break menu;
				}
			}
		} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
			save();
		}
	}
	@Override
	public void welcomeMessage() {
		System.out.println("Welcome Student "+s.getName());
		
	}

}

