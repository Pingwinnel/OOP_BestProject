package utilities;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * The Observable interface represents an object that can be observed by one or more observers
 * @author Code Symphony
 */
public interface Observable {
	/**
     * Adds an observer to the list of subscribers
     * @param Observer the observer to be added
     */
	void subscribe(Observer observer);

	/**
     * Removes an observer from the list of subscribers
     * @param Observer the observer to be removed
     */
	void unsubscribe(Observer observer);

	/**
     * Notifies all observers about a change in the observable object
     */
	void notifyObservers() throws FileNotFoundException;
	
}