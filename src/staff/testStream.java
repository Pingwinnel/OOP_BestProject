package staff;

import java.util.Vector;

import student.Student;
import utilities.DataSingleton;
import staff.Manager;

public class testStream {
	public static void main(String[] args) {

        
        DataSingleton db = DataSingleton.INSTANCE;
        db.addUser(new Student("WW", 3.8));
        db.addUser(new Student("Alice", 3.5));
        db.addUser(new Student("Charlie", 4.0));
        
        Manager m1 = new Manager();
        System.out.println(m1.viewStudentsSortedByGpa());
        System.out.println(m1.viewStudentsSortedAlphabetically());

        
//        Vector<Student> studentsByGpa = students.viewStudentsSortedByGpa();
//        Vector<Student> studentsAlphabetically = students.viewStudentsSortedAlphabetically();
	}
}