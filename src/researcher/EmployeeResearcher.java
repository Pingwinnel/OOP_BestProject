package researcher;

import java.util.Vector;
import staff.Employee;


public class EmployeeResearcher extends Employee implements Researcher  {
	
	public EmployeeResearcher() {
		
	}
	
	public EmployeeResearcher(String name, String surname, double salary) {
		super(name, surname, salary);
	}
	
	@Override
	public Vector<ResearchPaper> printPapers() {
		return ResearcherUtils.printPapers(this);
	}

	@Override
	public int calculateHIndex() {
		return ResearcherUtils.calculateHIndex(this);
	}

}
