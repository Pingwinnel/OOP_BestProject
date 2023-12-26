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
/**
 * This is `Student` class.
 * It extends the `User` class and includes specific attributes and methods related to student functionality.
 */
public class Student extends User {
	//Attributes specific to the Student class 
	private Schools school;
	private Major major;
	private double gpa;
	private HashMap<Course, Mark> marks = new HashMap<Course, Mark>();
	private int yearOfStudy;

	//Default constructor for the Student class.
	public Student() {
		
	}
    /**
     * Constructor to initialize a student with a given name.
     * 
     * @param name The name of the student.
     */
	public Student(String name) {
		super(name);
	}
    /**
     * Constructor to initialize a student with a given surname and name.
     *
     * @param surname The surname of the student.
     * @param name    The name of the student.
     */
	public Student(String surname, String name) {
		super(surname, name);
	}
    /**
     * Constructor to initialize a student with a given surname, name, school, and major.
     * 
     * @param surname The surname of the student.
     * @param name    The name of the student.
     * @param school  The school of the student.
     * @param major   The major of the student.
     */
	public Student(String surname, String name, Schools school, Major major) {
		super(surname, name);
		this.school = school;
		this.major = major;
		this.yearOfStudy = 1;
	}
    /**
     * Constructor to initialize a student with a given surname, name, school, major, and year of study.
     *
     * @param surname      The surname of the student.
     * @param name         The name of the student.
     * @param school       The school of the student.
     * @param major        The major of the student.
     * @param yearOfStudy  The year of study of the student.
     */
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
	
    /**
     * Getter method to retrieve the school of the student.
     *
     * @return The school of the student.
     */
	public Schools getSchool() {
		return school;
	}
    /**
     * Getter method to retrieve the major of the student.
     *
     * @return The major of the student.
     */
	public Major getMajor() {
		return major;
	}
	 /**
     * Getter method to retrieve the GPA of the student.
     *
     * @return The GPA of the student.
     */
	public double getGpa() {
		return gpa;
	}
    /**
     * Getter method to retrieve the year of study of the student.
     *
     * @return The year of study of the student.
     */
	public int getYearOfStudy() {
		return this.yearOfStudy;
	}
    /**
     * Method to retrieve the diploma project of the student.
     *
     * @return The diploma project of the student.
     */
	public DiplomaProject getDiplomaProject() {
		return (DiplomaProject) DataSingleton.INSTANCE.getDiplomaProject().stream().filter(n->n.getMembers().contains(this));
	}
	
	//Setter methods for various attributes
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
	
	//Setter method for Diploma Project
	public void setDiplomaProject(DiplomaProject diplomaProject) throws IOException {
		DataSingleton.INSTANCE.addDiplomaProject(diplomaProject);
	}

    /**
     * Method to view the mark of the student for a specific course.
     *
     * @param course The course for which to view the mark.
     * @return The mark of the student for the given course.
     */
	public HashMap<Course, Mark> viewMark(Course course) {
		for(Student s: DataSingleton.INSTANCE.getStudents()) {
			if(s.equals(this)) return s.getMarks();
		}
		return null;
		
	}
    //Method to view the transcript of the student, including marks for all courses.
	public void viewTranscript() {
		System.out.println("|Course|" +"|First Att|"+"|Second Att|"+"|Final|");
		marks.forEach((key,value)->{
			System.out.println("|"+key.getName()+"\t|"+value.getAtt1()+"\t|"+value.getAtt2()+"\t|"+value.getFinalExamScore()+"\t|\t"+value.getLetterGrade());
		});
	}
	//Method to view info about Teacher
	public void viewTeacherInfo(Course course) {
		
	}
	//Method to Register to some courses
	public void registerCourses(Course course) {
		marks.put(course, new Mark());
	}
	//Method to rate teachers
	public void rateTeachers() {
		//only those teachers which teach a student
		
	}
    /**
     * Method to retrieve the courses for registration.
     *
     * @return null.
     */
	public Vector<Course> getCoursesForRegistration() {
		return null;
		//return DataSingleton.getInstance().getCourse().stream().filter(n->n.);
	}
    /**
     * Method to retrieve Marks of the student.
     *
     * @return The HashMap with course name and Mark of the student.
     */
	public HashMap<Course, Mark> getMarks() {
		return marks;
	}
	//toString for Student
	public String toString() {
		return "Student [" + super.toString() + ", school= " + this.school + ", speciality= " + this.major + ", year of study= " + this.yearOfStudy + "]"; 
	}
	//Equals and hashcode for Student class
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		Student s = (Student) o;
		return this.gpa == s.gpa && this.yearOfStudy == s.yearOfStudy && this.major.equals(s.major) && this.school.equals(s.school);
	}
	
	public int hashCode() {
		return Objects.hash(getCorparateEmail(), getId(), getName(), getPassword(), getSurname(), getSchool(), getMajor(), getGpa(), getYearOfStudy());
	}
    /**
     * Inner class representing a student who is also a researcher.
     */
	public class ResearcherStudent implements Researcher{
        /**
         * Override of the toString method to provide a string representation of the researcher student.
         *
         * @return A string representation of the researcher student.
         */
		public String toString() {
			return "and I am a student researcher";
		}
        /**
         * Override of the printPapers method to print the research papers of the researcher student.
         *
         * @return A list of research papers.
         */
		@Override
		public List<ResearchPaper> printPapers() {
			// TODO Auto-generated method stub
			return ResearcherUtils.printPapers(this);
		}
        /**
         * Override of the calculateHIndex method to calculate the H-index of the researcher student.
         *
         * @return The calculated H-index.
         */
		@Override
		public int calculateHIndex() {
			// TODO Auto-generated method stub
			return ResearcherUtils.calculateHIndex(this);
		}

		
	}

	
	
}
