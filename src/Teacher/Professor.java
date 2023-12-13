package teacher;

import java.util.Vector;

import course.School;
import researcher.ResearchPaper;
import researcher.Researcher;

public class Professor extends Teacher implements Researcher{

	
	public Professor() {
		
	}
	
	public Professor(int id, String surname, String name, String corparateEmail, String password, double salary) {
		super(id, surname, name, corparateEmail, password, salary);
		// TODO Auto-generated constructor stub
	}

	public Professor(int id, String surname, String name, String corparateEmail, String password, double salary,
			School school, Degree academicDegree) {
		super(id, surname, name, corparateEmail, password, salary, school, academicDegree);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printPapers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int calculateHIndex(Vector<ResearchPaper> papers) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
