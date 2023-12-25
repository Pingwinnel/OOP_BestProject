/**
 * @author Yerasyil u r kakashka
 * @version 25.12.2023
 */
package course;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import student.Major;
import student.Schools;
/**this is Course class 
*/
public class Course implements Serializable{
	private static final long serialVersionUID = -197806065249070159L;
	private String name;
	//course code it used like unique id for course
	private String code;
	//Course school type in university
	private Schools school;
	//course number of credits to describe a course cost 
	private int credits;
	//Set of other course you need to study before you  take this course
	private HashSet<Course> prerequisites;
	//Hash set which referense majors to course type (free, minor,major)
	private HashMap<Major, CourseType> obligation = new HashMap<Major, CourseType>();
	
	{
		prerequisites = new HashSet<Course>();
	}
	
	public Course() {}
	
	public Course(String name) {
		this.name=name;
	}
	
	public Course(String name, String code, Schools school, int credits) {
		this.name = name;
		this.code = code;
		this.school = school;
		this.credits = credits;
	}
	/**
     * Getter method to retrieve the name of the course.
     *
     * @return The name of the course.
     */
	public String getName() {
		return name;
	}
/**
 * Setter method to set, change a name of the course
 * @param name  Course name
 */
	public void setName(String name) {
		this.name = name;
	}
	/**
     * Getter method to retrieve the code of the course.
     *
     * @return The code of the course.
     */
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

	/**
	 * The function returns a HashSet of Course objects representing the prerequisites for a course.
	 * 
	 * @return A HashSet of Course objects is being returned.
	 */
	public HashSet<Course> getPrerequisites() {
		return prerequisites;
	}

	/**
	 * The addCoursePrerequisites function adds a course as a prerequisite to another course.
	 * 
	 * @param c The parameter "c" is of type Course.
	 */
	public void addCoursePrerequisites(Course c) {
		prerequisites.add(c);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, credits, name, prerequisites, school);
	}

	@Override
	// The `equals(Object obj)` method is used to compare two `Course` objects for equality. It overrides
	// the default `equals` method provided by the `Object` class.
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
