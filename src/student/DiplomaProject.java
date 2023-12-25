package student;

import java.io.Serializable;
import java.util.Vector;

import researcher.ResearchPaper;
/**
 * This is  `DiplomaProject` class. It represents a diploma project.
 * It includes information such as the title, type, members (students), and associated research papers.
 * This class implements the Serializable interface for object serialization.
 */
public class DiplomaProject implements Serializable{
	//Attributes specific to the DiplomaProject class
	private String title;
	private StudentDegree type;
	private Vector<Student> members;
	private Vector<ResearchPaper> papers;
	//Default constructor for the DiplomaProject class.
	public DiplomaProject() {
		
	}
    /**
     * Constructor to initialize a diploma project with a given title and type.
     *
     * @param title The title of the diploma project.
     * @param type  The type of the diploma project (StudentDegree).
     */
	public DiplomaProject(String title, StudentDegree type) {
		this.title = title;
		this.type = type;
	}
    /**
     * Getter method to retrieve the title of the diploma project.
     *
     * @return The title of the diploma project.
     */
	public String getTitle() {
		return this.title;
	}
    /**
     * Getter method to retrieve the members (students) of the diploma project.
     *
     * @return A vector containing the members (students) of the diploma project.
     */
	public Vector<Student> getMembers() {
		return this.members;
	}
    /**
     * Method to add a member (student) to the diploma project.
     *
     * @param s The student to be added as a member of the diploma project.
     */
	public void addMember(Student s) {
		members.add(s);
	}
    /**
     * Getter method to retrieve the type (StudentDegree) of the diploma project.
     *
     * @return The type (StudentDegree) of the diploma project.
     */
	public StudentDegree getType() {
		return this.type;
	}
    /**
     * Setter method to set the title of the diploma project.
     *
     * @param title The title to be set for the diploma project.
     */
	public void setTitle(String title) {
		this.title = title;
	}
    /**
     * Setter method to set the type (StudentDegree) of the diploma project.
     *
     * @param type The type (StudentDegree) to be set for the diploma project.
     */
	public void setStudentDegree(StudentDegree type) {
		this.type = type;
	}
    /**
     * Method to add a research paper to the diploma project.
     *
     * @param paper The research paper to be added to the diploma project.
     */
	public void addResearchPaper(ResearchPaper paper) {
		papers.add(paper);
	}
    /**
     * Override of the toString method to provide a string representation of the diploma project.
     *
     * @return A string representation of the diploma project.
     */
	public String toString() {
		return "DiplomaProject's title: " + this.title + ", members: " + this.members + ", type: " + this.type + "papers: " + this.papers;
	}
	
}
