package student;
/**
 * The CanNotBeSupervisorException class is a custom exception that is thrown when an attempt is made to assign a supervisor in a situation where it is not allowed
 * @author CodeSymphony
 */
public class CanNotBeSupervisorException extends Exception {
    /**
     * Parameterized constructor for the CanNotBeSupervisorException class that creates an instance of the exception with a specific error message
     * @param message The error message associated with the exception
     */
	public CanNotBeSupervisorException(String message) {
		super(message);
	}
	
}
