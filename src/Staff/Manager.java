package Staff;

public class Manager extends Employee {
	managerType type;
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(int id, String surname, String name, String corparateEmail, String password, double salary) {
		super(id, surname, name, corparateEmail, password, salary);
		this.type = type;
	}
}