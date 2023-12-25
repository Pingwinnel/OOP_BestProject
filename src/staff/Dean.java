package staff;

import java.util.Objects;

import student.Schools;
import student.StudentOrganization;
import teacher.Teacher;
import utilities.DataSingleton;
import utilities.Request;

public class Dean extends Teacher {
	private Schools faculty;

	public Dean() {
		// TODO Auto-generated constructor stub
	}

	public Dean(String surname, String name, double salary, Schools faculty) {
		super(surname, name, salary);
		this.faculty = faculty;
	}
	
    public void signRequest(Request request) {
        if (request.getReceiverDean().equals(this)) {
            System.out.println("Dean " + this.getName()+ " "+ this.getSurname() + " has signed the request: " + request.getOrder() + " from " + request.getSender());
            request.setSigned(true);
        } else {
            System.out.println("Dean " + this.getName() + " cannot sign the request. It's not intended for approval.");
        }
    }
	
	public boolean approveOrganization(StudentOrganization stor) {
		return false;
	}
	
	public void readComplaints() {
		DataSingleton.INSTANCE.getComplaintsByFaculty(this.faculty).removeAllElements();
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
	
	public Request getRequest() {
		for(Request r: DataSingleton.INSTANCE.getRequests()) {
			if(r.getReceiverDean().equals(this)) {
				return r;
			} 
		}
		return null;
	}
}