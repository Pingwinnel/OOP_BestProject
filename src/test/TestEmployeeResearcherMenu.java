package test;

import java.io.IOException;

import MenuPages.EmployeeResearcherMenu;
import researcher.EmployeeResearcher;
import staff.Dean;
import staff.Manager;
import student.Schools;
import teacher.Teacher;
import utilities.DataSingleton;

public class TestEmployeeResearcherMenu {

	public static void main(String[] args) throws Exception {
		
		EmployeeResearcher er = new EmployeeResearcher();
		Manager m = new Manager();
		Teacher tr = new Teacher("ghjk", "hfjk");
		DataSingleton.INSTANCE.addUser(tr);
		DataSingleton.INSTANCE.addUser(m);
		
		Dean d = new Dean("erty", "ergh", Schools.SITE);
		DataSingleton.INSTANCE.addUser(d);
		
		try { 
			(new EmployeeResearcherMenu(er)).run(); 
		} catch (IOException e) { 
			e.printStackTrace();
		}
		 
		
	}
}
