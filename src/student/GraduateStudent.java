package student;

import java.util.Vector;

import researcher.Researcher;
import researcher.ResearchPaper;

public class GraduateStudent extends Student {

	private GraduateStudentDegree degree;
	private Researcher researchSupervisor;
	private Vector<ResearchPaper> papers;
	
	
	public GraduateStudent() {
		super();
	}
	
	public GraduateStudent(String surname, String name, Schools school, String speciality, double gpa, int yearOfStudy) {
		super(surname, name, school, speciality, gpa, yearOfStudy);
		this.degree = GraduateStudentDegree.MASTER;
	}
	
	public GraduateStudent(String surname, String name, Schools school, String speciality, double gpa, int yearOfStudy, GraduateStudentDegree degree) {
		super(surname, name, school, speciality, gpa, yearOfStudy);
		this.degree = degree;
		
	}
	
	public GraduateStudentDegree getDegree() {
		return degree;
	}
	
	public Researcher getResearchSupervisor() {
		return researchSupervisor;
	}
	
	public Vector<ResearchPaper> getPapers() {
		return papers;
	}
	
	public void setDegree(GraduateStudentDegree degree) {
		this.degree = degree;
	}
	
	public void setResearchSupervisor(Researcher researchSupervisor) {
		//exception condition, how to calculate h index
		this.researchSupervisor = researchSupervisor;
	}
	
	public String toString() {
		return "GraduateStudent [" + super.toString() + ", degree=" + this.degree + ", research supervisor=" + this.researchSupervisor + ", papers=" + this.papers + "]";
	}
	
}
