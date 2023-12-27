package MenuPages;

import staff.Admin;
import staff.Manager;
import staff.ManagerType;
import utilities.DataSingleton;

public class MainMain {

	public static void main(String[] args) throws Exception {
		Admin a = new Admin("Admin", "Admin");
//		AdminMenu am = new AdminMenu(a);
//		System.out.println(a.getUsers());
		Manager m = new Manager("Manager", "Manager", ManagerType.SCHOOL);
		ManagerMenu mm = new ManagerMenu(m);
//		mm.run();
//		System.out.println(DataSingleton.INSTANCE.getLessons());
//		System.out.println(DataSingleton.INSTANCE.getCourse());
//		System.out.println(DataSingleton.INSTANCE.getLessonsOfStudents());
//		System.out.println(DataSingleton.INSTANCE.getLessonsOfTeachers());
//		System.out.println(DataSingleton.INSTANCE.getResearchPapers());
		
//		LoginPage lp = new LoginPage();
//		

	}

}
