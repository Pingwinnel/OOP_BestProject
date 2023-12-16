package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
<<<<<<< HEAD
import java.io.Serializable;
=======
import java.util.HashMap;
>>>>>>> 679e6757646f56875dc48e8263c9b4466286d1a8
import java.util.Vector;

import course.Course;
import researcher.ResearchPaper;
<<<<<<< HEAD
import researcher.Researcher;
import staff.Manager;
import staff.TechSupportSpecialist;
=======
import researcher.ResearchProject;
>>>>>>> 679e6757646f56875dc48e8263c9b4466286d1a8
import staff.User;
import student.Student;
import teacher.Teacher;


public class DataSingleton implements Serializable{
	private static DataSingleton DB = new DataSingleton();
	private static Vector<User> users;
	private static Vector<Message> messages = new Vector<Message>();
	private static Vector<Course> courses = new Vector<Course>();
	private static Vector<ResearchPaper> researchPapers = new Vector<ResearchPaper>();
<<<<<<< HEAD
	private static Vector<Student> students=new Vector<Student>();
	private static Vector<Manager> managers=new Vector<Manager>();
	private static Vector<Researcher> researchers=new Vector<Researcher>();
	private static Vector<Teacher> teachers=new Vector<Teacher>();
	private static Vector<TechSupportSpecialist> techSupportSpecialists=new Vector<TechSupportSpecialist>();
	
	
	
=======
	private static Vector<ResearchProject> researchProjects = new Vector<ResearchProject>();
	private static HashMap<String, Vector<String>> facultyComplaints = new HashMap<>();
	// private static Vector<Student> students;
>>>>>>> 679e6757646f56875dc48e8263c9b4466286d1a8
	static File dataFile = new File("data.ser");
	private DataSingleton() {
		
	}
	
	public static DataSingleton getInstance() {
		return DB;
	}
	
	static {
		if(dataFile.exists()) {
			try {
				DB = read();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else users = new Vector<User>();
	}

	public static DataSingleton read() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("data");
		ObjectInputStream oin = new ObjectInputStream(fis);
		return (DataSingleton) oin.readObject();
	}
	public static void write()throws IOException{
		FileOutputStream fos = new FileOutputStream("data");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(DB);
		oos.close();
	}
	
	public void addUser(User u) throws Exception {
		Utils.sortUserData(u);
		write();
		
	}
	public DataSingleton getUsers() throws Exception {
		return read();
	}
	
	public void removeUser(User u) throws Exception {
		dataFile.delete();
		users.remove(u);
		write();
	}
	

	public Vector<Message> getMessages() {
		
		return messages;
	}

	public void addMessages(Message m) {
		messages.add(m);
	}

	public static Vector<Student> getStudents() {
		return students;
	}
	public void addStudent(Student s) {
		students.add(s);
	}

	public static Vector<Manager> getManagers() {
		return managers;
	}
	public void addManager(Manager m) {
		managers.add(m);
	}

	public static Vector<Researcher> getResearchers() {
		return researchers;
	}
	public void addResearcher(Researcher r) {
		researchers.add(r);
	}

	public static Vector<Teacher> getTeachers() {
		return teachers;
	}
	public void addTeacher(Teacher t) {
		teachers.add(t);
	}

	public static Vector<TechSupportSpecialist> getTechSupportSpecialists() {
		return techSupportSpecialists;
	}
	public void addTechSupportSpecialist(TechSupportSpecialist t) {
		techSupportSpecialists.add(t);
	}

	public Vector<ResearchPaper> getResearchPapers() {
		return researchPapers;
	}
	public void addResearchPaper(ResearchPaper rp) {
		researchPapers.add(rp);
	}
	
	public void addResearchPapers(ResearchPaper researchPaper) {
		researchPapers.add(researchPaper);
	}
	
	public Vector<ResearchProject> getResearchProject() {
		return researchProjects;
	}
	
	public void addResearchProjects(ResearchProject researchProject) {
		researchProjects.add(researchProject);
	}
	//course
	public void addCourse(Course c) {
		courses.add(c);
	}
	public Vector<Course> getCourse(){
		return courses;
	}
	
	public void addComplaint(String faculty, String complaint) {
        if (!facultyComplaints.containsKey(faculty)) {
            facultyComplaints.put(faculty, new Vector<>());
        }
        facultyComplaints.get(faculty).add(complaint);
    }

    public Vector<String> getComplaintsByFaculty(String faculty) {
        return facultyComplaints.getOrDefault(faculty, new Vector<>());
    }
	
}
