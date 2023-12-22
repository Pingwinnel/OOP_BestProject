package staff;

import java.io.IOException;
import java.util.Objects;

import utilities.DataSingleton;
import utilities.Orders;
import utilities.Utils;
import utilities.acceptType;

public class TechSupportSpecialist extends Employee {

	private static final long serialVersionUID = -5085163744100008225L;

	public TechSupportSpecialist() {
		// TODO Auto-generated constructor stub
	}

	public TechSupportSpecialist(String surname, String name, double salary) {
		super(surname, name, salary);

	}

	@SuppressWarnings("static-access")
	public void  acceptOrders(Integer id) throws IOException {
		for (Orders order : DataSingleton.INSTANCE.getOrders()) {
			if(order.getId().intValue()==id.intValue()) {
				order.setIsAccepted(acceptType.True);
				DataSingleton.INSTANCE.write();
				break;
			}
		}
	}

	public	void viewOrders() {
		Utils.printList( DataSingleton.INSTANCE.getOrders());
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
		return "TechSupportSpecialist {" + super.toString() + "}";
	}
}