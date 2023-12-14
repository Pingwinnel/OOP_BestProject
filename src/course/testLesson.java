package course;

import java.util.Arrays;

public class testLesson {

	public static void main(String[] args) {
		// the code below is just intended to test Lesson functionality
		Lesson oop = new Lesson("OOP", Days.TUE, new Time(14,30), new Time(1, 0), Format.OFFLINE, LessonType.PRACTICE, new Room("444", "Abylai khan", 4, 100));
		Lesson algo = new Lesson("ADS", Days.WED, new Time(13,30), new Time(2,0), Format.ONLINE, LessonType.PRACTICE, new Room("446", "Abylai khan", 4, 90));
		Lesson db = new Lesson("DB", Days.TUE, new Time(14,00), new Time(1,0), Format.OFFLINE, LessonType.LECTURE, new Room("444", "Kazybek bi", 4, 80));
		Lesson math = new Lesson("MATH", Days.TUE, new Time(19,30)); //Format will be null
		math.format = Format.ONLINE;

		System.out.println(Lesson.checkCollision(oop,db));
		System.out.println(oop.checkCollision(algo)?"COLLISION":"NO COLLISION");
		
		
		for(Lesson cur: Lesson.lessons) 
			System.out.println(cur);
		
		for(int i=0; i<Lesson.lessons.size();i++)
			System.out.println(Lesson.lessons.get(i).name);
		
		math.setTime(new Time(db.getTime().hour+1, db.getTime().min), new Time(2, 0)); //schedule math 1 hour after db
		
		System.out.println(Lesson.lessons); // toString of a Vector returns toStrings of its objects
		
		//enums
		System.out.println(Arrays.toString(Days.values()));
		System.out.println("FIT Lessons on Tuesday:");
		for(Lesson cur: Lesson.lessons) 
			if(cur.day == Days.TUE) // you can check enums by ==
				System.out.println(cur.name);
		
		
		System.out.println(math.day.ordinal()); // a kind of index
		
/*		play with these classes. 
 *      For example:
 *       a. 1 point for this:
 		-you can add Lesson duration (also of type Time!), Lesson type (lecture, lab) fields, Lesson room.
 		-Room can be a class with fields number(or name), floor, capacity, etc.
		-You can update collision method considering the lesson duration, e.g., if oop starts at 14:30 TUE and 
		lasts 1 hour and db starts at 14:00 TUE, there is a collision.
		Hint: When the intersection of two intervals [s1, s2] and [t1, t2] is empty?

        b. 1 point for this:
		-You can create a Student class with list of Lessons (distinct from static list of all
		lessons!) with a method to draw a schedule. 
		-How can you store/operate with a room number considering 
		offline and online formats? 
		-How can you print, e.g., all lessons on Tuesday in sorted order?
		I will show you later the elegant way to do it. Try to implement it as you can now.
		
		If you implement a and b, you get 2 points.
		
		More practice - more knowledge. Good luck!
 */
	}

}
