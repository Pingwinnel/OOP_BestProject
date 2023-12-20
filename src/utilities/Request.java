package utilities;

import java.io.Serializable;
import java.util.Objects;

import staff.Dean;
import staff.Employee;

public class Request implements Serializable{
<<<<<<< HEAD
=======
	private static final long serialVersionUID = 6590591269722086429L;
>>>>>>> 5a5af524f8e60aefd3369332c6c0a79b6f86052d
	private String order;
	private Dean receiverDean;
	private Employee sender;
	private boolean sign;
	
	public Request() {
		
	}

	public Request(Dean receiverDean, String order) {
		this.receiverDean = receiverDean;
		this.order = order;
	}
	
	public String getOrder() {
		return order;
	}
	
	public void setOrder(String order) {
		this.order = order;
	}
	
	public Dean getReceiverDean() {
		return receiverDean;
	}
	
	public Employee getSender() {
		return sender;
	}

	public void setSender(Employee sender) {
		this.sender = sender;
	}
	
	public void setReceiverDean(Dean receiverDean) {
		this.receiverDean = receiverDean;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Request otherRequest = (Request) obj;
	    return Objects.equals(order, otherRequest.order) &&
	           Objects.equals(receiverDean, otherRequest.receiverDean) &&
	           Objects.equals(sender, otherRequest.sender);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(order, receiverDean, sender);
	}
	
	@Override
	public String toString() {
		return "Request: " + order + "\n to " + receiverDean.getSurname() +" " + receiverDean.getName()  + "\n from " + sender.getSurname() + " " + sender.getName();
	}

	public boolean isSigned() {
		return sign;
	}

	public void setSigned(boolean sign) {
		this.sign = sign;
	}
}
