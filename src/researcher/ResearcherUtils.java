package researcher;


import java.util.Collections;

import java.util.List;
import java.util.stream.Collectors;

import utilities.DataSingleton;

/**
 * The ResearjerUtils class performs operations related to researchers and research papers
 * @author Code Symphony
 */
public class ResearcherUtils {
	
	/**
    * Calculates the H-index of a given researcher based on their authored research papers
    * @param researcher The researcher for whom the H-index is to be calculated
    * @return The calculated H-index
    */
	public static int calculateHIndex(Researcher researcher) {
		List<ResearchPaper> papers = printPapers(researcher);
		Collections.sort(papers);
		int hIndex = 0;
        for (int i = 0; i < papers.size(); i++) {
            while(papers.get(i).getCitations()>=i+1) {
            	hIndex = i;
            	i++;
            }
        }
        return hIndex+1;
	}
	/**
	 * Takes a researcher as input and returns a list of research papers that the researcher has authored
	 * @param researcher Instance of the Researcher class that represents a researcher who has authored one or more research papers
	 * @return A list of ResearchPaper objects
	 */
	public static List<ResearchPaper> printPapers(Researcher researcher){
		List<ResearchPaper> papers = DataSingleton.INSTANCE.getResearchPapers().stream().filter(n->n.getAuthors().contains(researcher)).collect(Collectors.toList());
		return papers;
	}
}
