package student;

import java.util.Vector;

import researcher.Researcher;
import researcher.ResearcherUtils;
import researcher.ResearchPaper;

public class GraduateStudent extends Student implements Researcher{

	private GraduateStudentDegree degree;
	private Researcher researchSupervisor;
	private Vector<ResearchPaper> papers;
	
	
	public GraduateStudent() {
		super();
	}
	
	public GraduateStudent(String surname, String name, Schools school, String speciality) {
		super(surname, name, school, speciality);
		this.degree = GraduateStudentDegree.MASTER;
	}
	
	public GraduateStudent(String surname, String name, Schools school, String speciality, GraduateStudentDegree degree) {
		super(surname, name, school, speciality);
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
	
	public void setResearchSupervisor(Researcher researchSupervisor) throws CanNotBeSupervisorException {
		if(researchSupervisor.calculateHIndex()>=3)
			this.researchSupervisor = researchSupervisor;
		else throw new CanNotBeSupervisorException("This researcher has h-index less than 3");
	}
	
	public String toString() {
		return "GraduateStudent [" + super.toString() + ", degree=" + this.degree + ", research supervisor=" + this.researchSupervisor + ", papers=" + this.papers + "]";
	}

	@Override
	public Vector<ResearchPaper> printPapers() {
		// TODO Auto-generated method stub
		return ResearcherUtils.printPapers(this);
	}

	@Override
	public int calculateHIndex() {
		// TODO Auto-generated method stub
		return ResearcherUtils.calculateHIndex(this);
	}
	
}
