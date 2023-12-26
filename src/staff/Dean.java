package staff;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import student.Schools;
import student.StudentOrganization;
import teacher.Teacher;
import utilities.DataSingleton;
import utilities.Request;

/**
 * The Dean class represents a dean who has responsibilities such as signing requests, handling student organizations and reading complaints 
 * @author Code Symphony
 */
public class Dean extends Teacher {
	private Schools faculty;

	/**
	 * Default empty constructor for the Dean class 
	 */
	public Dean() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Parameterized constructoe for the Dean class
	 * @param surname
	 * @param name
	 * @param faculty
	 */
	public Dean(String surname, String name, Schools faculty) {
		super(surname, name);
		this.faculty = faculty;
	}
	
	/**
	 * Signs a request if the dean is the intended approver
     * @param request The request to be signed
	 */
    public void signRequest(Request request) {
        if (request.getReceiverDean().equals(this)) {
            System.out.println("Dean " + this.getName()+ " "+ this.getSurname() + " has signed the request: " + request.getOrder() + " from " + request.getSender());
            request.setSigned(true);
        } else {
            System.out.println("Dean " + this.getName() + " cannot sign the request. It's not intended for approval.");
        }
    }
	
    /**
     * Approves a student organization 
     * @param stor The student organization to be approved
     * @return Always returns false (implementation?)
     */
	public boolean approveOrganization(StudentOrganization stor) {
		return false;
	}
	
	/**
     * Reads and clears complaints associated with the dean's faculty
	 * @throws IOException 
     */
	public void readComplaints() throws IOException {
		DataSingleton.INSTANCE.getComplaintsByFaculty(this.faculty).removeAllElements();
		DataSingleton.write();
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
	
    /**
     * Retrieves the pending request assigned to the dean
     * @return The pending request assigned to the dean or null if none exists
     */
	public Request getRequest() {
		for(Request r: DataSingleton.INSTANCE.getRequests()) {
			if(r.getReceiverDean().equals(this)) {
				return r;
			} 
		}
		return null;
	}
	
	public List<Request> viewRequests() {
        List<Request> deanRequests = DataSingleton.INSTANCE.getRequests();
        deanRequests.removeIf(request -> !request.getReceiverDean().equals(this)); // Filter requests for the current dean
        return deanRequests;
        }
}