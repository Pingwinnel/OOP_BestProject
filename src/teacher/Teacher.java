package teacher;

import java.util.Objects;
import java.util.Vector;

import course.Course;
import course.School;
import researcher.ResearcherUtils;
import researcher.ResearchPaper;
import researcher.Researcher;
import staff.Employee;
import student.Student;
import utilities.DataSingleton;

public class Teacher extends Employee{
	private School school;
	private Degree academicDegree;
	private Vector<Course> courses;
	DataSingleton db = DataSingleton.INSTANCE;
	
	{
		courses = new Vector<Course>();
	}
	
	public Teacher() {}
	public Teacher(String surname, String name, double salary, School school) {
		super(surname, name, salary);
		this.academicDegree = Degree.TUTOR;
		this.school = school;
	}
	
	public Teacher(String surname, String name, double salary, School school, Degree academicDegree) {
		super(surname, name, salary);
		this.setAcademicDegree(academicDegree);
		this.setSchool(school);
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
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
	
	public void putMark(Course c, Student s, Double score, int week) {
		if(week <= 8) s.getMarks().get(c).setAtt1(score);
		else if (week>8) s.getMarks().get(c).setAtt2(score);
		else s.getMarks().get(c).setFinalExamScore(score);
		
	}
	
	public Vector<Student> viewStudentInfo(){
		return null;
	}
	
	public void sendComplaint(String s, UrgencyLevel level) {
		String faculty = this.school.name(); 
		String complaint = "Urgency Level: " + level + "\n" + s;
        db.addComplaint(faculty, complaint); 
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
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
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
		public Vector<ResearchPaper> printPapers() {
			return ResearcherUtils.printPapers(this);
			
		}

		@Override
		public int calculateHIndex() {
			return ResearcherUtils.calculateHIndex(this);
			
		}
		
	}
	
	
	
}
