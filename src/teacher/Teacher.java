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
 * The Teacher class includes additional attributes and methods specific to teachers who can be associated with a school and have an academic degree
 * @author Code Symphony
 */
public class Teacher extends Employee{
    // Attributes specific to the Teacher class
	private static final long serialVersionUID = 3831962457385399365L;
	private Schools school;
	private Degree academicDegree;

	/**
	 * Default empty constructor for the Teacher class
	 */
	public Teacher() {}
	
    /**
     * Parameterized constructor for the Teacher class that initializes a teacher with a given surname, name, salary and school
     * The academic degree is set to the default value (TUTOR)
     * @param surname      
     * @param name       
     * @param school  
     */
	public Teacher(String surname, String name, Schools school) {
		super(surname, name);
		this.academicDegree = Degree.TUTOR;
		this.school = school;
	}
    /**
     * Parameterized constructor for the Teacher class that initializes a teacher with a given surname, name, salary, school and academic degree
     * @param surname      
     * @param name       
     * @param school       
     * @param academicDegree 
     */
	public Teacher(String surname, String name,  Schools school, Degree academicDegree) {
		super(surname, name);
		this.setAcademicDegree(academicDegree);
		this.setSchool(school);
	}
	
	public Teacher(String surname, String name) {
		super(surname, name);
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
    /**
     * Setter method to set the academic degree of the teacher.
     *
     * @param academicDegree The academic degree to be set for the teacher.
     */
	public void setAcademicDegree(Degree academicDegree) {
		this.academicDegree = academicDegree;
	}
	
    /**
     * Displays the courses associated with the teacher
     * @return A list of courses associated with the teacher
     */
	public List<Course> viewCourses() {
		List<Course> courses = new ArrayList<Course>();
		for(Lesson l : getLessons()) {
			courses.add(l.getCourse());
		}
		return courses;
	}
	
    /**
     * Puts a mark for a lesson for a specific student
     * @param l The Lesson for which the mark is to be set
     * @param s The Student for whom the mark is to be set
     * @param score The score to be set for the specified lesson and student
     * @throws IOException If an I/O error occurs
     */
	public void putMark(Lesson l, Student s, Double score) throws IOException {
		
		if(ResearchUniversity.INSTANCE.getWeek() <= 8) s.getMarks().get(l.getCourse()).setAtt1(score);
		
		else if(ResearchUniversity.INSTANCE.getWeek()>=14 && ResearchUniversity.INSTANCE.getWeek()>=15) s.getMarks().get(l.getCourse()).setAtt2(score);
		
		else if(ResearchUniversity.INSTANCE.getWeek() >= 16) s.getMarks().get(l.getCourse()).setFinalExamScore(score);;

		DataSingleton.write();
	
	}
	
    /**
     * Displays information about students
     * @param l The lesson for which student information is to be viewed
     * @return A list of students associated with the lesson
     */
	public List<Student> viewStudentInfo(Lesson l){
		
		return DataSingleton.INSTANCE.getLessonsOfStudents().entrySet()
				.stream()
				.filter(n->n.getValue().contains(l))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		
	}
    
	public List<Lesson> getLessons() {
		return DataSingleton.INSTANCE.getLessonsOfTeachers().get(this);
	}
	
    /**
     * Sends a complaint to the school administration
     * @param school The school to which the complaint is directed
     * @param s The content of the complaint
     * @param level The urgency level of the complaint
     * @throws IOException If an I/O error occurs
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
   
	@Override
	public String toString() {
		return super.toString() + "Teacher' school: " + school + ", academicDegree: " + academicDegree;
	}
	
    /**
     * The TeacherResearcher class represents a researcher associated with a teacher
     */
	public class TeacherResearcher implements Researcher{

        /**
         * Delegates the printing of research papers to the ResearcherUtils class
         * @return A list of research papers associated with the teacher
         */
        @Override
        public List<ResearchPaper> printPapers() {
            return ResearcherUtils.printPapers(this);
        }

        /**
         * Delegates the calculation of the H-index to the ResearcherUtils class
         * @return The calculated H-index of the teacher
         */
		@Override
		public int calculateHIndex() {
			return ResearcherUtils.calculateHIndex(this);
			
		}
		
	}
	
	
	
}
