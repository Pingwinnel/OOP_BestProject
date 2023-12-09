package Staff;

import java.util.Date;
import Main.User;


public class Employee extends User{
	

	private double salary;
	private Date hireDate;
	
	public Employee() {}
	
	public Employee(int id, String surname, String name, String corparateEmail, String password, double salary) {
		super(id, surname, name, corparateEmail, password);
		this.salary = salary;
		this.hireDate = new Date();
	}
	
	@Override
	public String toString() {
		return super.toString()+", salary: " + salary + ", hire date: " + hireDate;
	}

	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	
	}
	public void setHireDate(Date hireDate) {
		this.hireDate=hireDate;
	}
}
