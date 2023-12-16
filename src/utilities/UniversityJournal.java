package utilities;

import java.util.List;
import java.util.Vector;
import researcher.ResearchPaper;

public class UniversityJournal implements Observable, Observer{
	private List<Observer> observers; 
	private Vector<ResearchPaper> resp;
//	private DataSingleton.INSTANCE.getResearchPapers();
	private ResearchPaper latest;
	
	public static void subscribe() {
		
	}
	
	public static void unsubscribe() {
		
	}
	
	public static void notifyObserver() {
		
	}
	
	public void setNewPapers() {
		
	}
}