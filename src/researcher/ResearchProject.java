package researcher;

import java.io.Serializable;
import java.util.Vector;

import staff.User;

/**
 * The ResearchProject class represents a research project with a title, a list of members, and a list
 * of research papers.
 */
public class ResearchProject implements Serializable{
	
	private String title;
	// The line `private Vector<User> members;` is declaring a private instance variable named `members`
	// of type `Vector<User>`. This variable is used to store a list of members who are part of the
	// research project.
	private Vector<User> members;
	// The line `private Vector<ResearchPaper> papers;` is declaring a private instance variable named
	// `papers` of type `Vector<ResearchPaper>`. This variable is used to store a list of research papers
	// that are associated with the research project.
	private Vector<ResearchPaper> papers;
	
	public ResearchProject() {
		
	}
	
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
	 * The function allows a user to join a project if they are a researcher, otherwise it throws an
	 * exception.
	 * 
	 * @param user The user object represents a user who wants to join a project.
	 */
	public void join(User user) throws CanNotJoinToProjectException {
		if(user instanceof Researcher) {
			members.add(user);	
		}
		// The line `else throw new CanNotJoinToProjectException("Only researchers can join this project.");`
		// is throwing a new instance of the `CanNotJoinToProjectException` class with a specified error
		// message. This is done when a user tries to join a research project but is not a researcher. The
		// exception is thrown to indicate that only researchers are allowed to join the project.
		else throw new CanNotJoinToProjectException("Only researchers can join this project.");
	}
	
	public String toString() {
		return "Research Project's title: " + title + ", members: " + members + ", papers: " + papers;
	}

}
