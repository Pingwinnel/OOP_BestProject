/**
 * @author Yerasyil
 * @version 25.12.2023
 */
package researcher;
//This class used as custom exception when you  join a Researcher project if your not a researcher
public class CanNotJoinToProjectException extends Exception {
/**
 * This constructor use a parent exception constructor 
 * @param message 
 */
	public CanNotJoinToProjectException(String message) {
		//Exception constructor
		super(message);
	}
}
