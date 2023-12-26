package MenuPages;

import java.io.IOException;
import java.util.Scanner;

import course.Course;
import staff.TechSupportSpecialist;
import student.Student;
import utilities.DataSingleton;
import utilities.Mark;

/**
 * The TechSupportMenu class provides a menu-driven interface for a tech support specialist to view,
 * accept, and take orders.
 */
public class TechSupportMenu {

	Scanner in = new Scanner(System.in);
	TechSupportSpecialist tss;

	public TechSupportMenu(TechSupportSpecialist tss) {
		this.tss=tss;
	}
	/**
	 * The save() function writes data to a file.
	 */
	private void save() throws IOException {
		DataSingleton.write();
	}
	/**
	 * The exit() function prints "Bye bye" and attempts to save data, handling any IOExceptions that
	 * occur.
	 */
	private void exit() {
		System.out.println("Bye bye");
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The run() function displays a menu to the user and performs different actions based on their
	 * choice, such as viewing orders, accepting orders, taking orders, or exiting the program.
	 */
	public void run() throws IOException {
		try {
			System.out.println("Welcome!");
			menu : while(true){
				System.out.println("What do you want to do? \n 1) View orders  \n 2)Accept order \n 3)Take order \n 4) Exit");
				int choice = in.nextInt();
				if (choice==1){
					while(true){
						// The line `this.tss.viewOrders();` is calling the `viewOrders()` method on the `tss` object.
						// This method is likely defined in the `TechSupportSpecialist` class and is responsible for
						// displaying the orders to the tech support specialist.
						this.tss.viewOrders();
						System.out.println("\n 1) Return back \n 2) Exit");
						choice = in.nextInt();
						if(choice==1) continue menu;
						if(choice==2) {exit();  break menu;}
						break;
					}
				}
				else if (choice==2){
					System.out.println("Please enter order id: ");
					// The line `tss.acceptOrders(in.nextInt());` is calling the `acceptOrders()` method on the `tss`
					// object. This method is likely defined in the `TechSupportSpecialist` class and is responsible
					// for accepting an order based on the order ID provided by the user.
					tss.acceptOrders(in.nextInt());
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = in.nextInt();
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
				else if (choice==3){
					System.out.println("Please enter order id: ");
					// The line `tss.inProgressOrder(in.nextInt());` is calling the `inProgressOrder()` method on the
					// `tss` object. This method is likely defined in the `TechSupportSpecialist` class and is
					// responsible for marking an order as in progress based on the order ID provided by the user.
					tss.inProgressOrder(in.nextInt());
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = in.nextInt();
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
				else if (choice==4){
					exit();
					break menu;
				}
			}
		} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
			save();
		}
	}

}
