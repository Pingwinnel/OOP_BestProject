/**
 * @author Yerasyil
 * @version 25.12.2023
 */
package researcher;

import java.util.List;

import staff.Employee;

//This class a describe a resercher as a worker 
public class EmployeeResearcher extends Employee implements Researcher  {
	
	private static final long serialVersionUID = -3599532175820123036L;

	public EmployeeResearcher() {
		
	}
	//Employee constructor
	public EmployeeResearcher(String name, String surname, double salary) {
		super(name, surname, salary);
	}
	
	@Override
	//print research paper of researcher
	public List<ResearchPaper> printPapers() {
		return ResearcherUtils.printPapers(this);
	}

	@Override
	//calculate h-index of researcher
	public int calculateHIndex() {
		return ResearcherUtils.calculateHIndex(this);
	}

}
