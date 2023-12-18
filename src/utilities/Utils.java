package utilities;

import java.security.SecureRandom;
import staff.User;
import student.Student;


public class Utils {
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
	
	public static String generateCorparateEmail(User u) {
		String email = "@kbtu.kz";
		if(u instanceof Student) {
			return u.getName().toLowerCase().charAt(0)+"_"+u.getSurname().toLowerCase()+email;
		} 
		return u.getName().toLowerCase().charAt(0)+"."+u.getSurname().toLowerCase()+email;
		
	}
}
