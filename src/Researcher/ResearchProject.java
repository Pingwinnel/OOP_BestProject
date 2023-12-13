package researcher;

import java.util.Vector;

import staff.User;

public class ResearchProject {
	
	private String title;
	private Vector<User> members;
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
