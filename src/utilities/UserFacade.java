package utilities;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

import staff.User;

public class UserFacade extends User   {
	public static User userSetter() throws IOException {
		User user;
		Vector<String> vector  = new Vector<String>();
		vector.add("id");
		vector.add("surname");
		vector.add("name");
		vector.add("corparate email");
		vector.add("password");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = " ";
		System.out.println("Enter "+vector+" with {,} " +":");
		while(true) {
			line = br.readLine();
			StringTokenizer stringTokenizer=new StringTokenizer(line,",");
			try {
				if(stringTokenizer.countTokens()!=5) { System.out.println("You dont have input enought token");
				continue;
				}
				user=new User(Integer.parseInt(stringTokenizer.nextToken()),stringTokenizer.nextToken(),stringTokenizer.nextToken(),stringTokenizer.nextToken(),stringTokenizer.nextToken());
				break;
			}
			catch (Exception e) {
				System.out.println("You  input wrong");
			}
		}
		return user;
	}
}

