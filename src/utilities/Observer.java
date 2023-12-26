package utilities;

import java.util.List;

import researcher.ResearchPaper;

/**
 * The Observer interface represents an object that observes changes in an observable object
 * @author Code Symphony
 */
public interface Observer {
	 /**
     * Updates the observer about changes in the observable object
     */
	public void update();
}