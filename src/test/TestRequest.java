
package test;


import java.io.IOException;

import staff.Dean;
import staff.Employee;
import student.Schools;
import teacher.Teacher;
import utilities.Request;

public class TestRequest {

	public static void main(String[] args) throws IOException{
		Dean dean = new Dean("Azamat", "Imanbaev", Schools.SITE);

        Employee teacher = new Teacher("Pakita", "Shamoi");
        Request request = new Request(dean, "Vacation");
        
        teacher.sendRequest(request);
        System.out.println(request);
        
      

    }

}
