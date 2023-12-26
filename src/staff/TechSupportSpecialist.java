package staff;

import java.io.IOException;
import java.util.Objects;

import utilities.DataSingleton;
import utilities.Orders;
import utilities.Utils;
import utilities.acceptType;

/**
 * The TechSupportSpecialist class represents a technical support specialist who handles orders, their acceptance and progress tracking
 * @author Code Symphony
 */
public class TechSupportSpecialist extends Employee {

	private static final long serialVersionUID = -5085163744100008225L;

	/**
	 * Default empty constructor for the TechSupportSpecialist class
	 */
	public TechSupportSpecialist() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Parameterized constructor for the TechSupportSpecialist class
	 * @param surname
	 * @param name
	 * @param salary
	 */
	public TechSupportSpecialist(String surname, String name, double salary) {
		super(surname, name, salary);
	}
	
	/**
     * Accepts an order based on the provided order ID
     * @param id The ID of the order to be accepted
     * @throws IOException If an error occurs during order acceptance
     */
	public void  acceptOrders(Integer id) throws IOException {
		for (Orders order : DataSingleton.INSTANCE.getOrders()) {
			if(order.getId().intValue()==id.intValue()) {
				order.setIsAccepted(acceptType.True);
				DataSingleton.write();
				System.out.println("Order "+order.getId()+" has been completed");
				break;
			}
		}
	}
	
	 /**
     * Marks an order as in progress based on the provided order ID
     * @param id The ID of the order to be marked as in progress
     * @throws IOException If an error occurs during updating the order status
     */
	public void inProgressOrder(Integer id) throws IOException {
		for (Orders order : DataSingleton.INSTANCE.getOrders()) {
			if(order.getId().intValue()==id.intValue()) {
				order.setIsAccepted(acceptType.InProcess);
				DataSingleton.write();
				System.out.println("Order "+order.getId()+" has been taken");
				break;
			}
		}
	}

	/**
     * Displays a list of orders
     */
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