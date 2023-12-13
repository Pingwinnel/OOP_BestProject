package staff;

import java.util.Objects;

import student.Schools;
import student.StudentOrganization;

public class Dean extends Employee {
	private Schools faculty;

	public Dean() {
		// TODO Auto-generated constructor stub
	}

	public Dean(int id, String surname, String name, String corparateEmail, String password, double salary, Schools faculty) {
		super(id, surname, name, corparateEmail, password, salary);
		this.faculty = faculty;
	}
	
	public void signRequest(Employee emp) {
		
	}
	
	public boolean approveOrganization(StudentOrganization stor) {
		return false;
	}

    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Dean dean = (Dean) o;
        return Objects.equals(faculty, dean.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculty);
    }
    
    public String toString() {
        return "Dean{"  + super.toString() + "faculty=" + faculty + "} ";
    }
}