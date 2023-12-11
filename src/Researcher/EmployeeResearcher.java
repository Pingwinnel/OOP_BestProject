package Researcher;

import java.util.Vector;

import Main.User;

public class EmployeeResearcher extends User implements Researcher {

	private Vector<ResearchPaper> papers;

	@Override
	public void printPapers() {
		// TODO Auto-generated method stub
		System.out.println("Employee Researcher's papers:");
		for (ResearchPaper paper : papers) {
            System.out.println(paper);
        }
		
	}

	@Override
	public int calculateHIndex(Vector<ResearchPaper> papers) {
		// TODO Auto-generated method stub
		int hIndex = 0;
        for (int i = 0; i < papers.size(); i++) {
            int citations = papers.get(i).getCitations();
            int papersWithCitations = papers.size() - i;
            if (citations >= papersWithCitations) {
                hIndex = papersWithCitations;
                break;
            }
        }
        return hIndex;
	}

}
