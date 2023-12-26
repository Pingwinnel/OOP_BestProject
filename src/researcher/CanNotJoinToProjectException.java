package researcher;

/**
 * The CanNotJoinToProjectException class represents a custom exception that is thrown when an attempt is made to join a researcher project
 * without having the appropriate researcher status
 * @author Code Symphony
 */
public class CanNotJoinToProjectException extends Exception {
/**
 * Parameterized constructor for the CanNotJoinToProjectException class with the specified detail message that uses a parent exception constructor 
 * @param message 
 */
	public CanNotJoinToProjectException(String message) {
		//Exception constructor
		super(message);
	}
}
