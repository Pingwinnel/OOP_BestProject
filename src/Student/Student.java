package Student;

import java.util.Date;
import Main.User;
import Teacher.Teacher;

import java.util.HashMap;
import java.util.Objects;
import java.util.Vector;

import Main.DataSingleton;

public class Student extends User {
	
	private Schools school;
	private String speciality;
	private double gpa;
	private HashMap<Course, Mark> marks;
	private int yearOfStudy;
	private DiplomaProject diplomaProject;
	private Date graduationDate;
	
	public Student() {
		
	}
	
	public Student(int id, String surname, String name, String corparateEmail, String password) {
		super(id, surname, name, corparateEmail, password);
	}
	
	public Student(int id, String surname, String name, String corparateEmail, String password, Schools school, String speciality, double gpa, int yearOfStudy, DiplomaProject diplomaProject, Date graduationDate) {
		super(id, surname, name, corparateEmail, password);
		this.school = school;
		this.speciality = speciality;
		this.gpa = gpa;
		this.yearOfStudy = yearOfStudy;
		this.diplomaProject = diplomaProject;
		this.graduationDate = graduationDate;
	}
	
	public Schools getSchool() {
		return this.school;
	}
	
	public String getSpeciality() {
		return this.speciality;
	}
	
	public double getGpa() {
		return this.gpa;
	}
	
	public HashMap<Course, Mark> getMarks() {
		return this.marks;
	}
	public void setMarks(Mark m,Course c) {
	if(marks.containsKey(c)) {
		Mark numGrade=marks.get(c);
		marks.replace(c, numGrade, m);
	}
	}
	
	public int getYearOfStudy() {
		return this.yearOfStudy;
	}
	
	public DiplomaProject getDiplomaProject() {
		return this.diplomaProject;
	}
	
	public Date getGraduationDate() {
		return this.graduationDate;
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
		this.diplomaProject = diplomaProject;
	}
	
	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}
	
	public void viewMark(Course course) {
		
	}
	
	public DataSingleton viewTranscript() {
		return null;
		
	}
	
	public void viewTeacherInfo(Teacher teacher) {
		
	}
	
	public void registerCourses(Course course) {
		
	}
	
	public void rateTeacher(Teacher teacher) {
		
	}
	
	public Vector<Course> getCoursesForRegistration() {
		return null;
		
	}
	
	public String toString() {
		return "Student [" + super.toString() + ", school= " + this.school + ", speciality= " + this.speciality + ", gpa= " + this.gpa + ", marks= " + this.marks + ", year of study= " + this.yearOfStudy + ", diploma project= " + this.diplomaProject + ", graduation date= " + this.graduationDate + "]"; 
	}
	
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		Student s = (Student) o;
		return this.gpa == s.gpa && this.yearOfStudy == s.yearOfStudy && this.speciality.equals(s.speciality) && this.school.equals(s.school) && this.marks.equals(s.marks) && this.diplomaProject.equals(s.diplomaProject) && this.graduationDate.equals(s.graduationDate);
	}
	
	public int hashCode() {
		return Objects.hash(getCorparateEmail(), getId(), getName(), getPassword(), getSurname(), getSchool(), getSpeciality(), getGpa(), getMarks(), getYearOfStudy(), getDiplomaProject(), getGraduationDate());
	}
	
}
