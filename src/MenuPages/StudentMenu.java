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

public class StudentMenu {
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
	public void run() throws IOException {
		try {
			System.out.println("Welcome Student "+s.getName() + " " + s.getSurname());
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


}

