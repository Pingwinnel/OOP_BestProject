package researcher;

import java.util.Vector;

public interface Researcher {

	Vector<ResearchPaper> printPapers();
	int calculateHIndex();
}
