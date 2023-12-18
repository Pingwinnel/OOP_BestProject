package utilities;

import staff.Dean;

public class Request {
	private String order;
	private Dean receiverDean;
	
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public Dean getReceiverDean() {
		return receiverDean;
	}
	public void setReceiverDean(Dean receiverDean) {
		this.receiverDean = receiverDean;
	}
}
