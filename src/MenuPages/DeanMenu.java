package MenuPages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import course.Course;
import course.Days;
import course.Lesson;
import course.LessonType;
import course.Time;
import researcher.ResearchPaper;
import researcher.Researcher;
import staff.Admin;
import staff.Dean;
import staff.Manager;
import student.Major;
import student.Schools;
import student.Student;
import student.StudentOrganization;
import teacher.Teacher;
import utilities.DataSingleton;
import utilities.News;
import utilities.Request;

public class DeanMenu {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    Dean dean;
    DataSingleton db;

    public DeanMenu(Dean dean, DataSingleton db) {
        this.dean = dean;
        this.db = db;
    }

    private void write() throws IOException {
        db.write();
    }

    private void exit() {
        System.out.println("Bye bye");
        try {
            write();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printList(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ")" + list.get(i));
        }
    }

    public void run() {
        System.out.println("Welcome, " + dean.getName() + " " + dean.getSurname() + "!");
        menu: while (true) {
            try {
                System.out.println("What do you wanna do?\n 1) Change Password \n 2) View News \n 3) View Lessons \n 4) View Students' Info \n 5) Approve Student Organization \n 6) View Requests \n 7) Read Complaints \n 8) Exit");
                int choice = Integer.parseInt(bf.readLine());

                switch (choice) {
                    case 1:
                        // Change Password
                        System.out.println("Enter new password: ");
                        String newPassword = bf.readLine();
                        dean.changePassword(newPassword);
                        break;

                    case 2:
                        // View News
                        System.out.println(dean.viewNews());
                        break;

                    case 3:
                        // View Lessons
                        System.out.println(dean.getLessons());
                        break;

                    case 4:
                        // View Students' Info
                        viewStudentsInfo();
                        break;

                    case 5:
                        // Approve Student Organization
                        approveStudentOrganization();
                        break;

//                    case 6:
//                        // Approve Request
//                        approveRequest();
//                        break;
                        
                    case 6:
                        // Approve Request
                        viewRequests();
                        break;

                    case 7:
                        // Read Complaints
                        dean.readComplaints();
                        System.out.println("Complaints read.");
                        break;

                    case 8:
                        // Exit
                        exit();
                        break menu;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void viewStudentsInfo() throws IOException {
        printList(dean.getLessons());
        int lessonChoice = Integer.parseInt(bf.readLine());
        List<Student> students = dean.viewStudentInfo(dean.getLessons().get(lessonChoice - 1));

        if (students.isEmpty()) {
            System.out.println("No students in the selected lesson.");
        } else {
            System.out.println("Students in the lesson:");
            printList(students);
        }
    }

    private void approveStudentOrganization() throws IOException {
        System.out.println("Enter Student Organization name: ");
        String orgName = bf.readLine();
//        boolean approved = dean.approveOrganization(StudentOrganization.getStudOrgName());

//        if (approved) {
//            System.out.println("Student Organization approved successfully.");
//        } else {
//            System.out.println("Failed to approve Student Organization.");
//        }
    }

    private void approveRequest() throws IOException {
        System.out.println("Enter request ID: ");
        int requestId = Integer.parseInt(bf.readLine());
        Request request = dean.getRequest();

        if (request != null) {
            dean.signRequest(request);
            System.out.println("Request approved.");
        } else {
            System.out.println("Invalid request ID.");
        }
    }
    
    private void selectAndApproveRequest(List<Request> requests) {
        System.out.println("Select a request to approve:");

        try {
            int requestChoice = Integer.parseInt(bf.readLine());
            if (requestChoice > 0 && requestChoice <= requests.size()) {
                Request selectedRequest = requests.get(requestChoice - 1);
                approveRequest();
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void viewRequests() {
        List<Request> requests = dean.viewRequests();

        if (requests.isEmpty()) {
            System.out.println("No pending requests.");
        } else {
            System.out.println("Pending Requests:");
            printList(requests);

            try {
                System.out.println("\n 1) Return back \n 2) Select Request \n 3) Exit");
                int choice = Integer.parseInt(bf.readLine());
                if (choice == 1) {
                    return;
                } else if (choice == 2) {
                    selectAndApproveRequest(requests);
                } else if (choice == 3) {
                    exit();
//                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
