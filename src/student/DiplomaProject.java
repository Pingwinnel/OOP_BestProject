package student;

import java.io.Serializable;
import java.util.Vector;

import researcher.ResearchPaper;
/**
 * The DiplomaProject class represents a diploma project that includes information such as the title, type, members (students) and associated research papers
 * @author Code Symphony
 */
public class DiplomaProject implements Serializable{
	//Attributes specific to the DiplomaProject class
	private String title;
	private StudentDegree type;
	private Vector<Student> members;
	private Vector<ResearchPaper> papers;
	
	/**
	 * Default empty constructor for the DiplomaProject class
	 */
	public DiplomaProject() {
		
	}
	
    /**
     * Parameterized constructor for the DiplomaProject class
     * @param title 
     * @param type  The type of the diploma project (StudentDegree)
     */
	public DiplomaProject(String title, StudentDegree type) {
		this.title = title;
		this.type = type;
	}
	
    /**
     * Retrieves the title of the diploma project
     * @return The title of the diploma project
     */
	public String getTitle() {
		return this.title;
	}
	
    /**
     * Retrieves the members (students) of the diploma project
     * @return A vector containing the members (students) of the diploma project
     */
	public Vector<Student> getMembers() {
		return this.members;
	}
	
    /**
     * Adds a member (student) to the diploma project
     * @param s The student to be added as a member of the diploma project
     */
	public void addMember(Student s) {
		members.add(s);
	}
	
    /**
     * Retrieve the type (StudentDegree) of the diploma project
     * @return The type (StudentDegree) of the diploma project
     */
	public StudentDegree getType() {
		return this.type;
	}
	
    /**
     * Set the title of the diploma project
     * @param title The title to be set for the diploma project
     */
	public void setTitle(String title) {
		this.title = title;
	}
	
    /**
     * Set the type (StudentDegree) of the diploma project
     * @param type The type (StudentDegree) to be set for the diploma project
     */
	public void setStudentDegree(StudentDegree type) {
		this.type = type;
	}
	
    /**
     * Adds a research paper to the diploma project
     * @param paper The research paper to be added to the diploma project
     */
	public void addResearchPaper(ResearchPaper paper) {
		papers.add(paper);
	}
	
	public String toString() {
		return "DiplomaProject's title: " + this.title + ", members: " + this.members + ", type: " + this.type + "papers: " + this.papers;
	}
	
}
