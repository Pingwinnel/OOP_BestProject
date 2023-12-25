package course;

import java.util.Objects;

public class Lesson {
	private Course course;
	private Days day;
	private Time time;
	private Format format;
	private LessonType type;
	private Room room;
	
	public Lesson() {
		
	}
	//for test
	public Lesson(Course course, Days day, Time time, LessonType type) {
		this.course = course;
		this.day = day;
		this.time = time;
		this.type=type;
	}
	public Lesson(Course course, String name, Days day, Time time, LessonType type,Room room) {
		this.course = course;
		this.day = day;
		this.time = time;
		this.type=type;
		this.room=room;
	}
	
	public String toString() {
		if(format == Format.ONLINE) return "Lesson "+ course.getName()+ ", "+day + ", "+format + ", "+time;
		return "Lesson "+ course.getName()+ ", "+day + ", "+format + ", "+time + ", " + room + ".";
	}
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
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
	@Override
	public int hashCode() {
		return Objects.hash(course, day, format, room, time, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lesson other = (Lesson) obj;
		return Objects.equals(course, other.course) && day == other.day && format == other.format
				&& Objects.equals(room, other.room) && Objects.equals(time, other.time) && type == other.type;
	}
	
	


}
