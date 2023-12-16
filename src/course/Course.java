package course;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import student.Major;

public class Course implements Serializable{
	private String name;
	private String code;
	private School school;
	private int credits;
	private HashSet<Course> prerequisites;
	private HashMap<Major, CourseType> obligation;
	
	{
		prerequisites = new HashSet<Course>();
	}
	
	public Course() {}
	
	public Course(String name, String code, School school, int credits) {
		this.name = name;
		this.code = code;
		this.school = school;
		this.credits = credits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public HashSet<Course> getPrerequisites() {
		return prerequisites;
	}

	public void addCoursePrerequisites(Course c) {
		prerequisites.add(c);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, credits, name, prerequisites, school);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Course other = (Course) obj;
		return credits == other.credits && Objects.equals(code, other.code) && Objects.equals(name, other.name)
				&& school == other.school && Objects.equals(prerequisites, other.prerequisites);
	}

	@Override
	public String toString() {
		return "Course name: " + name + ", code: " + code + ", school: " + school + ", credits: " + credits+" ";
	}
	
	
	
	
	
	
}
