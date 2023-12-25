/**
 * @author Yerasyil
 * @version 25.12.2023
 */
package course;
//Class that represents room characteristic  
public class Room {
	String name;
	//capacity of room (like 50 people)
	int capacity;
	//floor here room located
	int floor;
	// The line `String address;` is declaring a variable named `address` of type `String` in the `Room`
	// class. This variable is used to store the address of the room.
	String address;

	public Room(){
		
	}
	public Room(String name, String address, int floor, int capacity){
		this.name = name;
		this.address = address;
		this.capacity = capacity;
		this.floor = floor;
	}
	public String toString() {
		return this.name+ " classroom, "+this.address + " " + this.floor + "th floor, " + "capacity: " + this.capacity;
	}
}
