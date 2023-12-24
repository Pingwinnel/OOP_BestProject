package staff;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

import utilities.DataSingleton;
import utilities.Message;
import utilities.Orders;
import utilities.Request;

public abstract class Employee extends User{
	private static final long serialVersionUID = -4147612431222113640L;
	private double salary;
	private Date hireDate;
	
	public Employee() {}
	
	public Employee(String surname, String name, double salary) {
		super(surname, name);
		this.salary = salary;
		this.hireDate = new Date();
	}
	
	@Override
	public String toString() {
		return super.toString()+", salary: " + salary + ", hireDate: " + hireDate;
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
	
	public void sendMessage(Message m) throws Exception {
		DataSingleton.INSTANCE.addMessages(m);
	}

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
	
	public void sendRequest(Request r) throws IOException {
		r.setSender(this);
		DataSingleton.INSTANCE.addRequests(r);
	}
	
	public void senbOrder(String description) throws IOException {
		Orders o=new Orders(this,description);
		DataSingleton.INSTANCE.addOrders(o);
		DataSingleton.write();
	}

}
