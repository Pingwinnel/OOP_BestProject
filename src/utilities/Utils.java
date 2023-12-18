package utilities;

import java.security.SecureRandom;
import java.util.Vector;

import researcher.Researcher;
import staff.Dean;
import staff.Employee;
import staff.Manager;
import staff.TechSupportSpecialist;
import staff.User;
import student.Student;
import teacher.Teacher;

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
		if(u instanceof Employee) {
			return u.getName().toLowerCase().charAt(0)+"."+u.getSurname().toLowerCase()+email;
		} 
		return u.getName().toLowerCase().charAt(0)+"_"+u.getSurname().toLowerCase()+email;
		
	}
	
	public static void sortUserData(User user) throws Exception {
			if(user instanceof Student) DataSingleton.INSTANCE.addStudents((Student) user);
			if(user instanceof Teacher) DataSingleton.INSTANCE.addTeacher((Teacher)user);
			if(user instanceof TechSupportSpecialist) DataSingleton.INSTANCE.addTechSupportSpecialist((TechSupportSpecialist)user);
			if(user instanceof Manager) DataSingleton.INSTANCE.addManager((Manager)user);
			if(user instanceof Researcher) DataSingleton.INSTANCE.addResearcher((Researcher)user);
		}
	}
