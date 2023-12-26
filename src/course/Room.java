/**
 * @author Yerasyil
 * @version 25.12.2023
 */
package course;

import java.io.Serializable;

//Class that represents room characteristic  
public class Room implements Serializable{
	String name;
	//capacity of room (like 50 people)
	int capacity;
	//floor here room located
	int floor;

	public Room(){
		
	}
	
	public Room(String name){
		this.name = name;
	}
	
	public Room(String name, int floor, int capacity){
		this.name = name;
		this.capacity = capacity;
		this.floor = floor;
	}
	public String toString() {
		return this.name+ " classroom, "+ this.floor + "th floor, " + "capacity: " + this.capacity;
	}
	
}
