package MenuPages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import course.Course;
import course.Days;
import course.Lesson;
import course.LessonType;
import course.Time;
import researcher.ResearchPaper;
import researcher.Researcher;
import staff.Admin;
import staff.Manager;
import student.Major;
import student.Schools;
import student.Student;
import teacher.Teacher;
import utilities.DataSingleton;
import utilities.News;
import utilities.ResearchUniversity;

public class TeacherMenu {
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
	private void printList(List list) {
		for(int i = 0; i<list.size(); i++) {
			System.out.println(i+1 + ")" + list.get(i));
		}
		
		
	}

	public TeacherMenu(Teacher t) throws Exception {
		System.out.println("Welcome, " + t.getName() + " " + t.getSurname() + "!");
		menu: while(true) {
			System.out.println("What do you wanna do?\n 1) Change Password \n 2) View News \n 3) View Lessons \n 4) View Students' Info \n 5) Put Mark \n 6) Send Request \n 7) Send Message \n 8) Get Message \n 9) Send Complaint\n 10) Discover Hidden Talent of Researching \n 11) University journal \n 12) Exit");
			int choice = Integer.parseInt(bf.readLine());
			if(choice == 1) {
				changePassword: while(true) {
					String newPassword = bf.readLine();
					t.changePassword(newPassword);
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
			}
			else if(choice == 2) {
				viewNews: while(true) {
					
					System.out.println(t.viewNews());
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
				
			}
			else if(choice == 3) {
				viewLessons: while(true) {
					System.out.println(t.getLessons());
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
			}
			else if(choice == 4) {
				studentsInfo: while(true) {
					printList(t.getLessons());
					choice = Integer.parseInt(bf.readLine());
					Lesson l = t.getLessons().get(choice-1);
					
					// choose lesson first then show students
					printList(t.viewStudentInfo(l));
					System.out.println("\n 1) View Students of another Lesson \n 2) Return back \n 3) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue studentsInfo;
					if(choice==1) continue menu;
					if(choice==3) {exit();  break menu;}
					break;
				}
			}
			else if(choice == 5) {
				putMark: while(true) {
					System.out.println("Choose a lesson: ");
					printList(t.getLessons());
					int choice1 = Integer.parseInt(bf.readLine());
					Lesson l = t.getLessons().get(choice1-1);
					System.out.println("Choose a student: ");
					printList(t.viewStudentInfo(l));
					int choice2 = Integer.parseInt(bf.readLine());
					Student s = t.viewStudentInfo(l).get(choice2-1);
					System.out.println("Double mark: ");
					double choice3 = Double.parseDouble(bf.readLine());
					t.putMark(l, s, choice3);
					System.out.println("Mark is putted");
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
			}
			else if(choice == 6) {
				sendRequest: while(true) {
					
				}
			}
			else if(choice == 10) {
				discoverTalant: while(true) {
					Teacher.TeacherResearcher teacherResearcher = t.new TeacherResearcher();
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
								if(r.equals(teacherResearcher)) System.out.println(teacherResearcher.printPapers());
								
							}
						}
						
					
					}
					if(choice == 3) System.out.println(teacherResearcher.calculateHIndex());
					if(choice == 4) continue menu;
					if(choice == 5) {exit();  break menu;}
					break;
				}
			}
			else if(choice == 12) {
				exit();
			}
			
		}
//		System.out.println("Choose lesson:");
//		menu: while(true) {
//			printList(DataSingleton.INSTANCE.getTeachers().get(0).getLessons());
//			
//			Lesson l = DataSingleton.INSTANCE.getTeachers().get(0).getLessons().get(Integer.parseInt(bf.readLine())-1);
//			
//			System.out.println("Choose student:");
//			if(!t.showStudent(l)) continue menu;
//			
//			t.putMark(l);
//			System.out.println("2 - exit, 1 - put mark for another student");
//			int choice = Integer.parseInt(bf.readLine());
//			if(choice == 1) continue menu;
//			if(choice == 2) {
//				DataSingleton.write();
//				break menu;
//			
//			}
//		}
	}
	
	
	public static void main(String[] args) throws Exception {
		//for now test class is here
		Admin a = new Admin();
//		
		Course oop = new Course("OOP", "CS10", Schools.SITE, 3);
		Course algo = new Course("ADS", "CS12", Schools.SITE, 3);
		
//		Student s = DataSingleton.INSTANCE.getStudents().elementAt(0);
		Student s1 = new Student("OOP", "Pakn", Schools.SITE, Major.IS);
		Student s2 = new Student("Algo", "Pakn", Schools.SITE, Major.IM);
		Teacher t = new Teacher("T", "U", Schools.SITE);
//		Teacher t = DataSingleton.INSTANCE.getTeachers().get(0);
		Lesson oopL1 = new Lesson(oop, Days.TUE, LessonType.PRACTICE, new Time(14,30));
		Lesson adsL1 = new Lesson(algo, Days.MON, LessonType.LECTURE, new Time(11,00));
//		a.addUser(t);
//		a.addUser(s1);
//		a.addUser(s2);
//		a.removeUser(6);
//		a.removeUser(5);
//		System.out.println(a.getUsers());
		Manager m = new Manager();
		// m.addNews(new News("Examination days", UrgencyLevel.HIGH, "examination dates are in the system now, check your schedule"));
//		m.addCoursesForRegis(oop);
//		m.addCoursesForRegis(algo);
//		m.addLessonToSystem(oopL1);
//		m.addLessonToSystem(adsL1);
//		m.approveRegistration(s1, oop);
//		m.approveRegistration(s2, algo);
//		m.attachLessonToStudent(s2, oopL1);
//		m.attachLessonToStudent(s1, oopL1);
//		t.getLessons().add(oopL1);
//		m.attachLessonToTeacher(t, oopL1);
//		m.deleteLessonFromSystem(adsL1);
		
//		System.out.println(DataSingleton.INSTANCE.getCourse());
		System.out.println(DataSingleton.INSTANCE.getLessons());
//		System.out.println(t.getLessons());	
		
//		System.out.println(s2.getMarks());
//		System.out.println(DataSingleton.INSTANCE.getLessonsOfTeachers());
//		System.out.println(DataSingleton.INSTANCE.getLessonsOfStudents());
		
		
		
//		System.out.println(DataSingleton.INSTANCE.getLessonsOfStudents());

		

		

		// System.out.println(DataSingleton.INSTANCE.getTeachers().get(0).getLessons());
		ResearchUniversity.INSTANCE.setWeek(7);
		
////		s.getMarks().entrySet().stream().forEach(n->System.out.println(n.getKey() + " " + n.getValue()));
//		TeacherMenu tm = new TeacherMenu(t);
	}
}
