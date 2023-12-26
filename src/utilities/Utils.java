package utilities;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Vector;

import staff.User;
import student.Student;

/**
 * The Utils class provides utility methods for generating passwords, creating corporate email addresses, and printing lists
 * @author Code Symphony
 */
public class Utils {
	/**
     * Generates a random password with a combination of uppercase letters, lowercase letters, special characters and numbers
     * @return A randomly generated password
     */
	public static String generatePassword() {
		String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
      
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        
        for(int i = 0; i < 10; i++) {
        	int index = random.nextInt(combinedChars.length());
        	password.append(combinedChars.charAt(index));
        }
        return password.toString();
	}
	
	/**
     * Generates a corporate email address based on the user's name and surname as in KBTU system
     * (for students: it uses the first letter of the name, underscore, and the surname;
     * for other users: it uses the first letter of the name, dot and the surname)
     * @param u The user for whom the email address is generated
     * @return The generated corporate email address
     */
	public static String generateCorparateEmail(User u) {
		String email = "@kbtu.kz";
		if(u instanceof Student) return u.getName().toLowerCase().charAt(0)+"_"+u.getSurname().toLowerCase()+email;
		
		return u.getName().toLowerCase().charAt(0)+"."+u.getSurname().toLowerCase()+email;
	}
	
	/**
     * Prints the elements of the provided list with their corresponding indices
     * @param List the list to be printed
     * @return True if the list is not empty, False otherwise
     */
	public static Boolean printList(List list) {
		if(!list.isEmpty()) {
		for(int i=0; i<list.size(); i++)
			System.out.println(i+1+ ")" +list.get(i));
		return true;
	}
	return false;
}
}
