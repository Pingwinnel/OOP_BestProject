package test;

import java.io.IOException;
import java.util.HashMap;

import MenuPages.LoginPage;
import MenuPages.ManagerMenu;
import course.Course;
import course.Days;
import course.Lesson;
import course.LessonType;
import course.Time;
import staff.Dean;
import staff.Manager;
import student.Schools;
import teacher.Teacher;
import utilities.DataSingleton;

public class TestManagerMenu {

	public static void main(String[] args) throws Exception {
		
		Manager m = new Manager();
		ManagerMenu mm = new ManagerMenu(m);
		Time t = new Time(13, 0);
		Course c = new Course("OOP");
		Teacher tr = new Teacher("ghjk", "hfjk");
		Lesson l = new Lesson(c, Days.FRI, LessonType.LAB, t);
		Lesson l2 = new Lesson(c, Days.MON, LessonType.PRACTICE, t);
		HashMap<Teacher, Lesson> lessonsOfTeachers = new HashMap<Teacher, Lesson>();
		lessonsOfTeachers.put(tr, l);
		lessonsOfTeachers.put(tr, l2);
		DataSingleton.INSTANCE.addUser(tr);
		DataSingleton.INSTANCE.addUser(m);
		//System.out.println(lessonsOfTeachers.get(tr));
		//System.out.println(tr.getCorparateEmail());
		//System.out.println(mm.findUserByEmail("h.ghjk@kbtu.kz"));
		Dean d = new Dean("erty", "ergh", Schools.SITE);
		DataSingleton.INSTANCE.addUser(d);
		//System.out.println(d.getCorparateEmail());
		//System.out.println(mm.findUserByEmail("e.erty@kbtu.kz"));
		
		try { 
			(new ManagerMenu(m)).run(); 
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		
	}
}
