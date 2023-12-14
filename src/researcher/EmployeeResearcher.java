package researcher;

import java.util.Collections;
import java.util.Vector;

import staff.Employee;
import staff.User;

public class EmployeeResearcher extends Employee implements Researcher  {
	
	public EmployeeResearcher() {
		
	}
	
	public EmployeeResearcher(String name, String surname, double salary) {
		super(name, surname, salary);
	}
	
	@Override
	public void printPapers() {
		
		
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
