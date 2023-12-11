package Student;

import java.util.Vector;

import Researcher.ResearchPaper;

public class DiplomaProject {

	private String title;
	private Vector<Student> members;
	private StudentDegree type;
	private Vector<ResearchPaper> papers;
	
	public DiplomaProject() {
		
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public Vector<Student> getMembers() {
		return this.members;
	}
	
	public StudentDegree getType() {
		return this.type;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setStudentDegree(StudentDegree type) {
		this.type = type;
	}
	
	public void addResearchPaper(ResearchPaper paper) {
		papers.add(paper);
	}
	
	public String toString() {
		return "DiplomaProject [title=" + this.title + ", members=" + this.members + ", type=" + this.type + "papers=" + this.papers + "]";
	}
	
}
