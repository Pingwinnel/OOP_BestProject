package MenuPages;

import course.Course;
import course.Days;
import course.Lesson;
import course.LessonType;
import course.Time;
import staff.Admin;
import staff.Manager;
import student.Major;
import student.Schools;
import student.Student;
import teacher.Degree;
import teacher.Teacher;
import teacher.UrgencyLevel;
import utilities.DataSingleton;
import utilities.News;

public class Main {

	public static void main(String[] args) throws Exception {
		// if you wanna test it, first delete "data.ser" file, then uncomment these lines of code and run
		
//		Student s1 = new Student("Seidazym", "Aknur");
		Admin a = new Admin();
//		s1.changePassword("Pok.pokova2005");
//		a.addUser(s1);
//		System.out.println(a.getUsers());
		Teacher t1 = new Teacher("Shamoi", "Pakita", Schools.SITE, Degree.PROFESSOR);
//		t1.changePassword("123");
//		a.addUser(t1);
		
		Course oop = new Course("OOP", "CS10", Schools.SITE, 3);
		Course algo = new Course("ADS", "CS12", Schools.SITE, 3);
		
		Student s1 = new Student("Seidazym", "Aknur", Schools.SITE, Major.IS, 2);
		Student s2 = new Student("Abdugapparova", "Tuba", Schools.SITE, Major.CSaS, 3);
		Student s3 = new Student("Omirzhanov", "Yerassyl", Schools.SITE, Major.IS, 2);
		Student s4 = new Student("Medelbay", "Adina", Schools.SITE, Major.IS, 2);
		Teacher t2 = new Teacher("Amanov", "Alimzhan", Schools.SITE, Degree.SENIOR_LECTURER);

		Lesson oopL1 = new Lesson(oop, Days.WED, LessonType.PRACTICE, new Time(16,00));
		Lesson oopL2 = new Lesson(oop, Days.TUE, LessonType.LECTURE, new Time(12,00));
		Lesson adsL1 = new Lesson(algo, Days.MON, LessonType.LECTURE, new Time(14,00));
		
//		a.addUser(t1);
//		a.addUser(t2);
//		a.addUser(s1);
//		a.addUser(s2);
//		a.addUser(s3);
//		a.addUser(s4);
//		a.removeUser(1);

		System.out.println(a.getUsers());
		Manager m = new Manager();
		// m.addNews(new News("Examination days", UrgencyLevel.HIGH, "examination dates are in the system now, check your schedule"));
//		m.addCoursesForRegis(oop);
//		m.addCoursesForRegis(algo);
//		m.addLessonToSystem(oopL1);
//		m.addLessonToSystem(adsL1);
//		m.addLessonToSystem(oopL2);
		
//		m.approveRegistration(s1, oop);
//		m.approveRegistration(s1, algo);
//		m.approveRegistration(s2, oop);
//		m.approveRegistration(s3, oop);
//		m.approveRegistration(s3, algo);
//		m.approveRegistration(s4, oop);
//		m.approveRegistration(s3, algo);
		
//		m.attachLessonToStudent(s2, oopL1);
//		m.attachLessonToStudent(s1, oopL2);
//		m.attachLessonToStudent(s3, oopL1);
//		m.attachLessonToStudent(s4, oopL1);
//		m.attachLessonToStudent(s1, adsL1);
//		m.attachLessonToStudent(s3, adsL1);

//		m.attachLessonToTeacher(t1, oopL1);
//		m.attachLessonToTeacher(t1, oopL2);
//		m.attachLessonToTeacher(t2, adsL1);
//		m.deleteLessonFromSystem(adsL1);
		
//		System.out.println(DataSingleton.INSTANCE.getCourse());
//		System.out.println(DataSingleton.INSTANCE.getLessons());
//		System.out.println(t.getLessons());	
//		System.out.println(s1.getMarks());
//		System.out.println(s2.getMarks());
//		System.out.println(DataSingleton.INSTANCE.getLessonsOfTeachers());
//		System.out.println(DataSingleton.INSTANCE.getLessonsOfStudents());
		
//		
		for(Student s: DataSingleton.INSTANCE.getStudents()) {
			if(s.equals(s1)) {
				System.out.println(s.getMarks());
			}
		}
//		System.out.println(s1.getMarks());

//		TeacherMenu tm = new TeacherMenu(t1);
//		System.out.println(t1.viewStudentInfo(oopL1));
		
//		LoginPage loginPage = new LoginPage();
		
		

	}

}
