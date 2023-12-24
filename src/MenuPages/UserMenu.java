package MenuPages;

import java.io.IOException;
import java.util.Scanner;

import staff.User;
import student.Student;
import utilities.DataSingleton;
import utilities.Utils;

public abstract class UserMenu {
	Scanner in = new Scanner(System.in);
	User u;
	public UserMenu() {
		u =new User(in.next()) {};
	}
	public UserMenu(User u1) {
		this.u=u1;
	}

abstract public void welcomeMessage() ;

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


//пока не продумал как нужно исползовать абстракт меню чтобы его имплиментили другие классы меню 
public void run() throws IOException {
	try {
		this.welcomeMessage();
		menu : while(true){
			System.out.println("What do you want to do? \n 1) View news   \n 2) Exit");
			int choice = in.nextInt();
				if (choice==1){
				while(true){
					Utils.printList(u.viewNews());
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = in.nextInt();
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
			}
			else if (choice==2){
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
