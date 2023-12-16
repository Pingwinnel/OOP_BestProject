package student;

import java.util.HashMap;
import java.util.Objects;
import java.util.Vector;

import course.Course;
import utilities.DataSingleton;
import utilities.Mark;
import researcher.ResearchPaper;
import researcher.Researcher;
import researcher.ResearcherUtils;
import staff.User;

public class Student extends User {
	private Schools school;
	private Major major;
	private double gpa;
	private HashMap<Course, Mark> marks;
	private int yearOfStudy;

	
	public Student() {
		
	}
	
	public Student(String surname, String name) {
		super(surname, name);
	}
	
	public Student(String surname, String name, Schools school, Major major) {
		super(surname, name);
		this.school = school;
		this.major = major;
		this.yearOfStudy = 1;
	}
	
	public Student(String surname, String name, Schools school, Major major, int yearOfStudy) {
		super(surname, name);
		this.school = school;
		this.major = major;
		this.yearOfStudy = yearOfStudy;
	}
	
	public Schools getSchool() {
		return school;
	}
	
	public Major getMajor() {
		return major;
	}
	
	public double getGpa() {
		return gpa;
	}
	
	public int getYearOfStudy() {
		return this.yearOfStudy;
	}
	
	public DiplomaProject getDiplomaProject() {
		return null; //from database
	}
	
	
	public void setSchool(Schools school) {
		this.school = school;
	}
	
	public void setMajor(Major major) {
		this.major = major;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	
	public void setDiplomaProject(DiplomaProject diplomaProject) {
		//add to db
	}

	
	public Mark viewMark(Course course) {
		return getMarks().get(course);
	}
	
	public void viewTranscript() {
		
	}
	
	public void viewTeacherInfo(Course course) {
		
	}
	
	public void registerCourses(Course course) {
		
	}
	
	public void rateTeachers() {
		//only those teachers which teach a student
		
	}
	
	public Vector<Course> getCoursesForRegistration() {
		return null;
		//return DataSingleton.getInstance().getCourse().stream().filter(n->n.);
	}
	
	public HashMap<Course, Mark> getMarks() {
		return marks;
	}
	
	public String toString() {
		return "Student [" + super.toString() + ", school= " + this.school + ", speciality= " + this.major + ", gpa= " + this.gpa + ", year of study= " + this.yearOfStudy + "]"; 
	}
	
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		Student s = (Student) o;
		return this.gpa == s.gpa && this.yearOfStudy == s.yearOfStudy && this.major.equals(s.major) && this.school.equals(s.school);
	}
	
	public int hashCode() {
		return Objects.hash(getCorparateEmail(), getId(), getName(), getPassword(), getSurname(), getSchool(), getMajor(), getGpa(), getYearOfStudy());
	}
	
	
	public class ResearcherStudent implements Researcher{
		public String toString() {
			return "I am a student researcher, my name is " + getName();
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

	
	
}
