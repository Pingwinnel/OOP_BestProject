package utilities;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;


import course.Course;
import course.Lesson;
import researcher.EmployeeResearcher;
import researcher.ResearchPaper;
import researcher.ResearchProject;
import staff.Dean;
import staff.Employee;
import staff.Manager;
import staff.TechSupportSpecialist;
import staff.User;
import student.DiplomaProject;
import student.Schools;
import student.Student;
import student.StudentOrganization;
import teacher.Teacher;

/**
 * The DataSingleton class represents a singleton instance that manages the data of the university system
 * @author Code Symphony
 */
public class DataSingleton implements Serializable{
	/**
	 * The singleton instance of DataSingleton
	 */
	public static DataSingleton INSTANCE;
	
	private Vector<User> users = new Vector<User>();
	private Vector<Student> students = new Vector<Student>();
	private Vector<Teacher> teachers = new Vector<Teacher>();
	private Vector<TechSupportSpecialist> techSupportSpecialists = new Vector<TechSupportSpecialist>();
	private Vector<Manager> managers = new Vector<Manager>();
	private Vector<EmployeeResearcher> employeeResearchers = new Vector<EmployeeResearcher>();
	private Vector<Message> messages = new Vector<Message>();
	private Vector<Request> requests = new Vector<Request>();
	private Vector<Course> courses = new Vector<Course>();
	private Vector<ResearchPaper> researchPapers = new Vector<ResearchPaper>();
	private HashMap<Schools, Vector<String>> facultyComplaints = new HashMap<Schools, Vector<String>>();
	private Vector<ResearchProject> researchProjects = new Vector<ResearchProject>();
    private Vector<News> news = new Vector<News>();
    private Vector<StudentOrganization> studOrg = new Vector<StudentOrganization>();
    private Vector<DiplomaProject> diplomaProjescts = new Vector<DiplomaProject>();
    private Vector<Orders> orders=new Vector<Orders>();
    private HashMap<String,String> loginInfo = new HashMap<String, String>();
    private Vector<String> logs=new Vector<String>();
    private HashMap<Teacher, List<Lesson>> lessonsOfTeachers = new HashMap<Teacher, List<Lesson>>();
    private HashMap<Student, List<Lesson>> lessonsOfStudents = new HashMap<Student, List<Lesson>>();
    private List<Lesson> lessons = new ArrayList<Lesson>();
    private Vector<Employee> employees = new Vector<Employee>();
    private Vector<Dean> deans = new Vector<Dean>();
	
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
	
	 /**
     * Reads the serialized data from the "data.ser" file 
     * @return The deserialized DataSingleton instance
     * @throws IOException If an I/O error occurs while reading the file
     * @throws ClassNotFoundException If the class of the serialized object cannot be found
     */
	public static DataSingleton read() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("data.ser");
		ObjectInputStream oin = new ObjectInputStream(fis);
		return (DataSingleton) oin.readObject();
	}
	
	/**
     * Writes the current state of the DataSingleton instance to the "data.ser" file
     * @throws IOException If an I/O error occurs while writing the file
     */
	public static void write() throws IOException{
		FileOutputStream fos = new FileOutputStream("data.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(INSTANCE);
		oos.close();
	}
	
	/**
     * Adds a user to the system, updates login information and categorizes the user based on their role
     * @param u The user to be added
     * @throws Exception If an error occurs during user addition
     */
	public void addUser(User u) throws Exception {
		users.add(u);
		loginInfo.put(u.getCorparateEmail(), u.getPassword());
		if(u instanceof Student) students.add((Student) u);
		if(u instanceof Teacher) teachers.add((Teacher) u);
		if(u instanceof TechSupportSpecialist) techSupportSpecialists.add((TechSupportSpecialist)u);
		if(u instanceof Manager) managers.add((Manager)u);
		if(u instanceof EmployeeResearcher) employeeResearchers.add((EmployeeResearcher)u);
		write();
		
	}
	
	public Vector<User> getUsers() throws Exception {
		return users;
	}
	
	/**
     * Removes a user from the system based on the provided user ID
     * @param id The ID of the user to be removed
     * @throws Exception If an error occurs during user removal
     */
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
	
	/**
     * Retrieves the next available ID for user creation
     * @return The next available user ID
     */
	public static int nextId() {
		return INSTANCE.users.size()+1;
	}
	
	/**
     * Retrieves the next available ID for order creation
     * @return The next available order ID
     */
	public static int nextIdOrder() {
		return INSTANCE.orders.size()+1;
	}

	public Vector<Message> getMessages() {
		return messages;
	}

	/**
     * Adds a message to the system
     * @param m The message to be added
     * @throws Exception If an error occurs during message addition
     */
	public void addMessages(Message m) throws Exception {
		messages.add(m);
		write();
	}

	public Vector<ResearchPaper> getResearchPapers() {
		return researchPapers;
	}

	/**
     * Adds a research paper to the system
     * @param researchPaper The research paper to be added
     * @throws IOException If an I/O error occurs during research paper addition
     */
	public void addResearchPapers(ResearchPaper researchPaper) throws IOException {
		researchPapers.add(researchPaper);
		write();
	}
	
	public Vector<ResearchProject> getResearchProject() {
		return researchProjects;
	}
	
	/**
     * Adds a research project to the system
     * @param researchProject The research project to be added
     * @throws IOException If an I/O error occurs during research project addition
     */
	public void addResearchProjects(ResearchProject researchProject) throws IOException {
		researchProjects.add(researchProject);
		write();
	}
	
	/**
     * Adds a course to the system
     * @param c The course to be added
     * @throws IOException If an I/O error occurs during course addition
     */
	public void addCourse(Course c) throws IOException {
		courses.add(c);
		write();
	}
	
	public Vector<Course> getCourse(){
		return courses;
	}
	
	/**
     * Adds a complaint to the system for a specific school
     * @param school The school associated with the complaint
     * @param complaint The complaint to be added
     * @throws IOException If an I/O error occurs during complaint addition
     */
	public void addComplaint(Schools school, String complaint) throws IOException {
        if(!facultyComplaints.containsKey(school)) {
            facultyComplaints.put(school, new Vector<>());
        }
        	facultyComplaints.get(school).add(complaint);
        	write();
	}


	/**
     * Retrieves complaints for a specific school
     * @param school The school for which complaints are retrieved
     * @return A vector of complaints for the specified school
     */
    public Vector<String> getComplaintsByFaculty(Schools school) {
    	return facultyComplaints.get(school);
    }

    /**
     * Adds a news item to the system
     * @param n The news item to be added
     * @throws IOException If an I/O error occurs during news item addition
     */
	public void addNews(News n) throws IOException {
		news.add(n);
		write();
	}
	
	public Vector<News> getNews(){
		return news;
	}
	
	/**
     * Adds a student organization to the system
     * @param so The student organization to be added
     * @throws IOException If an I/O error occurs during student organization addition
     */
	public void addSudentOrganization(StudentOrganization so) throws IOException {
		studOrg.add(so);
		write();
	}
	
	public Vector<StudentOrganization> getStudentOrganization(){
		return studOrg;
	}
	
	/**
     * Adds a diploma project to the system
     * @param dp The diploma project to be added
     * @throws IOException If an I/O error occurs during diploma project addition
     */
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

	/**
	 * Adds a request to the system
	 * @param req The request to be added
	 * @throws IOException If an I/O error occurs during request addition
	 */
	public void addRequests(Request req) throws IOException {
		requests.add(req);
		write();
	}

	public Vector<Orders> getOrders() {
		return orders;
	}

	/**
     * Adds an order to the system
     * @param o The order to be added
     * @throws IOException If an I/O error occurs during order addition
     */
	public void addOrders(Orders o) throws IOException {
		orders.add(o);
		write();
	}

	public Vector<TechSupportSpecialist> getTechSupportSpecialists() {
		return techSupportSpecialists;
	}

	/**
	 * Adds a tech support specialist to the system
	 * @param techSupportSpecialist The tech support specialist to be added
	 * @throws IOException If an I/O error occurs during tech support specialist addition
	 */
	public void addTechSupportSpecialists(TechSupportSpecialist techSupportSpecialist) throws IOException {
		 techSupportSpecialists.add(techSupportSpecialist);
		 write();
	}

	public Vector<Manager> getManagers() {
		return managers;
	}

	/**
	 * Adds a manager to the system
	 * @param manager The manager to be added
	 * @throws IOException If an I/O error occurs during manager addition
	 */
	public void addManagers(Manager manager) throws IOException {
		managers.add(manager);
		write();
	}

	public Vector<EmployeeResearcher> getEmployeeResearchers() {
		return employeeResearchers;
	}

	/**
	 * Adds an employee researcher to the system
	 * @param employeeResearcher The employee researcher to be added
	 * @throws IOException If an I/O error occurs during employee researcher addition
	 */
	public void addEmployeeResearchers(EmployeeResearcher employeeResearcher) throws IOException {
		employeeResearchers.add(employeeResearcher);
		write();
	}

	public HashMap<String,String> getLoginInfo() {
		return loginInfo;
	}

	public Vector<String> getLogs() {
		return logs;
	}

	/**
	 * Adds a log entry to the system
	 * @param log The log entry to be added
	 * @throws IOException If an I/O error occurs during log entry addition
	 */
	public void addLogs(String log) throws IOException {
		logs.add(log);
		write();
	}
	
	public List<Lesson> getLessons() {
		return lessons;
	}

	public HashMap<Teacher, List<Lesson>> getLessonsOfTeachers() {
		return lessonsOfTeachers;
	}

	public HashMap<Student, List<Lesson>> getLessonsOfStudents() {
		return lessonsOfStudents;
	}
	
	public Vector<Employee> getEmployees(){
		
		for(User u : users) {
			if(u instanceof Employee) {
				employees.add((Employee)u);
			}
		}
		return employees;
	}
	
	public Vector<Dean> getDeans(){
		
		for(User u : users) {
			if(u instanceof Dean) {
				deans.add((Dean)u);
			}
		}
		return deans;
	}
}
