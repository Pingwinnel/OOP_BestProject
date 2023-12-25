package staff;

import java.io.IOException;
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

public class Manager extends Employee{
	
	private ManagerType type;	
	
	public Manager() {
		
	}

	public Manager(String surname, String name, double salary, ManagerType type) {
		super(surname, name, salary);
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
	
	public void addCoursesForRegis(Course crs) throws IOException {
		DataSingleton.INSTANCE.addCourse(crs);
		DataSingleton.write();
	}
	
	public void addLessonToSystem(Lesson l) throws IOException {
		DataSingleton.INSTANCE.getLessons().add(l);
		DataSingleton.write();
	}
	
	public void deleteLessonFromSystem(Lesson l) throws IOException {
		DataSingleton.INSTANCE.getLessons().remove(l);
		DataSingleton.write();
	}
	
	public void attachLessonToTeacher(Teacher t, Lesson l) throws Exception {
		for(Teacher tt: DataSingleton.INSTANCE.getTeachers()) {
			if(tt.equals(t)) {
				DataSingleton.INSTANCE.getLessonsOfTeachers().put(tt, l);
				DataSingleton.write();
			}
		}
	}
	
	public void detachLessonToTeacher(Teacher t, Lesson l) throws IOException {
		for(Teacher tt: DataSingleton.INSTANCE.getTeachers()) {
			if(tt.equals(t)) {
				DataSingleton.INSTANCE.getLessonsOfTeachers().remove(tt, l);
				DataSingleton.write();
			}
		}
	}
	
	public void attachLessonToStudent(Student s, Lesson l) throws Exception {
		for(Student st: DataSingleton.INSTANCE.getStudents()) {
			if(st.equals(s)) {
				DataSingleton.INSTANCE.getLessonsOfStudents().put(st, l);
				DataSingleton.write();
			}
		}
	}
	
	public void detachLessonToStudent(Student s, Lesson l) throws IOException {
		for(Student st: DataSingleton.INSTANCE.getStudents()) {
			if(st.equals(s)) {
				DataSingleton.INSTANCE.getLessonsOfStudents().remove(s, l);
				DataSingleton.write();
			}
		}
	}
	
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
	
	public void addNews(News n) throws IOException {
		DataSingleton.INSTANCE.addNews(n);
		DataSingleton.write();
	}
	
	
	public List<User> viewInfoTeacher() throws Exception {
		List<User> teachers = DataSingleton.INSTANCE.getUsers().stream().filter(n->n instanceof Teacher).collect(Collectors.toList());
		return teachers;
	}

    public String createReportBySchool(Schools school) {
        List<Student> students = DataSingleton.INSTANCE.getStudents();

        double averageGPA = students.stream()
                .filter(student -> student.getSchool().equals(school))
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);

        return "Average GPA for " + school + ": " + averageGPA;
    }
	
	public List<User> viewStudentsSortedByGpa() throws Exception{
		return DataSingleton.INSTANCE.getStudents().stream()
				.sorted(Comparator.comparingDouble(Student::getGpa).reversed())
				.collect(Collectors.toCollection(Vector::new));
	}
	
    public List<Student> viewStudentsSortedAlphabetically() {
 		return DataSingleton.INSTANCE.getStudents().stream()
      			.sorted(Comparator.comparing(Student::getSurname))
           		.collect(Collectors.toCollection(Vector::new));
   	}
	
}
