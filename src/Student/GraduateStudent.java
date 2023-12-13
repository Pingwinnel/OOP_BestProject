package Student;

import java.util.Date;

import java.util.Vector;

import Researcher.Researcher;
import Researcher.ResearchPaper;

public class GraduateStudent extends Student {

	private GraduateStudentDegree degree;
	private Researcher researchSupervisor;
	private Vector<ResearchPaper> papers;
	
	public GraduateStudent() {
		super();
	}
	
	public GraduateStudent(int id, String surname, String name, String corparateEmail, String password, Schools school, String speciality, double gpa, int yearOfStudy, DiplomaProject diplomaProject, Date graduationDate) {
		super(id, surname, name, corparateEmail, password, school, speciality, gpa, yearOfStudy, diplomaProject, graduationDate);
	}
	
	public GraduateStudent(int id, String surname, String name, String corparateEmail, String password, Schools school, String speciality, double gpa, int yearOfStudy, DiplomaProject diplomaProject, Date graduationDate, GraduateStudentDegree degree, Researcher researchSupervisor) {
		super(id, surname, name, corparateEmail, password, school, speciality, gpa, yearOfStudy, diplomaProject, graduationDate);
		this.degree = degree;
		this.researchSupervisor = researchSupervisor;
		
	}
	
	public GraduateStudentDegree getDegree() {
		return this.degree;
	}
	
	public Researcher getResearchSupervisor() {
		return this.researchSupervisor;
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
	
	private class Supervisor implements Researcher{
		public Supervisor() {
			
		}

		@Override
		public void printPapers() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int calculateHIndex(Vector<ResearchPaper> papers) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
}
