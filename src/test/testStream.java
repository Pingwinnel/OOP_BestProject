package test;



import student.Student;
import utilities.DataSingleton;
import staff.Manager;

public class testStream {
	public static void main(String[] args) throws Exception {

        
        DataSingleton db = DataSingleton.INSTANCE;
        db.addUser(new Student("WW","aa", 3.8));
        db.addUser(new Student("Alice","aa", 3.5));
        db.addUser(new Student("Charlie","bb", 4.0));
        
        Manager m1 = new Manager();
        System.out.println(m1.viewStudentsSortedByGpa());
        System.out.println(m1.viewStudentsSortedAlphabetically());

        
	}
}