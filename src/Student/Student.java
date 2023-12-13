package student;

import java.util.HashMap;
import java.util.Objects;
import java.util.Vector;

import course.Course;
import utilities.Mark;
import researcher.ResearchPaper;
import researcher.Researcher;
import staff.User;

public class Student extends User {
	private Schools school;
	private String speciality;
	private double gpa;
	private HashMap<Course, Mark> marks;
	private int yearOfStudy;
//	private DiplomaProject diplomaProject;
	
	public Student() {
		
	}
	
	public Student(int id, String surname, String name, String corparateEmail, String password) {
		super(id, surname, name, corparateEmail, password);
	}
	
	public Student(int id, String surname, String name, String corparateEmail, String password, Schools school, String speciality, double gpa, int yearOfStudy) {
		super(id, surname, name, corparateEmail, password);
		this.school = school;
		this.speciality = speciality;
		this.gpa = gpa;
		this.yearOfStudy = yearOfStudy;
	}
	
	public Schools getSchool() {
		return school;
	}
	
	public String getSpeciality() {
		return speciality;
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
	
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
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

	
	public void viewMark(Course course) {
		
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
	}
	
	public HashMap<Course, Mark> getMarks() {
		return marks;
	}
	
	public String toString() {
		return "Student [" + super.toString() + ", school= " + this.school + ", speciality= " + this.speciality + ", gpa= " + this.gpa + ", year of study= " + this.yearOfStudy + "]"; 
	}
	
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		Student s = (Student) o;
		return this.gpa == s.gpa && this.yearOfStudy == s.yearOfStudy && this.speciality.equals(s.speciality) && this.school.equals(s.school);
	}
	
	public int hashCode() {
		return Objects.hash(getCorparateEmail(), getId(), getName(), getPassword(), getSurname(), getSchool(), getSpeciality(), getGpa(), getYearOfStudy());
	}
	
	
	class ResearcherStudent implements Researcher{
		public void printPapers() {
			System.out.println("papers");
		}
		public String toString() {
			return "I am a student researcher, my name is " + getName();
		}
		@Override
		public int calculateHIndex(Vector<ResearchPaper> papers) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	
	
}
