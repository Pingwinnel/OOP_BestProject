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
		TechSupportSpecialist tch1=new TechSupportSpecialist("Kabanbai","Arman,",2500);
		Utils.printList(DataSingleton.INSTANCE.getTechSupportSpecialists());
		EmployeeResearcher epRes=new EmployeeResearcher("Omirzhanov","Yerasyil",1000);
		Orders o =new Orders(epRes,"I have problem 424");
		tch1.acceptOrders(o.getId());
		DataSingleton.INSTANCE.addOrders(o);
		Utils.printList(DataSingleton.INSTANCE.getOrders());
		
	}

}
