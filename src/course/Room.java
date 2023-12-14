package course;

public class Room {
	String name;
	int capacity;
	int floor;
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
