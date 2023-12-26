package MenuPages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import course.Course;
import researcher.ResearchPaper;
import researcher.Researcher;
import student.Student;
import teacher.Teacher;
import utilities.DataSingleton;
import utilities.Mark;

/**
 * The StudentMenu class is a menu interface for a student, allowing them to perform various actions
 * such as adding courses, viewing their transcript, changing their password, and accessing
 * research-related features.
 */
public class StudentMenu extends UserMenu{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	Student s;
	
	public StudentMenu(Student s) {
		this.s=s;
	}
	/**
	 * The function checks if there are any courses available and prints them if there are, returning true
	 * if successful.
	 * 
	 * @return The method is returning a boolean value.
	 */
	public boolean showCourses(){
		if(DataSingleton.INSTANCE.getCourse().isEmpty()) {
			System.out.println("No courses yet...");
			return false;
		}
		utilities.Utils.printList(DataSingleton.INSTANCE.getCourse());
		return true;
	}
	/**
	 * The save() function writes data to a file.
	 */
	private void save() throws IOException {
		DataSingleton.write();
	}
	/**
	 * The exit() function prints "Bye bye" and attempts to save data, handling any IOExceptions that
	 * occur.
	 */
	private void exit() {
		System.out.println("Bye bye");
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * The function "addCourse" prompts the user to enter the name of a course, creates a new Course
	 * object with the entered name, and adds it to a list of courses.
	 */
	private void addCourse() throws IOException {
		System.out.println("Enter name of the course: ");
		DataSingleton.INSTANCE.getCourse().add(new Course(bf.readLine()));
		System.out.println("Course added! ");		
	}
	/**
	 * The function is a menu-driven program that allows the user to perform various actions such as
	 * adding a course, viewing a transcript, changing a password, viewing news, and discovering hidden
	 * talent in researching.
	 */
	public void run() throws IOException {
		try {
			welcomeMessage();
			menu : while(true){
				System.out.println("What do you want to do? \n 1) Add course \n 2) View transcript \n 3) Change password \n 4)Discover Hidden Talent of Researching \n 5)View news   \n 4) Exit");
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
					else if(choice == 4) {
						viewNews: while(true) {
							
							System.out.println(s.viewNews());
							System.out.println("\n 1) Return back \n 2) Exit");
							choice = Integer.parseInt(bf.readLine());
							if(choice==1) continue menu;
							if(choice==2) {exit();  break menu;}
							break;
						}
						
					}
				else if (choice==6){
					exit();
					break menu;
				}
				else if(choice == 5) {
					// The line `Student.ResearcherStudent studentResearcher = s.new ResearcherStudent();` is creating
					// a new instance of the inner class `ResearcherStudent` within the `Student` class. This inner
					// class is used to represent a student who is also a researcher. By creating an instance of this
					// inner class, the student is able to access and use the research-related features provided by
					// the `ResearcherStudent` class.
					Student.ResearcherStudent studentResearcher = s.new ResearcherStudent();
					discoverTalant: while(true) {
						System.out.println("\n 1) Add Research Paper 2) Print Research Papers \n 3) Calculate H-index\n 4) Return back \n 5) Exit");
						choice = Integer.parseInt(bf.readLine());
						if(choice == 1) {
							System.out.println("Name: ");
							String name = bf.readLine();
							System.out.println("Pages: ");
							int pages = Integer.parseInt(bf.readLine());
							System.out.println("Citations: ");
							int cit = Integer.parseInt(bf.readLine());
							System.out.println("Doi: ");
							String doi = bf.readLine();
							ResearchPaper rp = new ResearchPaper(name, pages, cit, doi);
							DataSingleton.INSTANCE.addResearchPapers(rp);
						}
						if(choice == 2) {
							for(ResearchPaper rp : DataSingleton.INSTANCE.getResearchPapers()) {
								for(Researcher r: rp.getAuthors()) {
									if(r.equals(studentResearcher)) System.out.println(studentResearcher.printPapers());
									
								}
							}
							
						
						}
						// The line `if(choice == 3) System.out.println(studentResearcher.calculateHIndex());` is
						// checking if the user has chosen option 3 in the menu. If they have, it calls the
						// `calculateHIndex()` method on the `studentResearcher` object, which is an instance of the
						// inner class `ResearcherStudent` within the `Student` class. This method calculates and returns
						// the H-index of the student researcher based on their research papers. The H-index is a metric
						// used to measure the productivity and impact of a researcher's work. The calculated H-index is
						// then printed to the console.
						if(choice == 3) System.out.println(studentResearcher.calculateHIndex());
						if(choice == 4) continue menu;
						if(choice == 5) {exit();  break menu;}
			}
				}
			}
		} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
			save();
		}
	}
	@Override
	// The `welcomeMessage()` method is overriding the `welcomeMessage()` method from the `UserMenu`
	// class. It is responsible for printing a welcome message specific to the `StudentMenu` class. In
	// this case, it prints "Welcome Student" followed by the name of the student.
	public void welcomeMessage() {
		System.out.println("Welcome Student "+s.getName());
		
	}

}

