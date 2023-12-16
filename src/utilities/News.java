package utilities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class News implements Serializable{
	private String title;
	private int priority;
	private String text;
	private Date date;

	public News() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, priority, text, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		return Objects.equals(date, other.date) && priority == other.priority && Objects.equals(text, other.text)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "News " + '\n' + "title: " + title + '\n' + "priority: " + priority + '\n' + "date: " + date + '\n' + "text: " + text;
	}
	
	

}
