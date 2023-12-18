package utilities;

public class ResearchUniversity {
	private static int week;
	
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
