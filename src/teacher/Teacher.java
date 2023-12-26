package teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import java.util.Vector;
import java.util.stream.Collectors;

import course.Course;
import course.Lesson;
import researcher.ResearcherUtils;
import researcher.ResearchPaper;
import researcher.Researcher;
import staff.Employee;
import student.Schools;
import student.Student;
import utilities.DataSingleton;
import utilities.ResearchUniversity;
/**
 * This is `Teacher` class.
 * It extends the `Employee` class and includes additional attributes and methods specific to teachers.
 * Teachers can be associated with a school and have an academic degree.
 */
public class Teacher extends Employee{
    // Attributes specific to the Teacher class
	private static final long serialVersionUID = 3831962457385399365L;
	private Schools school;
	private Degree academicDegree;
	//Default constructor for the Teacher class.
	public Teacher() {}
    /**
     * Constructor to initialize a teacher with a given surname, name, salary, and school.
     * The academic degree is set to the default value (TUTOR).
     *
     * @param surname      The surname of the teacher.
     * @param name         The name of the teacher.
     * @param salary       The salary of the teacher.
     * @param school       The school associated with the teacher.
     */
	public Teacher(String surname, String name, double salary, Schools school) {
		super(surname, name, salary);
		this.academicDegree = Degree.TUTOR;
		this.school = school;
	}
    /**
     * Constructor to initialize a teacher with a given surname, name, salary, school, and academic degree.
     *
     * @param surname       The surname of the teacher.
     * @param name          The name of the teacher.
     * @param salary        The salary of the teacher.
     * @param school        The school associated with the teacher.
     * @param academicDegree The academic degree of the teacher.
     */
	public Teacher(String surname, String name, double salary, Schools school, Degree academicDegree) {
		super(surname, name, salary);
		this.setAcademicDegree(academicDegree);
		this.setSchool(school);
	}
    /**
     * Constructor to initialize a teacher with a given surname, name, and salary.
     * The school and academic degree are not set initially.
     *
     * @param surname The surname of the teacher.
     * @param name    The name of the teacher.
     * @param salary  The salary of the teacher.
     */
	public Teacher(String surname, String name, double salary) {
		super(surname, name, salary);
	}
    /**
     * Getter method to retrieve the school associated with the teacher.
     *
     * @return The school associated with the teacher.
     */
	public Schools getSchool() {
		return school;
	}
    /**
     * Setter method to set the school associated with the teacher.
     *
     * @param school The school to be set for the teacher.
     */
	public void setSchool(Schools school) {
		this.school = school;
	}
    /**
     * Getter method to retrieve the academic degree of the teacher.
     *
     * @return The academic degree of the teacher.
     */
	public Degree getAcademicDegree() {
		return academicDegree;
	}
    /**
     * Setter method to set the academic degree of the teacher.
     *
     * @param academicDegree The academic degree to be set for the teacher.
     */
	public void setAcademicDegree(Degree academicDegree) {
		this.academicDegree = academicDegree;
	}
    /**
     * Method to view the courses associated with the teacher.
     *
     * @return A list of courses associated with the teacher.
     */
	public List<Course> viewCourses() {
		List<Course> courses = new ArrayList<Course>();
		for(Lesson l : getLessons()) {
			courses.add(l.getCourse());
		}
		return courses;
	}
    /**
     * Method to put a mark for a lesson for a specific student.
     *
     * @param l     The Lesson for which the mark is to be set.
     * @param s     The Student for whom the mark is to be set.
     * @param score The score to be set for the specified lesson and student.
     *
     * @throws IOException           If an I/O error occurs.
     */
	public void putMark(Lesson l, Student s, Double score) throws IOException {
		
		if(ResearchUniversity.INSTANCE.getWeek() <= 8) s.getMarks().get(l.getCourse()).setAtt1(score);
		
		else if(ResearchUniversity.INSTANCE.getWeek()>=14 && ResearchUniversity.INSTANCE.getWeek()>=15) s.getMarks().get(l.getCourse()).setAtt2(score);
		
		else if(ResearchUniversity.INSTANCE.getWeek() >= 16) s.getMarks().get(l.getCourse()).setFinalExamScore(score);;

		DataSingleton.write();
	
	}
    /**
     * Method to view information about students.
     *
     * @param l The lesson for which student information is to be viewed.
     * @return A list of students associated with the lesson.
     */
	public List<Student> viewStudentInfo(Lesson l){
		return DataSingleton.INSTANCE.getLessonsOfStudents().entrySet()
				.stream()
				.filter(n->n.getValue().equals(l))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		
	}
    /**
     * Method to get the lessons associated with the teacher.
     *
     * @return A list of lessons associated with the teacher.
     */
	public List<Lesson> getLessons() {
		return DataSingleton.INSTANCE.getLessonsOfTeachers().entrySet()
				.stream()
				.filter(n->n.getKey().equals(this))
				.map(Map.Entry::getValue)
				.collect(Collectors.toList());
	}
    /**
     * Method to send a complaint to the school administration.
     *
     * @param school The school to which the complaint is directed.
     * @param s      The content of the complaint.
     * @param level  The urgency level of the complaint.
     * @throws IOException If an I/O error occurs.
     */
	public void sendComplaint(Schools school, String s, UrgencyLevel level) throws IOException {
		String complaint = "\n" + "Urgency Level: " + level + " -> " + s;
		DataSingleton.INSTANCE.addComplaint(school, complaint); 
	}
	//Override of the hashcode and equals methods
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
    /**
     * Override of the toString method to provide a string representation of the teacher.
     *
     * @return A string representation of the teacher.
     */
	@Override
	public String toString() {
		return super.toString() + "Teacher' school: " + school + ", academicDegree: " + academicDegree;
	}
	
    /**
     * The `TeacherResearcher` class represents a researcher associated with a teacher.
     * It implements the `Researcher` interface, allowing teachers to engage in research activities.
     */
	public class TeacherResearcher implements Researcher{

        /**
         * Implementation of the printPapers method from the Researcher interface.
         * Delegates the printing of research papers to the ResearcherUtils class.
         *
         * @return A list of research papers associated with the teacher.
         */
        @Override
        public List<ResearchPaper> printPapers() {
            return ResearcherUtils.printPapers(this);
        }

        /**
         * Implementation of the calculateHIndex method from the Researcher interface.
         * Delegates the calculation of the H-index to the ResearcherUtils class.
         *
         * @return The calculated H-index of the teacher.
         */
		@Override
		public int calculateHIndex() {
			return ResearcherUtils.calculateHIndex(this);
			
		}
		
	}
	
	
	
}
