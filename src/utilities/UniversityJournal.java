package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import researcher.ResearchPaper;

/**
 * The UniversityJournal class represents a journal in a university that observes research papers
 * @author Code Symphony
 */
public class UniversityJournal implements Observable{
	private List<Observer> observers = new ArrayList<Observer>(); 
	
	
	/**
	 * Constructor with an empty list of observers for the UniversityJournal class
	 */
    public UniversityJournal() {

    }
    

    @Override
	public String toString() {
		return "UniversityJournal " + "\nJournal observers:" + DataSingleton.INSTANCE.getObservers() + "\nAll Papers: " + DataSingleton.INSTANCE.getResearchPapers() + "\nLatest Paper: " + getLatest();
	}
  

    /**
     * Subscribes an observer to the journal
     * @param observer The observer to be subscribed
     */
	@Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

	/**
     * Unsubscribes an observer from the journal
     * @param observer The observer to be unsubscribed
     */
    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all subscribed observers of updates in the journal
     * @throws FileNotFoundException 
     */
    @Override
	public void notifyObservers() throws FileNotFoundException {
		for(Observer o: observers) {
			o.update();
		}
		
	}
   

    /**
     * Sets a new research paper in the journal and notifies observers
     * @param newPaper The new research paper to be added to the journal
     * @throws IOException If an I/O error occurs while adding the research paper
     */
    public void setNewPapers(ResearchPaper newPaper) throws IOException {
    	DataSingleton.INSTANCE.addResearchPapers(newPaper);
        notifyObservers();
    }
	
    /**
     * Gets the latest research paper in the journal
     * @return The latest research paper or null if no papers are available
     */
    public ResearchPaper getLatest() {
        if (DataSingleton.INSTANCE.getResearchPapers().isEmpty()) {
            return null; // No papers available
        }

        ResearchPaper latest = DataSingleton.INSTANCE.getResearchPapers().get(DataSingleton.INSTANCE.getResearchPapers().size()-1);

        for (ResearchPaper paper : DataSingleton.INSTANCE.getResearchPapers()) {
            if (paper.getDate().compareTo(latest.getDate()) > 0) {
                latest = paper;
            }
        }
        
        return latest;
    }


	
}
