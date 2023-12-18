package researcher;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import utilities.DataSingleton;

public class ResearcherUtils {
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
	public static List<ResearchPaper> printPapers(Researcher researcher){
		List<ResearchPaper> papers = DataSingleton.INSTANCE.getResearchPapers().stream().filter(n->n.getAuthors().contains(researcher)).collect(Collectors.toList());
		return papers;
	}
}
