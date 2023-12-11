package Researcher;

import java.util.Vector;

public interface Researcher {

	void printPapers();
	int calculateHIndex(Vector<ResearchPaper> papers);
}
