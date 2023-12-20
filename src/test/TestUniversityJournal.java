package test;

import java.util.ArrayList;
import java.util.List;

import researcher.ResearchPaper;
import student.Major;
import student.Schools;
import student.Student;
import utilities.UniversityJournal;

public class TestUniversityJournal {

	public static void main(String[] args) {
        UniversityJournal universityJournal = new UniversityJournal();

        Student student = new Student("Tuba","Aknur",Schools.BS,Major.IS);

        student.subscribeToJournal(universityJournal);

        List<ResearchPaper> newResearchPapers = new ArrayList<>();
        newResearchPapers.add(new ResearchPaper("Paper1", 10, 5, "doi1"));
        newResearchPapers.add(new ResearchPaper("Paper2", 15, 8, "doi2"));

        universityJournal.setNewPapers(newResearchPapers);
        
        System.out.println(universityJournal);
	}

}
