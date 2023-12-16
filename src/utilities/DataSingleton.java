package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Vector;

import course.Course;
import researcher.ResearchPaper;
import researcher.ResearchProject;
import researcher.Researcher;
import staff.Manager;
import staff.TechSupportSpecialist;
import staff.User;
import student.DiplomaProject;
import student.Student;
import student.StudentOrganization;
import teacher.Teacher;


public final class DataSingleton{
	private static final DataSingleton DB = new DataSingleton();
	private static Vector<User> users;
	private static Vector<Message> messages = new Vector<Message>();
	private static Vector<Request> requests = new Vector<Request>();
	private static Vector<Course> courses = new Vector<Course>();
	private static Vector<ResearchPaper> researchPapers = new Vector<ResearchPaper>();
	private static Vector<ResearchProject> researchProjects = new Vector<ResearchProject>();
	private static HashMap<String, Vector<String>> facultyComplaints = new HashMap<>();
	private static Vector<Student> students = new Vector<Student>();
	private static Vector<Manager> managers=new Vector<Manager>();
	private static Vector<Researcher> researchers=new Vector<Researcher>();
	private static Vector<Teacher> teachers=new Vector<Teacher>();
	private static Vector<TechSupportSpecialist> techSupportSpecialists=new Vector<TechSupportSpecialist>();
    	private static Vector<News> news = new Vector<News>();
    	private static Vector<StudentOrganization> studOrg = new Vector<StudentOrganization>();
    	private static Vector<DiplomaProject> dipProj = new Vector<DiplomaProject>();
	static File dataFile = new File("data.ser");
	private DataSingleton() {
		
	}

	public static DataSingleton INSTANCE;

//	public static DataSingleton getInstance() {
//		return DB;
//	}
//	
	
	static {
		if(new File("data").exists()) {
			try {
				INSTANCE = read();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else INSTANCE = new DataSingleton();
	}

//	public static Vector<User> readUsers() throws Exception {
//		FileInputStream fis = new FileInputStream("data.ser");
//		ObjectInputStream ois = new ObjectInputStream(fis);
//		Vector<User> users = (Vector<User>)ois.readObject();
//		fis.close(); ois.close();
//		return users;
//	}
//	
//	public void saveUsers() throws Exception {
//		FileOutputStream fos = new FileOutputStream("data.ser");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(users);
//		oos.close(); fos.close();
//	}
	
	public static DataSingleton read() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("data");
		ObjectInputStream oin = new ObjectInputStream(fis);
		return (DataSingleton) oin.readObject();
	}
	
	public static void write() throws IOException{
		FileOutputStream fos = new FileOutputStream("data");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(INSTANCE);
		oos.close();
	}
	
	public void addUser(User u) throws Exception {
		users.add(u);
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

    //news
	public void addNews(News n) {
		news.add(n);
	}
	
	public static Vector<News> getNews(){
		return news;
	}
	
    //Student Organization
	public void addSudentOrganization(StudentOrganization so) {
		studOrg.add(so);
	}
	
	public Vector<StudentOrganization> getStudentOrganization(){
		return studOrg;
	}
	
    //Diploma Project
	public void addDiplomaProject(DiplomaProject dp) {
		dipProj.add(dp);
	}
	
	public Vector<DiplomaProject> getDiplomaProject(){
		return dipProj;
	}
    
	
	public static Vector<Student> getStudents() {
		return students;
	}

	public static void addStudents(Student s) {
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

	//Request
	public static Vector<Request> getRequests() {
		return requests;
	}

	public void addRequests(Request req) {
		requests.add(req);
	}
	
}
