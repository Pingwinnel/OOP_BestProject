package MenuPages;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import course.Course;
import student.Student;
import utilities.DataSingleton;
import utilities.Mark;

public class studentMenu extends UserMenu{
	Scanner in = new Scanner(System.in);
	Student s;
	
	public studentMenu() throws Exception {
		System.out.println("Enter name: ");
		DataSingleton.INSTANCE.addUser(new Student(in.next()));
		System.out.println("Student added! ");
	}
	public studentMenu(Student s) {
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
	private void addCourse() {
		System.out.println("Enter name of the course: ");
		DataSingleton.INSTANCE.getCourse().add(new Course(in.next()));
		System.out.println("Course added! ");		
	}
	private void addCourseToStudent(Student s) {
		int i = in.nextInt()-1;
		Course c = DataSingleton.INSTANCE.getCourse().get(i);
		if(!s.getMarks().containsKey(c)) {
			s.getMarks().put(c, new Mark());
			System.out.println("Course "+DataSingleton.INSTANCE.getCourse().get(i) +" added to  "+s.getName());	
		}
		else System.out.println("Student " + s.getName()+ " already registered to "+c);
	}
	public void run() throws IOException {
		try {
			System.out.println("Welcome!");
			menu : while(true){
				System.out.println("What do you want to do? \n 1) Add course  \n 2) Exit");
				int choice = in.nextInt();
					if (choice==1){
					addCourse: while(true){
						addCourse();
						System.out.println("\n 1) Add another course  \n 2) Return back \n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue addCourse;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				else if (choice==2){
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

