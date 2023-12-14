package course;

import java.util.Vector;

public class Lesson {
	String name;
	private int id; // read only
	Days day;
	private Time time;
	Time dur;
	Format format;
	static int cnt;
	static Vector<Lesson> lessons;
	LessonType type;
	private Room room;
	
	static{
		lessons = new Vector<Lesson>();
	}
	{
		id = cnt++;
		lessons.add(this);
	}
	public Lesson() {
		
	}
	public Lesson(String name, Days day, Time time) {
		this.name = name;
		this.day = day;
		this.time = time;
	}
	public Lesson(String name, Days day, Time time, Time dur)
	{
		this(name, day, time);
		this.dur = dur;
	}
	public Lesson(String name, Days day, Time time, Time dur, Format format)
	{
		this(name, day, time, dur);
		this.format = format;
	}
	public Lesson(String name, Days day, Time time, Time dur, Format format, LessonType type)
	{
		this(name, day, time, dur, format);
		this.type = type;
	}
	public Lesson(String name, Days day, Time time, Time dur, Format format, LessonType type, Room room)
	{
		this(name, day, time, dur, format, type);
		this.room = room;
	}
	public int getId() {
		return id;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time, Time dur) {
		this.time = time;
		this.dur = dur;
	}
	public String toString() {
		if(format == Format.ONLINE) return "Lesson "+ name+ ", "+ id + ", "+day + ", "+format + ", "+time + ", " + room + ".";
		return "Lesson "+ name+ ", "+ id + ", "+day + ", "+format + ", "+time + ", " + room + ".";
	}
	public boolean checkCollision(Lesson b) {
		return checkCollision(this,b);
	}
	static boolean checkCollision(Lesson a, Lesson b) {
		return a.day==b.day && a.time.equals(b.time) && (((a.time.hour+a.dur.hour)>b.time.hour) || ((b.time.hour+b.dur.hour)>a.time.hour));
	}

	public Room getRoom() {
		return room;
	}

}
