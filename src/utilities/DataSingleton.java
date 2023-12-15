package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Vector;

import course.Course;
import researcher.ResearchPaper;
import researcher.ResearchProject;
import staff.User;


public final class DataSingleton{
	private static final DataSingleton DB = new DataSingleton();
	private static Vector<User> users;
	private static Vector<Message> messages = new Vector<Message>();
	private static Vector<Course> courses = new Vector<Course>();
	private static Vector<ResearchPaper> researchPapers = new Vector<ResearchPaper>();
	private static Vector<ResearchProject> researchProjects = new Vector<ResearchProject>();
	private static HashMap<String, Vector<String>> facultyComplaints = new HashMap<>();
	// private static Vector<Student> students;
	static File dataFile = new File("data.ser");
	private DataSingleton() {
		
	}
	
	public static DataSingleton getInstance() {
		return DB;
	}
	
	static {
		if(dataFile.exists()) {
			try {
				users = readUsers();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else users = new Vector<User>();
	}

	public static Vector<User> readUsers() throws Exception {
		FileInputStream fis = new FileInputStream("data.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Vector<User> users = (Vector<User>)ois.readObject();
		fis.close(); ois.close();
		return users;
	}
	
	public void saveUsers() throws Exception {
		FileOutputStream fos = new FileOutputStream("data.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(users);
		oos.close(); fos.close();
	}
	
	public void addUser(User u) throws Exception {
		users.add(u);
		saveUsers();
		
	}
	public Vector<User> getUsers() throws Exception {
		return readUsers();
	}
	
	public void removeUser(User u) throws Exception {
		dataFile.delete();
		users.remove(u);
		saveUsers();
	}

	public Vector<Message> getMessages() {
		return messages;
	}

	public void addMessages(Message m) {
		messages.add(m);
	}

	public Vector<ResearchPaper> getResearchPapers() {
		return researchPapers;
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
