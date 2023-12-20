package utilities;

import java.io.Serializable;
import java.util.Date;

import staff.Employee;

public class Orders implements Serializable {
	private Integer id;
	private Date date;
	private String description;
	private Employee from;
	private acceptType isAccepted;


	public Orders() {
		this.setId(DataSingleton.nextIdOrder());
		this.isAccepted=acceptType.False;
		this.date=new Date();
	}
	public Orders(Employee from,String description) {
		this.setId(DataSingleton.nextIdOrder());
		this.description=description;
		this.date=new Date();
		this.from=from;
		this.isAccepted=acceptType.False;
	}
	private void setId(int nextIdOrder) {
		this.id=nextIdOrder;
		
	}
	public String toString() {
		return "id: "+this.id +", sender: "+from.getName()+", date: "+date+", description: "+description+", Acctive: "+isAccepted;

	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Employee getFrom() {
		return from;
	}
	public void setFrom(Employee from) {
		this.from = from;
	}
	public acceptType getIsAccepted() {
		return isAccepted;
	}
	public void setIsAccepted(acceptType isAccepted) {
		this.isAccepted = isAccepted;
	}
	public void setAccept() {
		this.isAccepted=acceptType.True;
	}
	public Integer getId() {
		return id;
	}
}
