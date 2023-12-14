package researcher;


import java.util.Collections;
import java.util.Vector;
import java.util.stream.Collectors;

import utilities.DataSingleton;

public class ResearcherUtils {
	public static int calculateHIndex(Vector<ResearchPaper> papers) {
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
	public static Vector<ResearchPaper> printPapers(Researcher researcher){
		Vector<ResearchPaper> papers = (Vector<ResearchPaper>) DataSingleton.getInstance().getResearchPapers().stream().filter(n->n.getAuthors().contains(researcher)).collect(Collectors.toList());
		return papers;
	}
}
