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
		Teacher tc1=new Teacher("Yerasyil","Omirzhanov");
		TechSupportSpecialist tch1= new TechSupportSpecialist("Yerasyil","Omirzhanov");
		TechSupportMenu techMenu=new TechSupportMenu(tch1);
		techMenu.run();
		
		
	}

}
