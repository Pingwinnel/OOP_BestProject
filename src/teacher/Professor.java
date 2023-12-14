package teacher;

import java.util.Vector;

import course.School;
import researcher.ResearchPaper;
import researcher.Researcher;

public class Professor extends Teacher implements Researcher{

	
	public Professor() {
		
	}
	
	public Professor(String surname, String name, double salary, School school) {
		super(surname, name, salary, school);
		this.setAcademicDegree(Degree.PROFESSOR);
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
