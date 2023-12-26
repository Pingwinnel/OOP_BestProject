package staff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import course.Course;
import course.Lesson;
import student.Schools;
import student.Student;
import teacher.Teacher;
import utilities.DataSingleton;
import utilities.Mark;
import utilities.News;

/**
 * The Manager class represents a manager who has responsibilities related to course and lesson management, student registration and information viewing
 * @author Code Symphony
 */
public class Manager extends Employee{
	
	private ManagerType type;	
	
	/**
	 * Default empty constructor for the Manager class
	 */
	public Manager() {
		
	}

	/**
	 * Parameterized constructor for the Manager class
	 * @param surname
	 * @param name
	 * @param type
	 */
	public Manager(String surname, String name, ManagerType type) {
		super(surname, name);
		this.type = type;
	}

	public ManagerType getType() {
		return type;
	}

	public void setType(ManagerType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(type);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) return false;
		Manager other = (Manager) obj;
		return type == other.type;
	}

	@Override
	public String toString() {
		return super.toString() + "Manager " + type;
	}
	
	/**
     * Adds a course for registration to the system
     * @param crs The course to be added
     * @throws IOException If an error occurs during course addition
     */
	public void addCoursesForRegis(Course crs) throws IOException {
		DataSingleton.INSTANCE.addCourse(crs);
		DataSingleton.write();
	}
	
	/**
     * Adds a lesson to the system
     * @param l The lesson to be added
     * @throws IOException If an error occurs during lesson addition
     */
	public void addLessonToSystem(Lesson l) throws IOException {
		DataSingleton.INSTANCE.getLessons().add(l);
		DataSingleton.write();
	}
	
	/**
     * Deletes a lesson from the system
     * @param l The lesson to be deleted
     * @throws IOException If an error occurs during lesson deletion
     */
	public void deleteLessonFromSystem(Lesson l) throws IOException {
		DataSingleton.INSTANCE.getLessons().remove(l);
		DataSingleton.write();
	}
	
	/**
     * Attaches a lesson to a teacher
     * @param t The teacher to attach the lesson to
     * @param l The lesson to be attached
     * @throws Exception If an error occurs during attachment
     */
	public void attachLessonToTeacher(Teacher t, Lesson l) throws Exception {
		for(Teacher tt: DataSingleton.INSTANCE.getTeachers()) {
			if(tt.equals(t)) {
				if(DataSingleton.INSTANCE.getLessonsOfTeachers().get(tt) == null) {
					DataSingleton.INSTANCE.getLessonsOfTeachers().put(tt, new ArrayList<Lesson>());
				} 
				DataSingleton.INSTANCE.getLessonsOfTeachers().get(tt).add(l);
				DataSingleton.write();
			}
		}
	}
	
	/**
     * Detaches a lesson from a teacher
     * @param t The teacher to detach the lesson from
     * @param l The lesson to be detached
     * @throws IOException If an error occurs during detachment
     */
	public void detachLessonToTeacher(Teacher t, Lesson l) throws IOException {
		for(Teacher tt: DataSingleton.INSTANCE.getTeachers()) {
			if(tt.equals(t)) {
				DataSingleton.INSTANCE.getLessonsOfTeachers().get(tt).remove(l);
				DataSingleton.write();
			}
		}
	}
	
	/**
     * Attaches a lesson to a student
     * @param s The student to attach the lesson to
     * @param l The lesson to be attached
     * @throws Exception If an error occurs during attachment
     */
	public void attachLessonToStudent(Student s, Lesson l) throws Exception {
		for(Student st: DataSingleton.INSTANCE.getStudents()) {
			if(st.equals(s)) {
				if(DataSingleton.INSTANCE.getLessonsOfStudents().get(st) == null) {
					DataSingleton.INSTANCE.getLessonsOfStudents().put(st, new ArrayList<Lesson>());
				} 
				DataSingleton.INSTANCE.getLessonsOfStudents().get(st).add(l);
				DataSingleton.write();
			}
		}
	}
	
	/**
     * Detaches a lesson from a student
     * @param s The student to detach the lesson from
     * @param l The lesson to be detached
     * @throws IOException If an error occurs during detachment
     */
	public void detachLessonToStudent(Student s, Lesson l) throws IOException {
		for(Student st: DataSingleton.INSTANCE.getStudents()) {
			if(st.equals(s)) {
				DataSingleton.INSTANCE.getLessonsOfStudents().get(st).remove(l);
				DataSingleton.write();
			}
		}
	}
	
	 /**
     * Approves the registration of a student for a course
     * @param s The student to approve registration for
     * @param c The course for which registration is approved
     * @throws Exception If an error occurs during approval
     */
	public void approveRegistration(Student s, Course c) throws Exception {
		for(User u: DataSingleton.INSTANCE.getUsers()) {
			if(u instanceof Student) {
				Student st = (Student)u;
				if(st.equals(s)) {
					if(!st.getMarks().containsKey(c)) 
						st.getMarks().put(c, new Mark());
				}
			}
			
		}
		DataSingleton.write();
	}
	
	/**
     * Adds news to the system
     * @param n The news to be added
     * @throws IOException If an error occurs during news addition
     */
	public void addNews(News n) throws IOException {
		DataSingleton.INSTANCE.addNews(n);
		DataSingleton.write();
	}
	
	/**
     * Views information about teachers in the system
     * @return A list of users representing teachers
     * @throws Exception If an error occurs during information viewing
     */
	public List<User> viewInfoTeacher() throws Exception {
		List<User> teachers = DataSingleton.INSTANCE.getUsers().stream().filter(n->n instanceof Teacher).collect(Collectors.toList());
		return teachers;
	}

	/**
     * Creates a report of the average GPA for students in a specific school
     * @param school The school for which the report is generated
     * @return The report as a string
     */
    public String createReportBySchool(Schools school) {
        List<Student> students = DataSingleton.INSTANCE.getStudents();

        double averageGPA = students.stream()
                .filter(student -> student.getSchool().equals(school))
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);

        return "Average GPA for " + school + ": " + averageGPA;
    }
	
    /**
     * Views students sorted by GPA in descending order
     * @return A list of users representing students, sorted by GPA in descending order
     * @throws Exception If an error occurs during information viewing
     */
	public List<User> viewStudentsSortedByGpa() throws Exception{
		return DataSingleton.INSTANCE.getStudents().stream()
				.sorted(Comparator.comparingDouble(Student::getGpa).reversed())
				.collect(Collectors.toCollection(Vector::new));
	}
	
	/**
     * Views students sorted alphabetically by surname
     * @return A list of students sorted alphabetically by surname
     */
    public List<Student> viewStudentsSortedAlphabetically() {
 		return DataSingleton.INSTANCE.getStudents().stream()
      			.sorted(Comparator.comparing(Student::getSurname))
           		.collect(Collectors.toCollection(Vector::new));
   	}
	
}
