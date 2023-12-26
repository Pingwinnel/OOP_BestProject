package MenuPages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import researcher.EmployeeResearcher;
import researcher.ResearchPaper;
import researcher.Researcher;
import staff.Dean;
import staff.Employee;
import utilities.DataSingleton;
import utilities.Request;

public class EmployeeResearcherMenu {

	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	EmployeeResearcher er;
	
	public EmployeeResearcherMenu(EmployeeResearcher er) {
		this.er = er;
	}
	
	private void write() throws IOException{
		DataSingleton.write();
	}
	
	private void exit() {
		System.out.println("Bye bye");
		try {
			DataSingleton.write();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void printList(List list) {
		for(int i = 0; i<list.size(); i++) {
			System.out.println(i+1 + ")" + list.get(i));
		}
	}
	
	public void run() throws Exception {
		System.out.println("Welcome, " + er.getName() + " " + er.getSurname() + "!");
		menu: while(true) {
			System.out.println("What do you wanna do?\n 1) Change Password \n 2) View News \n 3) Send Request \n 4) Send Message \n 5) Get Message \n 6) Add Research Paper \n 7) Print Research Papers \n 8) Calculate H-Index \n 9) Exit");
			int choice = Integer.parseInt(bf.readLine());
			if(choice == 1) {
				changePassword: while(true) {
					String newPassword = bf.readLine();
					er.changePassword(newPassword);
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 2) {
				viewNews: while(true) {
					System.out.println(er.viewNews());
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 3) {
				sendRequest: while(true) {
					System.out.println("Select a dean who will receive this request: ");
					printList(DataSingleton.INSTANCE.getDeans());
					choice = Integer.parseInt(bf.readLine());
					Dean d = DataSingleton.INSTANCE.getDeans().get(choice-1);
					System.out.println("Enter a text(body) of the request: ");
					String text = bf.readLine();
					Request r = new Request(d, text);
					er.sendRequest(r);
					System.out.println("Request sended!");
					System.out.println("1) Send another request \n 2) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue sendRequest;
					if(choice==2) continue menu;
					if(choice==3) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 4) {
				sendMessage: while(true) {
					System.out.println("Select an employee who will receive this message: ");
					printList(DataSingleton.INSTANCE.getEmployees());
					choice = Integer.parseInt(bf.readLine());
					Employee e = DataSingleton.INSTANCE.getEmployees().get(choice-1);
					System.out.println("Enter a text(body) of the message: ");
					String text = bf.readLine();
					er.sendMessage(text, e);
					System.out.println("Message sended!");
					System.out.println("1) Send another message \n 2) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue sendMessage;
					if(choice==2) continue menu;
					if(choice==3) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 5) {
				getMessage: while(true) {
					System.out.println(er.getMessage());
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 6) {
				addResearchPaper: while(true) {
					System.out.println("Enter name of the Research Paper: ");
					String name = bf.readLine();
					System.out.println("Enter number of the pages: ");
					int pages = Integer.parseInt(bf.readLine());
					System.out.println("Enter number of the citations: ");
					int cit = Integer.parseInt(bf.readLine());
					System.out.println("Enter doi: ");
					String doi = bf.readLine();
					ResearchPaper rp = new ResearchPaper(name, pages, cit, doi);
					DataSingleton.INSTANCE.addResearchPapers(rp);
					System.out.println("Research Paper added!");
					System.out.println("1) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 7) {
				printPapers: while(true) {
					for(ResearchPaper rp : DataSingleton.INSTANCE.getResearchPapers()) {
						for(Researcher r: rp.getAuthors()) {
							if(r.equals(er)) System.out.println(er.printPapers());
						}
					}
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 8) {
				calculateHIndex: while(true) {
					System.out.println(er.calculateHIndex());
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = Integer.parseInt(bf.readLine());
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
			}
			
			else if(choice == 9) {
				exit();
			}
		}
	}
		
}
