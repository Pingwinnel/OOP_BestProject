package Main;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable{
	private int id;
	private String surname;
	private String name;
	private String corparateEmail;
	private String password;
	
	public User() {}
	
	public User(int id, String surname, String name, String corparateEmail, String password) {
		this.setId(id);
		this.setSurname(surname);
		this.setName(name);
		this.setCorparateEmail(corparateEmail);
		this.setPassword(password);
	}

	@Override
	public String toString() {
		return "User [id=" + getId() + ", surname=" + getSurname() + ", name=" + getName() + ", corparateEmail=" + getCorparateEmail()
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCorparateEmail(), getId(), getName(), getPassword(), getSurname());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(getCorparateEmail(), other.getCorparateEmail()) && getId() == other.getId()
				&& Objects.equals(getName(), other.getName()) && Objects.equals(getPassword(), other.getPassword())
				&& Objects.equals(getSurname(), other.getSurname());
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
	
	
	
}
