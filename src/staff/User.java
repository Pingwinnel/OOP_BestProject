package staff;

import java.io.Serializable;
import java.util.Objects;

import utilities.Utils;

public abstract class User implements Serializable{
	private int id;
	private static int cnt;
	private String surname;
	private String name;
	private String corparateEmail;
	private String password;
	
	static {
		cnt++;
	}
	public User() {}
	
	public User(String surname, String name) {
		this.id = cnt;
		this.setSurname(surname);
		this.setName(name);
		this.corparateEmail = Utils.generateCorparateEmail(this);
		this.password = Utils.generatePassword();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCorparateEmail() {
		return corparateEmail;
	}

	public void setCorparateEmail(String corparateEmail) {
		this.corparateEmail = corparateEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "id: " + getId() + ", surname: " + getSurname() + ", name: " + getName() + ", corparateEmail: " + getCorparateEmail();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCorparateEmail(), getId(), getName(), getPassword(), getSurname());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		User other = (User) obj;
		return getId() == other.getId() && Objects.equals(getCorparateEmail(), other.getCorparateEmail()) &&
				Objects.equals(getName(), other.getName()) && Objects.equals(getPassword(), other.getPassword())
				&& Objects.equals(getSurname(), other.getSurname());
	}
	
	
	
}
