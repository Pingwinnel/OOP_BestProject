package test;

import java.io.IOException;

import staff.Dean;
import student.Schools;
import teacher.Teacher;
import teacher.UrgencyLevel;
import utilities.DataSingleton;

public class TestComplaint {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataSingleton db = DataSingleton.INSTANCE;
		Teacher t1 = new Teacher("a1", "b1", 250000, Schools.SAM);
		Dean deanSITE = new Dean("a2", "b2", 250000, Schools.SITE);
		Teacher t2 = new Teacher("a2", "b2", 250000, Schools.BS);
		Dean deanBS = new Dean("a2", "b2", 250000, Schools.BS);
		t1.sendComplaint(Schools.SITE, "Complaint about SITE student 1", UrgencyLevel.HIGH);
		t1.sendComplaint(Schools.SITE, "Complaint about SITE student 2", UrgencyLevel.LOW);
		t1.sendComplaint(Schools.BS, "Complaint about BS student 3", UrgencyLevel.MEDIUM);
		t1.sendComplaint(Schools.SITE, "Complaint about SITE student 4", UrgencyLevel.LOW);
		
		System.out.println(db.getComplaintsByFaculty(Schools.SITE));
		System.out.println(db.getComplaintsByFaculty(Schools.BS));
		
		deanSITE.readComplaints();
		
		System.out.println(db.getComplaintsByFaculty(Schools.SITE));
		System.out.println(db.getComplaintsByFaculty(Schools.BS));
		
		t1.sendComplaint(Schools.BS, "Complaint about BS student 1", UrgencyLevel.HIGH);
		t1.sendComplaint(Schools.SITE, "Complaint about SITE student 2", UrgencyLevel.LOW);
		
		System.out.println(db.getComplaintsByFaculty(Schools.SITE));
		System.out.println(db.getComplaintsByFaculty(Schools.BS));
		
		t2.sendComplaint(Schools.BS, "Complaint about BS student 1", UrgencyLevel.HIGH);
		t2.sendComplaint(Schools.BS, "Complaint about BS student 2", UrgencyLevel.LOW);
		t2.sendComplaint(Schools.SITE, "Complaint about SITE student 3", UrgencyLevel.MEDIUM);
		
		System.out.println(db.getComplaintsByFaculty(Schools.SITE));
		System.out.println(db.getComplaintsByFaculty(Schools.BS));
		
		deanBS.readComplaints();
		
		System.out.println(db.getComplaintsByFaculty(Schools.SITE));
		System.out.println(db.getComplaintsByFaculty(Schools.BS));
		
	}

}
