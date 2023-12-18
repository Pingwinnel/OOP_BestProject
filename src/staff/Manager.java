package staff;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import course.Course;
import student.Student;
import teacher.Teacher;
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
	
	public void addCoursesForRegis(Course crs) throws IOException {
		data.addCourse(crs);
	}
	
	public void deleteCoursesForRegis(Course crs) {
		
	}
	
	public void approveRegistration(Student s) {
		
	}
	
	public void addNews(News n) throws IOException {
		data.addNews(n);
	}
	
	public void viewInfoStudents() {
		
	}
	
	public List<User> viewInfoTeacher() throws Exception {
		List<User> teachers = DataSingleton.INSTANCE.getUsers().stream().filter(n->n instanceof Teacher).collect(Collectors.toList());
		return teachers;
	}

	public void createReport() {
		
	}
	
	public List<User> viewStudentsSortedByGpa() throws Exception{
		return DataSingleton.INSTANCE.getStudents().stream()
				.sorted(Comparator.comparingDouble(Student::getGpa).reversed())
				.collect(Collectors.toCollection(Vector::new));
	}
	
    public List<Student> viewStudentsSortedAlphabetically() {
    	return DataSingleton.INSTANCE.getStudents().stream()
        		.sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toCollection(Vector::new));
    }
    
    public static Vector<News> sortNews() {
    	Stream<News> researchNews = DataSingleton.INSTANCE.getNews().stream()
                    .filter(news -> news.getTitle().toLowerCase().contains("research"))
                    .sorted(Comparator.comparing(News::getPriority));
    	
    	Stream<News> nonResearchNews = DataSingleton.INSTANCE.getNews().stream()
    		    .filter(news -> !news.getTitle().toLowerCase().contains("research"))
    		    .sorted(Comparator.comparing(News::getPriority));
    	
        return Stream.concat(researchNews, nonResearchNews)
                .collect(Collectors.toCollection(Vector::new));
    }
	
}
