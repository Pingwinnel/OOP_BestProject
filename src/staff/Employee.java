package staff;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

import utilities.DataSingleton;
import utilities.Message;
import utilities.Orders;
import utilities.Request;

/**
 * The Employee class is an abstract class that represents an employee and provides common functionality for all employees, such as salary management, messaging and request handling
 * @author Code Symphony
 */
public abstract class Employee extends User{
	private static final long serialVersionUID = -4147612431222113640L;
	private double salary;
	private Date hireDate;
	
	/**
	 * Default empty constructor for the Employee class
	 */
	public Employee() {}
	
	/**
	 * Parameterized constructor for the Employee class
	 * @param surname
	 * @param name
	 * @param salary
	 */
	public Employee(String surname, String name, double salary) {
		super(surname, name);
		this.salary = salary;
		this.hireDate = new Date();
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(salary);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) return false;
		Employee other = (Employee) obj;
		return Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}
	
	/**
     * Sends a message to another employee
     * @param m The message to be sent
     * @throws Exception If an error occurs during message sending
     */
	public void sendMessage(String text, Employee e) throws Exception {
		Message m = new Message(e, text);
		m.setSender(this);
		DataSingleton.INSTANCE.addMessages(m);
		
	}

	/**
     * Retrieves the latest message received by the employee
     * @return The latest message received or null if no message is available
     */
	public Message getMessage() {
		for(Message m: DataSingleton.INSTANCE.getMessages()) {
			if(m.getReceiver().equals(this)) {
				return m;
			} 
		}
		return null;
	}

	public void setHireDate(Date date) {
		this.hireDate=date;
		
	}
	
	/**
     * Sends a request on behalf of the employee
     * @param r The request to be sent
     * @throws IOException If an error occurs during request sending
     */
	public void sendRequest(Request r) throws IOException {
		r.setSender(this);
		DataSingleton.INSTANCE.addRequests(r);
	}
	
	/**
     * Sends an order on behalf of the employee
     * @param description The description of the order
     * @throws IOException If an error occurs during order sending
     */
	public void senbOrder(String description) throws IOException {
		Orders o=new Orders(this,description);
		DataSingleton.INSTANCE.addOrders(o);
		DataSingleton.write();
	}

}
