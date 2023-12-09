package Researcher;

import Staff.Employee;

public class Researcher extends Employee implements CanBeResearcher{
	
	public Researcher(int id, String surname, String name, String corparateEmail, String password, double salary) {
		super(id, surname, name, corparateEmail, password, salary);
	}

	@Override
	public String toString() {
		return super.toString() + "I am a Researcher";
	}

	@Override
	public void getResearcherPapers() {
		// TODO Auto-generated method stub
		System.out.println("a list of research papers");
		
	}
	

}
