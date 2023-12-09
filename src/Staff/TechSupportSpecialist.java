package Staff;

public class TechSupportSpecialist extends Employee {

	public TechSupportSpecialist() {
		// TODO Auto-generated constructor stub
	}

	public TechSupportSpecialist(int id, String surname, String name, String corparateEmail, String password,
			double salary) {
		super(id, surname, name, corparateEmail, password, salary);
		// TODO Auto-generated constructor stub
	}

	public boolean acceptOrders() {
		return false;
	}
	
	void viewOrders() {
		
	}
}