package teacher;

import java.util.List;


import course.School;
import researcher.ResearchPaper;
import researcher.Researcher;
import researcher.ResearcherUtils;

public class Professor extends Teacher implements Researcher{

	
	public Professor() {
		
	}
	
	public Professor(String surname, String name, double salary, School school) {
		super(surname, name, salary, school);
		this.setAcademicDegree(Degree.PROFESSOR);
	}


	@Override
	public List<ResearchPaper> printPapers() {
		return ResearcherUtils.printPapers(this);
	}

	@Override
	public int calculateHIndex() {
		return ResearcherUtils.calculateHIndex(this);
	}
	

}
