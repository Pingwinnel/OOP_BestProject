package course;

import java.io.Serializable;

/**
 * The Room class represents a room in a building, such as a classroom
 * @author Code Symphony
 */
public class Room implements Serializable{
	String name;
	//capacity of room (like 50 people)
	int capacity;
	//floor here room located
	int floor;

	/**
	 * Default empty constructor for the Room class
	 */
	public Room(){
		
	}
	
	/**
	 * Parameterized constructor for the Room class that initializes given name
	 * @param name
	 */
	public Room(String name){
		this.name = name;
	}
	
	/**
	 * More detailed parameterized constructor for the Room clas
	 * @param name
	 * @param floor
	 * @param capacity
	 */
	public Room(String name, int floor, int capacity){
		this.name = name;
		this.capacity = capacity;
		this.floor = floor;
	}
	public String toString() {
		return this.name+ " classroom, "+ this.floor + "th floor, " + "capacity: " + this.capacity;
	}
	
}
