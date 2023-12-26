package teacher;

import java.util.List;
import researcher.ResearchPaper;
import researcher.Researcher;
import researcher.ResearcherUtils;
import student.Schools;
/**
 * This is `Professor` class.
 * It extends the `Teacher` class and implements the `Researcher` interface,
 * allowing professors to engage in research activities.
 */
public class Professor extends Teacher implements Researcher{
	
	private static final long serialVersionUID = 5295963205026648093L;
	//Default constructor for the Professor class.
	public Professor() {
		
	}
    /**
     * Constructor to initialize a professor with a given surname, name, salary, and school.
     * The academic degree is set to PROFESSOR.
     *
     * @param surname The surname of the professor.
     * @param name    The name of the professor.
     * @param school  The school associated with the professor.
     */
	public Professor(String surname, String name, Schools school) {
		super(surname, name, school);
		this.setAcademicDegree(Degree.PROFESSOR);
	}

    /**
     * Implementation of the printPapers method from the Researcher interface.
     * Delegates the printing of research papers to the ResearcherUtils class.
     *
     * @return A list of research papers associated with the professor.
     */
	@Override
	public List<ResearchPaper> printPapers() {
		return ResearcherUtils.printPapers(this);
	}
    /**
     * Implementation of the calculateHIndex method from the Researcher interface.
     * Delegates the calculation of the H-index to the ResearcherUtils class.
     *
     * @return The calculated H-index of the professor.
     */
	@Override
	public int calculateHIndex() {
		return ResearcherUtils.calculateHIndex(this);
	}
	

}
