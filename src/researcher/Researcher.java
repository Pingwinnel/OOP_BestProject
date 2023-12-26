package researcher;

import java.util.List;

/**
 * The Researcher interface representis a researcher with methods for printing research papers and calculating the H-index
 * @author Code Symphony
 */
public interface Researcher {

	/**
     * Retrieves a list of research papers associated with the researcher
     * @return List of research papers
     */
	List<ResearchPaper> printPapers();
	
	/**
     * Calculates and retrieves the H-index of the researcher
     * @return The calculated H-index
     */
	int calculateHIndex();
}
