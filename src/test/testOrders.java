package test;

import researcher.EmployeeResearcher;
import staff.Admin;
import staff.TechSupportSpecialist;
import utilities.DataSingleton;
import utilities.Orders;
import utilities.Utils;
import utilities.acceptType;

public class testOrders {

	public static void main(String[] args) throws Exception {
		Admin ad=new Admin();
		TechSupportSpecialist tch1=new TechSupportSpecialist("Kabanbai","Arman,");
		Utils.printList(DataSingleton.INSTANCE.getTechSupportSpecialists());
		EmployeeResearcher epRes=new EmployeeResearcher("Omirzhanov","Yerasyil");
		epRes.senbOrder("Computer doesnt woj");
		tch1.viewOrders();
		tch1.acceptOrders(1);
		Utils.printList(DataSingleton.INSTANCE.getOrders());
		
	}

}
