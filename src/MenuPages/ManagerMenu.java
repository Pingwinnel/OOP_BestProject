package MenuPages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import course.Course;
import course.Days;
import course.Lesson;
import course.LessonType;
import course.Room;
import staff.Dean;
import staff.Employee;
import staff.Manager;
import staff.User;
import utilities.DataSingleton;
import utilities.News;
import utilities.Request;
import student.Schools;
import student.Student;
import teacher.Teacher;
import teacher.UrgencyLevel;
import course.Time;

public class ManagerMenu {

	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	Manager m;
	
	public ManagerMenu(Manager m) {
		this.m = m;
	}
	
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
	
	public User findUserByEmail(String email) throws Exception {
        return DataSingleton.INSTANCE.getUsers().stream()
                .filter(user -> user.getCorparateEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
	
	public void run() throws Exception {
		System.out.println("Welcome, " + m.getName() + " " + m.getSurname() + "!");
		menu: while(true) {
			System.out.println("What do you wanna do?\n 1) Change Password \n 2) View News \n 3) Add Course for Registration \n 4) Add/Delete Lesson \n 5) Attach/Detach lesson to/from Teacher \n 6) Attach/Detach lesson to Student \n 7) Approve Registration \n 8) Add News \n 9) View Info Teacher \n 10) createReportBySchool \n 11) viewStudentsSortedByGpa() \n 12) viewStudentsSortedAlphabetically \n 13) Send Request \n 14) Send Message \n 15) Get Message \n 16) Exit");
			int choice = Integer.parseInt(bf.readLine());
			if(choice == 1) {
				changePassword: while(true) {
					String newPassword = bf.readLine();
					m.changePassword(newPassword);
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 2) {
				viewNews: while(true) {
					System.out.println(m.viewNews());
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 3) {
				addCoursesForRegis: while(true) {
					System.out.println("Enter the name of the course: ");
					String name  = bf.readLine();
					System.out.println("Enter the code of the course: ");
					String code = bf.readLine();
					System.out.println("Enter the school of the course(SITE, SAM, BS): ");
			        Schools school = Schools.valueOf(bf.readLine()); 
					System.out.println("Enter the number of credits of the course: ");
					int credits = Integer.parseInt(bf.readLine());
					Course c = new Course(name, code, school, credits);
					m.addCoursesForRegis(c);
					System.out.println("Course added!");
					System.out.println("1) Add another course \n 2) Return back \n 3) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue addCoursesForRegis;
					if(choice==2) continue menu;
					if(choice==3) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 4) {
				addDeleteLesson: while(true) {
					System.out.println("What do you wanna do? \n 1) Add Lesson \n 2) Delete Lesson");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) {
						System.out.println("Select course for which you wanna add a lesson: ");
						printList(DataSingleton.INSTANCE.getCourse());
						choice = Integer.parseInt(bf.readLine());
						Course c = DataSingleton.INSTANCE.getCourse().get(choice-1);
						System.out.println("Enter the name of the lesson: ");
						String name = bf.readLine();
						System.out.println("Enter the day of the lesson(MON/TUE/WED/THU/FRI/SAT/SUN): ");
						Days day = Days.valueOf(bf.readLine());
						System.out.println("Enter the time of the lesson(HH:mm): ");
						Time time = Time.parse(bf.readLine());
						System.out.println("Enter the type of the lesson(LECTURE/PRACTICE/LAB): ");
						LessonType type = LessonType.valueOf(bf.readLine());
						System.out.println("Enter the room of the lesson: ");
						Room room = new Room(bf.readLine());
						Lesson l = new Lesson(c, name, day, time, type, room);
						m.addLessonToSystem(l);
						System.out.println("Lesson added!");
					}
					if(choice==2) {
						System.out.println("Select a lesson you wanna delete: ");
						printList(DataSingleton.INSTANCE.getLessons());
						choice = Integer.parseInt(bf.readLine());
						DataSingleton.INSTANCE.getLessons().remove(choice-1);
						System.out.println("Lesson deleted!");
					}
					System.out.println("1) Add/delete another lesson \n 2) Return back \n 3) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue addDeleteLesson;
					if(choice==2) continue menu;
					if(choice==3) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 5) {
				attachDetachLessonTeacher: while(true) {
					System.out.println("What do you wanna do? \n 1) Attach Lesson to Teacher \n 2) Detach Lesson from Teacher");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) {
						System.out.println("Select a teacher you wanna attach the lesson to: ");
						printList(DataSingleton.INSTANCE.getTeachers());
						choice = Integer.parseInt(bf.readLine());
						Teacher t = DataSingleton.INSTANCE.getTeachers().get(choice-1);
						System.out.println("Select lesson you wanna attach this teacher to: ");
						printList(DataSingleton.INSTANCE.getLessonsOfTeachers().get(t));
						choice = Integer.parseInt(bf.readLine());
						Lesson l = DataSingleton.INSTANCE.getLessonsOfTeachers().get(t).get(choice-1);
						m.attachLessonToTeacher(t, l);
						System.out.println("Lesson attached to teacher!");
					}
					if(choice==2) {
						System.out.println("Select a teacher you wanna detach the lesson from: ");
						printList(DataSingleton.INSTANCE.getTeachers());
						choice = Integer.parseInt(bf.readLine());
						Teacher t = DataSingleton.INSTANCE.getTeachers().get(choice-1);
						System.out.println("Select lesson you wanna detach this teacher from: ");
						printList(DataSingleton.INSTANCE.getLessonsOfTeachers().get(t));
						choice = Integer.parseInt(bf.readLine());
						Lesson l = DataSingleton.INSTANCE.getLessonsOfTeachers().get(t).get(choice-1);
						m.detachLessonToTeacher(t, l);
						System.out.println("Lesson detached from teacher!");
					}
					System.out.println("1) Attach/detach another lesson to/from teacher \n 2) Return back \n 3) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue attachDetachLessonTeacher;
					if(choice==2) continue menu;
					if(choice==3) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 6) {
				attachDetachLessonStudent: while(true) {
					System.out.println("What do you wanna do? \n 1) Attach Lesson to Student \n 2) Detach Lesson from Student");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) {
						System.out.println("Select a student you wanna attach the lesson to: ");
						printList(DataSingleton.INSTANCE.getStudents());
						choice = Integer.parseInt(bf.readLine());
						Student s = DataSingleton.INSTANCE.getStudents().get(choice-1);
						System.out.println("Select a lesson you wanna attach this student to:");
						printList(DataSingleton.INSTANCE.getLessonsOfStudents().get(s));
						Lesson l = DataSingleton.INSTANCE.getLessonsOfStudents().get(s).get(choice-1);
						m.attachLessonToStudent(s, l);
						System.out.println("Lesson attached to student!");
					}
					if(choice==2) {
						System.out.println("Select a student you wanna detach the lesson from:");
						printList(DataSingleton.INSTANCE.getStudents());
						choice = Integer.parseInt(bf.readLine());
						Student s = DataSingleton.INSTANCE.getStudents().get(choice-1);
						System.out.println("Select a lesson you wanna detach this student from: ");
						printList(DataSingleton.INSTANCE.getLessonsOfStudents().get(s));
						Lesson l = DataSingleton.INSTANCE.getLessonsOfStudents().get(s).get(choice-1);
						m.detachLessonToStudent(s, l);
						System.out.println("Lesson detached from student!");
					}
					System.out.println("1) Attach/detach another lesson to/from teacher \n 2) Return back \n 3) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue attachDetachLessonStudent;
					if(choice==2) continue menu;
					if(choice==3) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 7) {
				approveRegistration: while(true) {
					System.out.println("Select a student to approve registration for course: ");
					printList(DataSingleton.INSTANCE.getStudents());
					choice = Integer.parseInt(bf.readLine());
					Student s = DataSingleton.INSTANCE.getStudents().get(choice-1);
					System.out.println("Select a course to approve registration of a student: ");
					printList(DataSingleton.INSTANCE.getCourse());
					choice = Integer.parseInt(bf.readLine());
					Course c = DataSingleton.INSTANCE.getCourse().get(choice-1);
					m.approveRegistration(s, c);
					System.out.println("Registartion approved!");
					
				}
				
			}
			
			else if(choice == 8) {
				addNews: while(true) {
					System.out.println("Enter the title of the news: ");
					String title = bf.readLine();
					System.out.println("Enter the Urgency level of the news(LOW/HIGH/MEDIUM): ");
					UrgencyLevel level = UrgencyLevel.valueOf(bf.readLine());
					System.out.println("Enter the text(body) of the news: ");
					String text = bf.readLine();
					News n = new News(title, level, text);
					m.addNews(n);
					System.out.println("News added!");
					System.out.println("1) Add another news \n 2) Return back \n 3) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue addNews;
					if(choice==2) continue menu;
					if(choice==3) {exit();  break menu;}
					break;
					}
			}
			
			else if(choice == 9) {
				viewInfoTeacher: while(true) {
					System.out.println(m.viewInfoTeacher());
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 10) {
				createReportBySchool: while(true) {
					System.out.println("Enter the school to create a report(SITE/SAM/BS): ");
					Schools school = Schools.valueOf(bf.readLine());
					System.out.println(m.createReportBySchool(school));
					System.out.println("1) Create another Report \n 2) Return back \n 3) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue createReportBySchool;
					if(choice==2) continue menu;
					if(choice==3) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 11) {
				viewStudentsSortedByGpa: while(true) {
					System.out.println(m.viewStudentsSortedByGpa());
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 12) {
				viewStudentsSortedAlphabetically: while(true) {
					System.out.println(m.viewStudentsSortedAlphabetically());
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 13) {
				sendRequest: while(true) {
					System.out.println("Select a dean who will receive this request: ");
					printList(DataSingleton.INSTANCE.getDeans());
					choice = Integer.parseInt(bf.readLine());
					Dean d = DataSingleton.INSTANCE.getDeans().get(choice-1);
					System.out.println("Enter a text(body) of the request: ");
					String text = bf.readLine();
					Request r = new Request(d, text);
					m.sendRequest(r);
					System.out.println("Request sended!");
					System.out.println("1) Send another request \n 2) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue sendRequest;
					if(choice==2) continue menu;
					if(choice==3) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 14) {
				sendMessage: while(true) {
					System.out.println("Select an employee who will receive this message: ");
					printList(DataSingleton.INSTANCE.getEmployees());
					choice = Integer.parseInt(bf.readLine());
					Employee e = DataSingleton.INSTANCE.getEmployees().get(choice-1);
					System.out.println("Enter a text(body) of the message: ");
					String text = bf.readLine();
					m.sendMessage(text, e);
					System.out.println("Message sended!");
					System.out.println("1) Send another message \n 2) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue sendMessage;
					if(choice==2) continue menu;
					if(choice==3) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 15) {
				getMessage: while(true) {
					System.out.println(m.getMessage());
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 16) {
				exit();
			}
		}
	}
}