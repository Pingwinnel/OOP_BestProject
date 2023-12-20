package utilities;

import java.util.List;

import researcher.ResearchPaper;

public interface Observer {
	public void update(List<ResearchPaper> researchPapers);
}