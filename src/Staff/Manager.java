package Staff;

public class Manager extends Employee {
	private managerType type;
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(int id, String surname, String name, String corparateEmail, String password, double salary) {
		super(id, surname, name, corparateEmail, password, salary);
		this.type = type;
	}
	public void setType(managerType type1) {
		this.type=type1;
	}
}
