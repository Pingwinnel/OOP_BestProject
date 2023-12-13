package staff;

import java.util.Objects;

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
	
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TechSupportSpecialist that = (TechSupportSpecialist) o;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
    
    public String toString() {
        return "TechSupportSpecialist{" + super.toString() + "}";
    }
}