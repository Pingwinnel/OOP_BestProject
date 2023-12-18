package utilities;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Vector;
import course.Course;
import researcher.ResearchPaper;
import researcher.ResearchProject;


import staff.User;
import student.DiplomaProject;
import student.Student;
import student.StudentOrganization;
import teacher.Teacher;


public class DataSingleton implements Serializable{
	public static DataSingleton INSTANCE;
	
	private Vector<User> users = new Vector<User>();
	private Vector<Student> students = new Vector<Student>();
	private Vector<Teacher> teachers = new Vector<Teacher>();
	private Vector<Message> messages = new Vector<Message>();
	private Vector<Request> requests = new Vector<Request>();
	private Vector<Course> courses = new Vector<Course>();
	private Vector<ResearchPaper> researchPapers = new Vector<ResearchPaper>();
	private HashMap<String, Vector<String>> facultyComplaints = new HashMap<>();
	private Vector<ResearchProject> researchProjects = new Vector<ResearchProject>();
    private Vector<News> news = new Vector<News>();
    private Vector<StudentOrganization> studOrg = new Vector<StudentOrganization>();
    private Vector<DiplomaProject> diplomaProjescts = new Vector<DiplomaProject>();
	
    static File dataFile = new File("data.ser");
	
	
	private DataSingleton() {
		
	}
	
	static {
		if(dataFile.exists()) {
			try {
				INSTANCE = read();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else INSTANCE = new DataSingleton();
	}
	
	public static DataSingleton read() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("data.ser");
		ObjectInputStream oin = new ObjectInputStream(fis);
		return (DataSingleton) oin.readObject();
	}
	
	public static void write() throws IOException{
		FileOutputStream fos = new FileOutputStream("data.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(INSTANCE);
		oos.close();
	}
	
	public void addUser(User u) throws Exception {
		users.add(u);
		if(u instanceof Student) students.add((Student) u);
		if(u instanceof Teacher) teachers.add((Teacher) u);
		write();
		
	}
	
	public Vector<User> getUsers() throws Exception {
		return users;
	}
	
	public void removeUser(int id) throws Exception {
		users.removeIf(n->n.getId()==id);
		students.removeIf(n->n.getId()==id);
		teachers.removeIf(n->n.getId()==id);
		write();
	}
	
	public Vector<Student> getStudents(){
		return students;
	}
	
	public Vector<Teacher> getTeachers(){
		return teachers;
	}
	
	public static int nextId() {
		return INSTANCE.users.size()+1;
	}

	public Vector<Message> getMessages() {
		return messages;
	}

	public void addMessages(Message m) throws Exception {
		messages.add(m);
		write();
	}

	public Vector<ResearchPaper> getResearchPapers() {
		return researchPapers;
	}

	public void addResearchPapers(ResearchPaper researchPaper) throws IOException {
		researchPapers.add(researchPaper);
//		write();
	}
	
	public Vector<ResearchProject> getResearchProject() {
		return researchProjects;
	}
	
	public void addResearchProjects(ResearchProject researchProject) throws IOException {
		researchProjects.add(researchProject);
		write();
	}
	
	//course
	public void addCourse(Course c) throws IOException {
		courses.add(c);
		write();
	}
	
	public Vector<Course> getCourse(){
		return courses;
	}
	
	public void addComplaint(String faculty, String complaint) throws IOException {
        if (!facultyComplaints.containsKey(faculty)) {
            facultyComplaints.put(faculty, new Vector<>());
        }
        facultyComplaints.get(faculty).add(complaint);
        write();
    }

    public Vector<String> getComplaintsByFaculty(String faculty) {
        return facultyComplaints.getOrDefault(faculty, new Vector<>());
    }

    //news
	public void addNews(News n) throws IOException {
		news.add(n);
		write();
	}
	
	public Vector<News> getNews(){
		return news;
	}
	
    //Student Organization
	public void addSudentOrganization(StudentOrganization so) throws IOException {
		studOrg.add(so);
		write();
	}
	
	public Vector<StudentOrganization> getStudentOrganization(){
		return studOrg;
	}
	
    //Diploma Project
	public void addDiplomaProject(DiplomaProject dp) throws IOException {
		diplomaProjescts.add(dp);
		write();
	}
	
	public Vector<DiplomaProject> getDiplomaProject(){
		return diplomaProjescts;
	}
    
	//we will add students, teachers in addUser srazu
	//the rest of employees we can get by using stream()
//	public static Vector<Student> getStudents() {
//		return students;
//	}
//
//	public static void addStudents(Student s) {
//		students.add(s);
//	}
//	
//	public static Vector<Manager> getManagers() {
//		return managers;
//	}
//	public void addManager(Manager m) {
//		managers.add(m);
//	}
//
//	public static Vector<Researcher> getResearchers() {
//		return researchers;
//	}
//	public void addResearcher(Researcher r) {
//		researchers.add(r);
//	}
//
//	public static Vector<Teacher> getTeachers() {
//		return teachers;
//	}
//	public void addTeacher(Teacher t) {
//		teachers.add(t);
//	}
//
//	public static Vector<TechSupportSpecialist> getTechSupportSpecialists() {
//		return techSupportSpecialists;
//	}
//	public void addTechSupportSpecialist(TechSupportSpecialist t) {
//		techSupportSpecialists.add(t);
//	}

	//Request
	public Vector<Request> getRequests() {
		return requests;
	}

	public void addRequests(Request req) throws IOException {
		requests.add(req);
		write();
	}
	
}
