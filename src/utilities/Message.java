package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Date;

import staff.Employee;

/**
 * The Message class represents a communication message between employees and includes information about the sender, receiver, message content, and the date of the message
 * @author Code Symphony
 * */
public class Message implements Serializable{
	private Employee sender;
	private Employee receiver;
	private String message;
	private Date date;
	
	/**
	 * Default empty constructor for the Message class
	 */
	public Message() {}
	
	/**
	 * Parameterized constructor for the Message class
	 * @param receiver
	 * @param message
	 */
	public Message(Employee receiver, String message) {
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
	
//	public static String writeMessage() throws IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		String object = bf.readLine();
//		return object;
//	}
	
	
	
}
