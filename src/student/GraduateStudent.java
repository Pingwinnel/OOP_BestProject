package student;

import java.util.List;
import java.util.Vector;

import researcher.Researcher;
import researcher.ResearcherUtils;
import researcher.ResearchPaper;
/**
 * The GraduateStudent class includes additional attributes and methods specific to graduate students
 * @author Code Symphony
 */
public class GraduateStudent extends Student implements Researcher{
	// Attributes specific to the GraduateStudent class
	private GraduateStudentDegree degree;
	private Researcher researchSupervisor;
	private Vector<ResearchPaper> papers;
	
	/**
	 * Default empty constructor for the GraduateStudent class
	 */
	public GraduateStudent() {
		super();
	}
	
    /**
     * Parameterized constructor for the GraduateStudent class
     * @param surname 
     * @param name    
     * @param school  
     * @param major   
     */
	public GraduateStudent(String surname, String name, Schools school, Major major) {
		super(surname, name, school, major);
		this.degree = GraduateStudentDegree.MASTER;
	}
	
    /**
     * More detailed parameterized constructor for the GraduateStudent class
     * @param surname 
     * @param name    
     * @param school  
     * @param major
     * @param degree  
     */
	public GraduateStudent(String surname, String name, Schools school, Major major, GraduateStudentDegree degree) {
		super(surname, name, school, major);
		this.degree = degree;
		
	}
	
    /**
     * Retrieves the degree level of the graduate student
     * @return The degree level (MASTER or PHD) of the graduate student
     */
	public GraduateStudentDegree getDegree() {
		return degree;
	}
	
    /**
     * Retrieves the research supervisor of the graduate student
     * @return The research supervisor of the graduate student
     */
	public Researcher getResearchSupervisor() {
		return researchSupervisor;
	}
	
    /**
     * Retrieves the research papers associated with the graduate student
     * @return A vector containing the research papers of the graduate student
     */
	public Vector<ResearchPaper> getPapers() {
		return papers;
	}
	
    /**
     * Sets the degree level of the graduate student
     * @param degree The degree level (MASTER or PHD) to be set for the graduate student
     */
	public void setDegree(GraduateStudentDegree degree) {
		this.degree = degree;
	}
	
    /**
     * Sets the research supervisor of the graduate student
     * @param researchSupervisor The research supervisor to be set for the graduate student
     * @throws CanNotBeSupervisorException If the research supervisor's h-index is less than 3
     */
	public void setResearchSupervisor(Researcher researchSupervisor) throws CanNotBeSupervisorException {
		if(researchSupervisor.calculateHIndex()>=3)
			this.researchSupervisor = researchSupervisor;
		else throw new CanNotBeSupervisorException("This researcher has h-index less than 3");
	}
	
	public String toString() {
		return "GraduateStudent [" + super.toString() + ", degree=" + this.degree + ", research supervisor=" + this.researchSupervisor + ", papers=" + this.papers + "]";
	}
	
    /**
     * Delegates the printing of research papers to the ResearcherUtils class
     * @return A list of research papers associated with the graduate student
     */
	@Override
	public List<ResearchPaper> printPapers() {
		// TODO Auto-generated method stub
		return ResearcherUtils.printPapers(this);
	}
	
    /**
     * Delegates the calculation of the H-index to the ResearcherUtils class
     * @return The calculated H-index of the graduate student
     */
	@Override
	public int calculateHIndex() {
		// TODO Auto-generated method stub
		return ResearcherUtils.calculateHIndex(this);
	}
	
}
