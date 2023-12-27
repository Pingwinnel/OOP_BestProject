package MenuPages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import teacher.Professor;
import teacher.Teacher;
import teacher.Teacher.TeacherResearcher;
import utilities.DataSingleton;
import utilities.Message;
import utilities.Request;
import utilities.UniversityJournal;
import researcher.ResearchPaper;
import researcher.Researcher;
import staff.Employee;
import student.Student;

public class ProfessorMenu {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    Professor professor;

    public ProfessorMenu(Professor professor) {
        this.professor = professor;
    }

    private void write() throws IOException {
        DataSingleton.write();
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
        System.out.println("Welcome, " + professor.getName() + " " + professor.getSurname() + "!");
        menu: while (true) {
            try {
                System.out.println("What do you wanna do?\n 1) Change Password \n 2) View News \n 3) View Lessons \n 4) View Students' Info \n 5) Put Mark \n 6) Send Request \n 7) Send Message \n 8) Get Message \n 9) Send Complaint\n 10) Add Research Paper \n 11) University journal \n 12) Exit");
                int choice = Integer.parseInt(bf.readLine());

                switch (choice) {
                    case 1:
                        // Change Password
                        System.out.println("Enter new password: ");
                        String newPassword = bf.readLine();
                        professor.changePassword(newPassword);
                        break;

                    case 2:
                        // View News
                        System.out.println(professor.viewNews());
                        break;

                    case 3:
                        // View Lessons
                        System.out.println(professor.getLessons());
                        break;

                    case 4:
                        // View Students' Info
                        viewStudentsInfo();
                        break;

                    case 5:
                        // Put Mark
                        putMark();
                        break;

                    case 6:
                        // Send Request
                        sendRequest();
                        break;

                    case 7:
                        // Send Message
                        sendMessage();
                        break;

                    case 8:
                        // Get Message
                        getMessage();
                        break;

                    case 9:
                        // Send Complaint
                        sendComplaint();
                        break;

                    case 10:
                        addResearchPaper();
                        break;

                    case 11:
                        // University journal
                    	viewUniversityJournal();
                    	break;

                    case 12:
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
        printList(professor.getLessons());
        int lessonChoice = Integer.parseInt(bf.readLine());
        List<Student> students = professor.viewStudentInfo(professor.getLessons().get(lessonChoice - 1));

        if (students.isEmpty()) {
            System.out.println("No students in the selected lesson.");
        } else {
            System.out.println("Students in the lesson:");
            printList(students);
        }
    }

    private void putMark() throws IOException {
        System.out.println("Choose a lesson: ");
        printList(professor.getLessons());
        int lessonChoice = Integer.parseInt(bf.readLine());

        System.out.println("Choose a student: ");
        List<Student> students = professor.viewStudentInfo(professor.getLessons().get(lessonChoice - 1));
        printList(students);
        int studentChoice = Integer.parseInt(bf.readLine());

        System.out.println("Enter mark: ");
        double mark = Double.parseDouble(bf.readLine());

        professor.putMark(professor.getLessons().get(lessonChoice - 1), students.get(studentChoice - 1), mark);
        System.out.println("Mark is putted");
    }

    private void sendRequest() throws IOException {
        System.out.println("Enter request content: ");
        String requestContent = bf.readLine();
        Request request = new Request();

        DataSingleton.INSTANCE.addRequests(request);

        System.out.println("Request sent successfully!");
    }

    private void sendMessage() throws IOException {
//        System.out.println("Enter recipient's name: ");
//        String recipientName = bf.readLine();
//
//        Employee recipient = ;
//
//        if (recipient != null) {
//            System.out.println("Enter message content: ");
//            String messageContent = bf.readLine();
//
//            Message message = new Message(professor, recipient, messageContent);
//            db.addMessage(message);
//
//            System.out.println("Message sent successfully!");
//        } else {
//            System.out.println("Recipient not found. Please check the name and try again.");
//        }  
    }

    private void getMessage() throws IOException {
        // Implement getMessage logic here
    }

    private void sendComplaint() throws IOException {
        // Implement sendComplaint logic here
    }
    
    private void viewUniversityJournal() {
//        UniversityJournal universityJournal = DataSingleton.INSTANCE.getUniversityJournal();
//        System.out.println("University Journal:");
//        System.out.println(universityJournal);
//
//        try {
//            System.out.println("\n 1) Return back \n 2) Exit");
//            int choice = Integer.parseInt(bf.readLine());
//
//            if (choice == 1) {
//                return;
//            } else if (choice == 2) {
//                exit();
////                break menu;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    
    private void addResearchPaper() throws IOException {
        System.out.println("Enter the title of the research paper: ");
        String title = bf.readLine();

        System.out.println("Enter the pages of the research paper: ");
        int pages = Integer.parseInt(bf.readLine());

        System.out.println("Enter the publication citations of the research paper: ");
        int citations = Integer.parseInt(bf.readLine());
        
        System.out.println("Enter the publication doi of the research paper: ");
        String doi = bf.readLine();

        ResearchPaper researchPaper = new ResearchPaper(title, pages, citations , doi);
        
        DataSingleton.INSTANCE.addResearchPapers(researchPaper);

        System.out.println("Research paper added successfully!");
    }

}
