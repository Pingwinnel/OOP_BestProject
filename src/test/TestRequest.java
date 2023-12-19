package utilities;

import java.io.IOException;

import staff.Dean;
import staff.Employee;
import student.Schools;

public class TestRequest {

	public static void main(String[] args) throws IOException {
		Dean dean = new Dean("Azamat", "Imanbaev", 550000, Schools.SITE);
        Employee employee = new Employee("Pakita", "Shamoi", 530000) {};
        Request request = new Request(dean, "Vacation");
        
//        employee.sendRequest(request);
//        System.out.println(dean.getRequest());
        
        try {
            employee.sendRequest(request);
            Request retrievedRequest = dean.getRequest();

            if (retrievedRequest != null) {
                System.out.println("Request received by Dean: " + retrievedRequest.getOrder());
            } else {
                System.out.println("Error: Request not received by Dean.");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
