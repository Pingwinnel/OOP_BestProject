package staff;

import java.util.Comparator;
import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;

import course.Course;
import student.Student;
import utilities.DataSingleton;
import utilities.News;

public class Manager extends Employee{
	DataSingleton data = DataSingleton.INSTANCE;
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
		return super.toString() + "I am manager " + type;
	}
	
	public void addCoursesForRegis(Course crs) {
		data.addCourse(crs);
	}
	
	public void deleteCoursesForRegis(Course crs) {
		
	}
	
	public void approveRegistration(Student s) {
		
	}
	
	public void addNews(News n) {
		data.addNews(n);
	}
	
	public void viewInfoStudents() {
		
	}
	
	public void viewInfoTeacher() {
		
	}

	public void createReport() {
		
	}
	
	public Vector<Student> viewStudentsSortedByGpa(){
		return DataSingleton.INSTANCE.getStudents().stream()
				.sorted(Comparator.comparingDouble(Student::getGpa).reversed())
				.collect(Collectors.toCollection(Vector::new));
	}
	
    public Vector<Student> viewStudentsSortedAlphabetically() {
        return DataSingleton.INSTANCE.getStudents().stream()
        		.sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toCollection(Vector::new));
    }
	
}
