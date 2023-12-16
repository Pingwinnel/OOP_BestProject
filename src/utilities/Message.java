package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Date;

import staff.Employee;

public class Message implements Serializable{
	private Employee sender;
	private Employee receiver;
	private String message;
	private Date date;
	
	public Message() {}
	
	public Message(Employee sender, Employee receiver, String message) {
		this.sender = sender;
		this.setReceiver(receiver);
		this.date = new Date();
		this.message = message;
	}
	@Override
	public String toString() {
		return sender.getName() + " " + sender.getSurname()+ ": "  + message + "\n"+ date;
		
	}
	public Employee getSender() {
		return sender;
	}
	public void setSender(Employee sender) {
		this.sender = sender;
	}
	public Employee getReceiver() {
		return receiver;
	}
	public void setReceiver(Employee receiver) {
		this.receiver = receiver;
	}
	
	public static String writeMessage() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String object = bf.readLine();
		return object;
	}
	
	
	
}
