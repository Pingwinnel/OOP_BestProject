package Researcher;

public abstract class ResearchDecorator implements CanBeResearcher{
	protected final CanBeResearcher decoratedResearcher;
	
	public ResearchDecorator(CanBeResearcher r) {
		this.decoratedResearcher = r;
	}
	public void getResearcherPapers() {
		// TODO Auto-generated method stub
		System.out.println("a list of research papers");
		
	}
	

}
