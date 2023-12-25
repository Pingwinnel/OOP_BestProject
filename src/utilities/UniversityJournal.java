package utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import researcher.ResearchPaper;

public class UniversityJournal implements Observable{
	private List<Observer> observers; 
	
    public UniversityJournal() {
        observers = new ArrayList<>();
    }

    @Override
	public String toString() {
		return "UniversityJournal " + "\nJournal observers:" + observers + "\nAll Papers: " + DataSingleton.INSTANCE.getResearchPapers() + "\nLatest Paper: " + getLatest();
	}
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversityJournal that = (UniversityJournal) o;
        return Objects.equals(observers, that.observers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(observers);
    }

	@Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
//        System.out.println("New Research Paper!");
    }

    public void setNewPapers(ResearchPaper newPaper) throws IOException {
    	DataSingleton.INSTANCE.addResearchPapers(newPaper);
        notifyObservers();
    }
	
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
