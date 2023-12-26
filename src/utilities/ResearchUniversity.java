package utilities;

/**
 * The ResearchUniversity class represents a singleton instance of a research university that provides a mechanism to manage the current week within the university
 * @author Code Symphony
 */
public class ResearchUniversity {
	private static int week;
	
	/**
     * The singleton instance of the ResearchUniversity class
     */
	public static final ResearchUniversity INSTANCE = new ResearchUniversity();
	
	private ResearchUniversity() {
		
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		ResearchUniversity.week = week;
	}
	

}
