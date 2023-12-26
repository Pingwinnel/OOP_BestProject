package MenuPages;

import java.io.IOException;
import java.util.Scanner;

import course.Course;
import staff.TechSupportSpecialist;
import student.Student;
import utilities.DataSingleton;
import utilities.Mark;

public class TechSupportMenu {

	Scanner in = new Scanner(System.in);
	TechSupportSpecialist tss;

	public TechSupportMenu(TechSupportSpecialist tss) {
		this.tss=tss;
	}
	private void save() throws IOException {
		DataSingleton.write();
	}
	private void exit() {
		System.out.println("Bye bye");
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() throws IOException {
		try {
			System.out.println("Welcome!");
			menu : while(true){
				System.out.println("What do you want to do? \n 1) View orders  \n 2)Accept order \n 3)Take order \n 4) Exit");
				int choice = in.nextInt();
				if (choice==1){
					while(true){
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
					tss.acceptOrders(in.nextInt());
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = in.nextInt();
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
				else if (choice==3){
					System.out.println("Please enter order id: ");
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
