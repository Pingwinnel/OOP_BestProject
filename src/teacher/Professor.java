package teacher;

import java.util.List;
import researcher.ResearchPaper;
import researcher.Researcher;
import researcher.ResearcherUtils;
import student.Schools;
/**
 * The Professor` class allows professors to engage in research activities
 * @author Code Symphony
 */
public class Professor extends Teacher implements Researcher{
	
	private static final long serialVersionUID = 5295963205026648093L;
	
	/**
	 * Default empty constructor for the Professor class
	 */
	public Professor() {
		
	}
	
    /**
     * Parameterized onstructor for the Professor class
     * @param surname 
     * @param name   
     * @param school  
     */
	public Professor(String surname, String name, Schools school) {
		super(surname, name, school);
		this.setAcademicDegree(Degree.PROFESSOR);
	}

    /**
     * Delegates the printing of research papers to the ResearcherUtils class
     * @return A list of research papers associated with the professor
     */
	@Override
	public List<ResearchPaper> printPapers() {
		return ResearcherUtils.printPapers(this);
	}
	
    /**
     * Delegates the calculation of the H-index to the ResearcherUtils class
     * @return The calculated H-index of the professor
     */
	@Override
	public int calculateHIndex() {
		return ResearcherUtils.calculateHIndex(this);
	}
	

}
