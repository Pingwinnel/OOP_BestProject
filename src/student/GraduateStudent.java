package student;

import java.util.List;
import java.util.Vector;

import researcher.Researcher;
import researcher.ResearcherUtils;
import researcher.ResearchPaper;
/**
 * This is `GraduateStudent` class.
 * It extends the `Student` class and includes additional attributes and methods specific to graduate students.
 * It also implements the `Researcher` interface, allowing graduate students to engage in research activities.
 */
public class GraduateStudent extends Student implements Researcher{
	// Attributes specific to the GraduateStudent class
	private GraduateStudentDegree degree;
	private Researcher researchSupervisor;
	private Vector<ResearchPaper> papers;
	
	//Default constructor for the GraduateStudent class.
	public GraduateStudent() {
		super();
	}
    /**
     * Constructor to initialize a graduate student with a given surname, name, school, major, and default degree (MASTER).
     *
     * @param surname The surname of the graduate student.
     * @param name    The name of the graduate student.
     * @param school  The school of the graduate student.
     * @param major   The major of the graduate student.
     */
	public GraduateStudent(String surname, String name, Schools school, Major major) {
		super(surname, name, school, major);
		this.degree = GraduateStudentDegree.MASTER;
	}
    /**
     * Constructor to initialize a graduate student with a given surname, name, school, major, and degree.
     *
     * @param surname The surname of the graduate student.
     * @param name    The name of the graduate student.
     * @param school  The school of the graduate student.
     * @param major   The major of the graduate student.
     * @param degree  The degree level (MASTER or PHD) of the graduate student.
     */
	public GraduateStudent(String surname, String name, Schools school, Major major, GraduateStudentDegree degree) {
		super(surname, name, school, major);
		this.degree = degree;
		
	}
    /**
     * Getter method to retrieve the degree level of the graduate student.
     *
     * @return The degree level (MASTER or PHD) of the graduate student.
     */
	public GraduateStudentDegree getDegree() {
		return degree;
	}
    /**
     * Getter method to retrieve the research supervisor of the graduate student.
     *
     * @return The research supervisor of the graduate student.
     */
	public Researcher getResearchSupervisor() {
		return researchSupervisor;
	}
    /**
     * Getter method to retrieve the research papers associated with the graduate student.
     *
     * @return A vector containing the research papers of the graduate student.
     */
	public Vector<ResearchPaper> getPapers() {
		return papers;
	}
    /**
     * Setter method to set the degree level of the graduate student.
     *
     * @param degree The degree level (MASTER or PHD) to be set for the graduate student.
     */
	public void setDegree(GraduateStudentDegree degree) {
		this.degree = degree;
	}
    /**
     * Setter method to set the research supervisor of the graduate student.
     *
     * @param researchSupervisor The research supervisor to be set for the graduate student.
     * @throws CanNotBeSupervisorException If the research supervisor's h-index is less than 3.
     */
	public void setResearchSupervisor(Researcher researchSupervisor) throws CanNotBeSupervisorException {
		if(researchSupervisor.calculateHIndex()>=3)
			this.researchSupervisor = researchSupervisor;
		else throw new CanNotBeSupervisorException("This researcher has h-index less than 3");
	}
    /**
     * Override of the toString method to provide a string representation of the graduate student.
     *
     * @return A string representation of the graduate student.
     */
	public String toString() {
		return "GraduateStudent [" + super.toString() + ", degree=" + this.degree + ", research supervisor=" + this.researchSupervisor + ", papers=" + this.papers + "]";
	}
    /**
     * Implementation of the printPapers method from the Researcher interface.
     * Delegates the printing of research papers to the ResearcherUtils class.
     *
     * @return A list of research papers associated with the graduate student.
     */
	@Override
	public List<ResearchPaper> printPapers() {
		// TODO Auto-generated method stub
		return ResearcherUtils.printPapers(this);
	}
    /**
     * Implementation of the calculateHIndex method from the Researcher interface.
     * Delegates the calculation of the H-index to the ResearcherUtils class.
     *
     * @return The calculated H-index of the graduate student.
     */
	@Override
	public int calculateHIndex() {
		// TODO Auto-generated method stub
		return ResearcherUtils.calculateHIndex(this);
	}
	
}
