package tests;

import java.util.ArrayList;
import java.util.List;

import researcher.ResearchPaper;
import student.Major;
import student.Schools;
import staff.User;
import student.Student;
import utilities.DataSingleton;
import utilities.UniversityJournal;

public class TestUniversityJournal {

	public static void main(String[] args) {
        UniversityJournal universityJournal = new UniversityJournal();

        Student student1 = new Student("Abdugapparova","Tuba",Schools.SITE, Major.CSaS);
        Student student2 = new Student("Saidazym","Aknur",Schools.SITE, Major.IS);

        student1.subscribeToJournal(universityJournal);
        student2.subscribeToJournal(universityJournal);

        DataSingleton.INSTANCE.getResearchPapers().add(new ResearchPaper("Paper1", 10, 5, "doi1"));
        DataSingleton.INSTANCE.getResearchPapers().add(new ResearchPaper("Paper2", 15, 8, "doi2"));

//        universityJournal.setNewPapers(newResearchPapers);
        
        System.out.println(universityJournal);
        universityJournal.notifyObservers();
	}

}
