package researcher;

import java.io.Serializable;
import java.util.Vector;

import staff.User;

/**
 * The ResearchProject class represents a research project with a title, a list of members, and a list of research papers
 * @author Code Symphony
 */
public class ResearchProject implements Serializable{
	
	private String title;
	private Vector<User> members;
	private Vector<ResearchPaper> papers;
	
	/**
	 * Default empty constructor for the ResearchProject class
	 */
	public ResearchProject() {
		
	}
	
	/**
	 * Parameterized constructor for the ResearchProject class
	 */
	public ResearchProject(String title, Vector<User> members, Vector<ResearchPaper> papers) {
		this.title = title;
		this.members = members;
		this.papers = papers;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public Vector<User> getMembers() {
		return this.members;
	}
	
	public Vector<ResearchPaper> getPapers() {
		return this.papers;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Allows a user to join a project if they are a researcher, otherwise it throws an exception
	 * @param user Represents a user who wants to join a project
	 * @throws CanNotJoinToProjectException If someone who is not researcher tries to join
	 */
	public void join(User user) throws CanNotJoinToProjectException {
		if(user instanceof Researcher) {
			members.add(user);	
		}
		else throw new CanNotJoinToProjectException("Only researchers can join this project.");
	}
	
	public String toString() {
		return "Research Project's title: " + title + ", members: " + members + ", papers: " + papers;
	}

}
