package wproject;

import java.util.Date;

public class Employee extends User{
	

	private double salary;
	private Date hireDate;
	
	public Employee() {}
	
	public Employee(int id, String surname, String name, String corparateEmail, String password, double salary) {
		super(id, surname, name, corparateEmail, password);
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return super.toString()+" Employee [salary=" + salary + ", hireDate=" + hireDate + "]";
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}	
}
