package test;

import MenuPages.TechSupportMenu;
import researcher.EmployeeResearcher;
import staff.Employee;
import staff.TechSupportSpecialist;
import teacher.Teacher;
import utilities.DataSingleton;
import utilities.Orders;

public class TestTechMenu {

	public static void main(String[] args) throws Exception {
		Teacher tc1=new Teacher("Yerasyil","Omirzhanov",1300);
		TechSupportSpecialist tch1= new TechSupportSpecialist("Yerasyil","Omirzhanov",2400);
		TechSupportMenu techMenu=new TechSupportMenu(tch1);
		techMenu.run();
		
		
	}

}
