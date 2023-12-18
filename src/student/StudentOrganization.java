package student;

import java.io.Serializable;
import java.util.Vector;

public class StudentOrganization implements Serializable{
	
	private String studOrgName;
	private Student head;
	private Vector<Student> members;
	
	public StudentOrganization() {
		
	}
	
	public StudentOrganization(String studOrgName, Student head) {
		this.studOrgName = studOrgName;
		this.head = head;
	}

	public String getStudOrgName() {
		return this.studOrgName;
	}
	
	public Student getHead() {
		return this.head;
	}
	
	public Vector<Student> getMembers() {
		return this.members;
	}
	
	public void setStudOrgName(String studOrgName) {
		this.studOrgName = studOrgName;
	}
	
	public void setHead(Student head) {
		this.head = head;
	}
	
	public void addMember(Student member) {
		members.add(member);
	}
	
	public void removeMember(Student member) {
		members.remove(member);
	}
	
	public String toString() {
		return "StudentOrganization [name=" + this.studOrgName + ", head=" + this.head + ", members=" + this.members + "]";
	}
}
