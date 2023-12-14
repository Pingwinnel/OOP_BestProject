package course;


public class Lesson {
	String name;
	Days day;
	private Time time;
	Format format;
	LessonType type;
	private Room room;
	
	public Lesson() {
		
	}
	public Lesson(String name, Days day, Time time,LessonType type,Room room) {
		this.name = name;
		this.day = day;
		this.time = time;
		this.type=type;
		this.room=room;
	}
	
	public String toString() {
		if(format == Format.ONLINE) return "Lesson "+ name+ ", "+day + ", "+format + ", "+time + ", " + room + ".";
		return "Lesson "+ name+ ", "+day + ", "+format + ", "+time + ", " + room + ".";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Days getDay() {
		return day;
	}
	public void setDay(Days day) {
		this.day = day;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Format getFormat() {
		return format;
	}
	public void setFormat(Format format) {
		this.format = format;
	}
	public LessonType getType() {
		return type;
	}
	public void setType(LessonType type) {
		this.type = type;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}


}
