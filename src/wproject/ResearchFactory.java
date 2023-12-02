package wproject;

public class ResearchFactory {
	public static Researcher makeResearcher(User u) {
		if(u instanceof Researcher) {
			Researcher r = (Researcher)u;
			return r;
		} else {
			System.out.println("nono");
		}
		return null;
		
		
	}
}
