package MenuPages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import teacher.Professor;
import utilities.DataSingleton;
import researcher.ResearchPaper;
import student.Student;

public class ProfessorMenu {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    Professor professor;
    DataSingleton dataSingleton;

    public ProfessorMenu(Professor professor, DataSingleton dataSingleton) {
        this.professor = professor;
        this.dataSingleton = dataSingleton;
    }

    private void write() throws IOException {
        dataSingleton.write();
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
                System.out.println("What do you wanna do?\n 1) Change Password \n 2) View News \n 3) View Lessons \n 4) View Students' Info \n 5) Put Mark \n 6) Send Request \n 7) Send Message \n 8) Get Message \n 9) Send Complaint\n 10) Discover Hidden Talent of Researching \n 11) University journal \n 12) Exit");
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
                        // Discover Hidden Talent of Researching
                        discoverHiddenTalent();
                        break;

                    case 11:
                        // University journal
//                        System.out.println(professor.getUniversityJournal());
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
        // Implement sendRequest logic here
    }

    private void sendMessage() throws IOException {
        // Implement sendMessage logic here
    }

    private void getMessage() throws IOException {
        // Implement getMessage logic here
    }

    private void sendComplaint() throws IOException {
        // Implement sendComplaint logic here
    }

    private void discoverHiddenTalent() throws IOException {
        // Implement discoverHiddenTalent logic here
    
    }
}
