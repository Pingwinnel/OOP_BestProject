package researcher;

import java.util.Collections;
import java.util.Vector;

public class EmployeeResearcher implements Researcher {

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
		// maybe separate class with this static method 
		Collections.sort(papers);
		int hIndex = 0, citation = 0;
        for (int i = 0; i < papers.size(); i++) {
            while(papers.get(i).getCitations()>=i) {
            	citation = papers.get(i).getCitations();
            	hIndex = i;
            	i++;
            }
        }
        return hIndex+1;
	}

}
