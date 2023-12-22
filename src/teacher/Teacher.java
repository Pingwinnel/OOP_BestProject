package teacher;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import java.util.Vector;

import course.Course;
import researcher.ResearcherUtils;
import researcher.ResearchPaper;
import researcher.Researcher;
import staff.Employee;
import student.Schools;
import student.Student;
import utilities.DataSingleton;
import utilities.ResearchUniversity;

public class Teacher extends Employee{
	
	private static final long serialVersionUID = 3831962457385399365L;
	private Schools school;
	private Degree academicDegree;
	private Vector<Course> courses;
	DataSingleton db = DataSingleton.INSTANCE;
	
	{
		courses = new Vector<Course>();
	}
	
	public Teacher() {}
	
	public Teacher(String surname, String name, double salary, Schools school) {
		super(surname, name, salary);
		this.academicDegree = Degree.TUTOR;
		this.school = school;
	}
	
	public Teacher(String surname, String name, double salary, Schools school, Degree academicDegree) {
		super(surname, name, salary);
		this.setAcademicDegree(academicDegree);
		this.setSchool(school);
	}
	
	public Teacher(String surname, String name, double salary) {
		super(surname, name, salary);
	}

	public Schools getSchool() {
		return school;
	}

	public void setSchool(Schools school) {
		this.school = school;
	}

	public Degree getAcademicDegree() {
		return academicDegree;
	}

	public void setAcademicDegree(Degree academicDegree) {
		this.academicDegree = academicDegree;
	}

	public Vector<Course> viewCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public void putMark(Course c, Student s, Double score) {
		if(ResearchUniversity.INSTANCE.getWeek() <= 8) s.getMarks().get(c).setAtt1(score);
		else if (ResearchUniversity.INSTANCE.getWeek()>=14 && ResearchUniversity.INSTANCE.getWeek()>=15) s.getMarks().get(c).setAtt2(score);
		else s.getMarks().get(c).setFinalExamScore(score);
		
	}
	
	public Vector<Student> viewStudentInfo(){
		return null;
	}
	
	public void sendComplaint(Schools school, String s, UrgencyLevel level) {
		String complaint = "\n" + "Urgency Level: " + level + " -> " + s;
        db.addComplaint(school, complaint); 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(academicDegree, school);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		Teacher other = (Teacher) obj;
		return academicDegree == other.academicDegree && school == other.school;
	}

	@Override
	public String toString() {
		return super.toString() + "Teacher' school: " + school + ", academicDegree: " + academicDegree + ", courses: " + courses;
	}
	
	
	public class TeacherResearcher implements Researcher{

		@Override
		public List<ResearchPaper> printPapers() {
			return ResearcherUtils.printPapers(this);
			
		}

		@Override
		public int calculateHIndex() {
			return ResearcherUtils.calculateHIndex(this);
			
		}
		
	}
	
	
	
}
