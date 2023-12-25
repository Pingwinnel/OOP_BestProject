/**
 * @author Yerasyil
 * @version 25.12.2023
 */
package course;

import java.io.Serializable;
import java.util.Objects;


//Class which represent time 
public class Time implements Serializable{
	private int hour;
	private int min;

	public Time() {
		
	}
	public Time(int hour, int min) {
		this.min=min;
		this.hour = hour;
	}

	public String toString() {
		return this.hour+ ":"+this.min;
	}
	@Override
	public int hashCode() {
		return Objects.hash(hour, min);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return hour == other.hour && min == other.min;
	}
}
