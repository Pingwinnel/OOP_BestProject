package teacher;

import java.util.List;
import researcher.ResearchPaper;
import researcher.Researcher;
import researcher.ResearcherUtils;
import student.Schools;

public class Professor extends Teacher implements Researcher{

	
	private static final long serialVersionUID = 5295963205026648093L;

	public Professor() {
		
	}
	
	public Professor(String surname, String name, double salary, Schools school) {
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
