package test;

import java.io.IOException;
import MenuPages.*;

public class testStudentMenu {

	public static void main(String[] args) throws Exception {
		try {
			( new studentMenu()).run();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
