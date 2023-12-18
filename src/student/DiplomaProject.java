package student;

import java.io.Serializable;
import java.util.Vector;

import researcher.ResearchPaper;

public class DiplomaProject implements Serializable{

	private String title;
	private StudentDegree type;
	private Vector<Student> members;
	private Vector<ResearchPaper> papers;
	
	public DiplomaProject() {
		
	}
	public DiplomaProject(String title, StudentDegree type) {
		this.title = title;
		this.type = type;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public Vector<Student> getMembers() {
		return this.members;
	}
	
	public void addMember(Student s) {
		members.add(s);
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
		return "DiplomaProject's title: " + this.title + ", members: " + this.members + ", type: " + this.type + "papers: " + this.papers;
	}
	
}
