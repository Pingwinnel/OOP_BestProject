package staff;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import researcher.ResearchPaper;
import utilities.*;

/**
 * The User class observes changes in the system through the Observer interface
 * @author Code Symphony
 */
public abstract class User implements Serializable, Observer{

	private int id;
	private String surname;
	private String name;
	private String corparateEmail;
	private String password;
	
	/**
	 * Default empty constructor for the User class
	 */
	public User() {}
	
	/**
	 * Parameterized constructor for the User class that initializes an user with a given name
	 * @param surname
	 * @param name
	 */
	public User(String name) {
		this.name = name;
	}
	
	/**
	 * Parameterized constructor for the User class that initializes an user with a given surname and name
	 * @param surname
	 * @param name
	 */
	public User(String surname, String name) {
		this.id = DataSingleton.nextId();
		this.setSurname(surname);
		this.setName(name);
		this.corparateEmail = Utils.generateCorparateEmail(this);
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

	/**
     * Sets a randomly generated password for the user
     */
	public void setPassword() {
		this.password = Utils.generatePassword();
	}
	
	 /**
     * Changes the password of the user
     * @param password The new password to be set
     */
	public void changePassword(String password) {
		this.password = password;
		DataSingleton.INSTANCE.getLoginInfo().replace(getCorparateEmail(), password);
	}
	
	@Override
	public String toString() {
		return "id: " + getId() + ", surname: " + getSurname() + ", name: " + getName() + ", corparateEmail: " + getCorparateEmail();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCorparateEmail(), getName(), getSurname());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		User other = (User) obj;
		return Objects.equals(getCorparateEmail(), other.getCorparateEmail()) &&
				Objects.equals(getName(), other.getName()) && Objects.equals(getPassword(), other.getPassword())
				&& Objects.equals(getSurname(), other.getSurname());
	}
	
	/**
     * Views news articles related to research first, followed by other news, sorted by priority
     * @return A vector of news articles
     */
	public Vector<News> viewNews() {
    	Stream<News> researchNews = DataSingleton.INSTANCE.getNews().stream()
                    .filter(news -> news.getTitle().toLowerCase().contains("research"))
                    .sorted(Comparator.comparing(News::getPriority));
    	
    	Stream<News> nonResearchNews = DataSingleton.INSTANCE.getNews().stream()
    		    .filter(news -> !news.getTitle().toLowerCase().contains("research"))
    		    .sorted(Comparator.comparing(News::getPriority));
    	
        return Stream.concat(researchNews, nonResearchNews)
                .collect(Collectors.toCollection(Vector::new));
    }
	
	/**
     * Updates the user when changes occur in the system
     */
	@Override
	public void update() {
		System.out.println(this.corparateEmail + " Journal is updated!");
	}
	
	/**
     * Subscribes the user to a journal for receiving updates
     * @param journal The journal to subscribe to
     */
    public void subscribeToJournal(UniversityJournal journal) {
        journal.subscribe(this);
    }
	
}
