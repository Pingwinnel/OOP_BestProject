package researcher;

import java.util.List;
import staff.Employee;


public class EmployeeResearcher extends Employee implements Researcher  {
	
	private static final long serialVersionUID = -3599532175820123036L;

	public EmployeeResearcher() {
		
	}
	
	public EmployeeResearcher(String name, String surname, double salary) {
		super(name, surname, salary);
	}
	
	@Override
	public List<ResearchPaper> printPapers() {
		return ResearcherUtils.printPapers(this);
	}

	@Override
	public int calculateHIndex() {
		return ResearcherUtils.calculateHIndex(this);
	}

}
