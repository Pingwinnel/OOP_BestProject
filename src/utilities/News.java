package utilities;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import teacher.UrgencyLevel;

public class News implements Serializable{
	private String title;
	private UrgencyLevel priority;
	private String text;
	private Date date;

	public News(String title, UrgencyLevel priority, String text) {
		this.priority = priority;
		this.text = text;
		this.title = title;
		this.date = new Date();
	}
	
	public News() {
		
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public UrgencyLevel getPriority() {
		return priority;
	}

	public void setPriority(UrgencyLevel priority) {
		this.priority = priority;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
