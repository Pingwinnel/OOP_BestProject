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

public class Teacher extends Employee{
	
	private static final long serialVersionUID = 3831962457385399365L;
	private Schools school;
	private Degree academicDegree;
	
	public Teacher() {}
	
	public Teacher(String surname, String name, double salary, Schools school) {
		super(surname, name, salary);
		this.academicDegree = Degree.TUTOR;
		this.school = school;
	}
	
	public Teacher(String surname, String name, double salary, Schools school, Degree academicDegree) {
		super(surname, name, salary);
		this.setAcademicDegree(academicDegree);
		this.setSchool(school);
	}
	
	public Teacher(String surname, String name, double salary) {
		super(surname, name, salary);
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

	public void setAcademicDegree(Degree academicDegree) {
		this.academicDegree = academicDegree;
	}
	
	public List<Course> viewCourses() {
		List<Course> courses = new ArrayList<Course>();
		for(Lesson l : getLessons()) {
			courses.add(l.getCourse());
		}
		return courses;
	}
	
	public void putMark(Lesson l) throws NumberFormatException, IOException {
//		if(ResearchUniversity.INSTANCE.getWeek() <= 8) s.getMarks().get(c).setAtt1(score);
//		else if (ResearchUniversity.INSTANCE.getWeek()>=14 && ResearchUniversity.INSTANCE.getWeek()>=15) s.getMarks().get(c).setAtt2(score);
//		else s.getMarks().get(c).setFinalExamScore(score);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int i = Integer.parseInt(bf.readLine()) - 1;
		Student s = viewStudentInfo(l).get(i);
		System.out.println("Score:");
		Double score = Double.parseDouble(bf.readLine());
		if(s.getMarks().containsKey(l.getCourse())) {
			s.getMarks().get(l.getCourse()).setAtt1(score);
			System.out.println("Added");
		} else System.out.println("Already have a mark, you cannot change it!");
	
	}
	public List<Student> viewStudentInfo(Lesson l){
		return DataSingleton.INSTANCE.getLessonsOfStudents().entrySet()
				.stream()
				.filter(n->n.getValue().equals(l))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		
	}
	
	public List<Lesson> getLessons() {
		return DataSingleton.INSTANCE.getLessonsOfTeachers().entrySet()
				.stream()
				.filter(n->n.getKey().equals(this))
				.map(Map.Entry::getValue)
				.collect(Collectors.toList());
	}
	
	public void sendComplaint(Schools school, String s, UrgencyLevel level) throws IOException {
		String complaint = "\n" + "Urgency Level: " + level + " -> " + s;
		DataSingleton.INSTANCE.addComplaint(school, complaint); 
	}

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
	
	
	public class TeacherResearcher implements Researcher{

		@Override
		public List<ResearchPaper> printPapers() {
			return ResearcherUtils.printPapers(this);
			
		}

		@Override
		public int calculateHIndex() {
			return ResearcherUtils.calculateHIndex(this);
			
		}
		
	}
	
	
	
}
