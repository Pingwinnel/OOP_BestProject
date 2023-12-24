package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import researcher.ResearchPaper;

public class UniversityJournal implements Observable{
	private List<Observer> observers; 
	private List<ResearchPaper> researchPapers;
//	private DataSingleton.INSTANCE.getResearchPapers();
//	private ResearchPaper latest;
	
    public UniversityJournal() {
        observers = new ArrayList<>();
        researchPapers = new ArrayList<>();
    }

    @Override
	public String toString() {
		return "UniversityJournal \n" + "Journal observers:" + observers + "\nAll Papers: " + researchPapers + "\nLatest Paper: " + getLatest();
	}
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversityJournal that = (UniversityJournal) o;
        return Objects.equals(observers, that.observers) &&
                Objects.equals(researchPapers, that.researchPapers) &&
                Objects.equals(getLatest(), that.getLatest());
    }

    @Override
    public int hashCode() {
        return Objects.hash(observers, researchPapers, getLatest());
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
            observer.update(researchPapers);
        }
        System.out.println("New Research Paper!");
    }

    public void setNewPapers(List<ResearchPaper> newPapers) {
        researchPapers.addAll(newPapers);
        notifyObservers();
    }
	
    public ResearchPaper getLatest() {
        if (researchPapers.isEmpty()) {
            return null; // No papers available
        }

        ResearchPaper latest = researchPapers.get(researchPapers.size()-1); // Assuming the list is sorted by publication date

        for (ResearchPaper paper : researchPapers) {
            if (paper.getDate().compareTo(latest.getDate()) > 0) {
                latest = paper;
            }
        }

        return latest;
    }

}
