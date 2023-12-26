package researcher;

import java.util.List;

import staff.Employee;

/**
 * The EmployeeResearcher class represents an employee with researcher status
 * @author Code Symphony
 */
public class EmployeeResearcher extends Employee implements Researcher  {
	
	private static final long serialVersionUID = -3599532175820123036L;

	/**
	 * Default empty constructor for the Employeeresearcher class
	 */
	public EmployeeResearcher() {
		
	}
	
	/**
	 * Parameterized constructor for the Employeeresearcher class
	 * @param name
	 * @param surname
	 */
	public EmployeeResearcher(String name, String surname) {
		super(name, surname);
	}
	
	@Override
	/**
	 * Retrieves and returns a list of research papers authored by the EmployeeResearcher
	 * @return A list of ResearchPaper objects authored by the EmployeeResearcher
	 */
	public List<ResearchPaper> printPapers() {
		return ResearcherUtils.printPapers(this);
	}

	@Override
	/**
	 * Calculates and returns the h-index of the EmployeeResearcher
	 * @return The h-index of the EmployeeResearcher
	 */
	public int calculateHIndex() {
		return ResearcherUtils.calculateHIndex(this);
	}

}
