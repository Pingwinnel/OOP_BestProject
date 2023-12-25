/**
 * @author Yerasyil
 * @version 25.12.2023
 */
package researcher;


import java.util.Collections;

import java.util.List;
import java.util.stream.Collectors;

import utilities.DataSingleton;
//Some static method which use in researcher package
public class ResearcherUtils {
	//calculate h-index of researcher
	public static int calculateHIndex(Researcher researcher) {
		//list of research papers
		List<ResearchPaper> papers = printPapers(researcher);
		//sort papers
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
	 * The function "printPapers" takes a researcher as input and returns a list of research papers that
	 * the researcher has authored.
	 * 
	 * @param researcher The "researcher" parameter is an instance of the Researcher class. It represents
	 * a researcher who has authored one or more research papers.
	 * @return The method is returning a list of ResearchPaper objects.
	 */
	public static List<ResearchPaper> printPapers(Researcher researcher){
		List<ResearchPaper> papers = DataSingleton.INSTANCE.getResearchPapers().stream().filter(n->n.getAuthors().contains(researcher)).collect(Collectors.toList());
		return papers;
	}
}
