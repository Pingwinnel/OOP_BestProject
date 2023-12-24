package student;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
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
	private HashMap<Course, Mark> marks = new HashMap<Course, Mark>();
	private int yearOfStudy;

	
	public Student() {
		
	}
	public Student(String name) {
		super(name);
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
	
	//for test
	public Student(String surname, String name, double gpa) {
		super(surname, name);
		this.gpa = gpa;
	}
	
	//for test createReport
	public Student(String name, double gpa, Schools school) {
		super(name);
		this.gpa = gpa;
		this.school = school;
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
		return (DiplomaProject) DataSingleton.INSTANCE.getDiplomaProject().stream().filter(n->n.getMembers().contains(this));
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
	
	public void setDiplomaProject(DiplomaProject diplomaProject) throws IOException {
		DataSingleton.INSTANCE.addDiplomaProject(diplomaProject);
	}

	
	public Mark viewMark(Course course) {
		return getMarks().get(course);
	}
	
	public void viewTranscript() {
		System.out.println("|Course|" +"|First Att|"+"|Second Att|"+"|Final|");
		marks.forEach((key,value)->{
			System.out.println("|"+key.getName()+"\t|"+value.getAtt1()+"\t|"+value.getAtt2()+"\t|"+value.getFinalExamScore()+"\t|\t"+value.getLetterGrade());
		});
	}
	
	public void viewTeacherInfo(Course course) {
		
	}
	
	public void registerCourses(Course course) {
		marks.put(course, new Mark());
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
		return "Student [" + super.toString() + ", school= " + this.school + ", speciality= " + this.major + ", year of study= " + this.yearOfStudy + "]"; 
	}
	
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		Student s = (Student) o;
		return this.gpa == s.gpa && this.yearOfStudy == s.yearOfStudy && this.major.equals(s.major) && this.school.equals(s.school);
	}
	
	public int hashCode() {
		return Objects.hash(getCorparateEmail(), getId(), getName(), getPassword(), getSurname(), getSchool(), getMajor(), getGpa(), getYearOfStudy());
	}
	

	@Override
	public void update(List<ResearchPaper> researchPapers) {
		// TODO Auto-generated method stub
		
	}
	
	public class ResearcherStudent implements Researcher{
		public String toString() {
			return "and I am a student researcher";
		}

		@Override
		public List<ResearchPaper> printPapers() {
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
