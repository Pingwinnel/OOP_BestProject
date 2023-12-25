/**
 * @author Yerasyil
 * @version 25.12.2023
 */
package researcher;

import java.util.List;

public interface Researcher {

	/**
	 * The function "printPapers" returns a list of research papers.
	 * 
	 * @return A List of ResearchPaper objects is being returned.
	 */
	List<ResearchPaper> printPapers();
	/**
	 * The function calculates the H-index.
	 * 
	 * @return The function calculateHIndex is returning an integer value.
	 */
	int calculateHIndex();
}
