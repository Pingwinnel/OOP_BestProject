package researcher;

import java.util.Collections;
import java.util.Vector;

public class CalculationOfHIndex {
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
}
