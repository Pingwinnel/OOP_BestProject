<<<<<<< HEAD
package tests;
=======
package test;
>>>>>>> 5a5af524f8e60aefd3369332c6c0a79b6f86052d

import java.io.IOException;

import staff.Dean;
import staff.Employee;
import student.Schools;
import teacher.Teacher;
import utilities.Request;

public class TestRequest {

	public static void main(String[] args) throws IOException{
		Dean dean = new Dean("Azamat", "Imanbaev", 550000, Schools.SITE);
<<<<<<< HEAD
        Employee teacher = new Teacher("Pakita", "Shamoi", 530000) {};
        Request request = new Request(dean, "Vacation");
        
//        teacher.sendRequest(request);
//        System.out.println(request);
        
        try {
            teacher.sendRequest(request);
            Request retrievedRequest = dean.getRequest();

            if (retrievedRequest != null) {
                System.out.println("Request received by Dean: " + retrievedRequest.getOrder());
            } else {
                System.out.println("Error: Request not received by Dean.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
=======
        Employee employee = new Teacher("Pakita", "Shamoi", 530000, Schools.SITE);
        Request request = new Request(dean, "Vacation");
        
        employee.sendRequest(request);
        System.out.println(dean.getRequest());
        
    
>>>>>>> 5a5af524f8e60aefd3369332c6c0a79b6f86052d
    }

}
