package researcher;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

public class ResearchPaper implements Comparable<ResearchPaper>, Serializable{

	// res paper - list of authors
	// pakita - rese
// Data.papers().stream().filter(n->n.participants.contains(pakita).collect(Collectors.toList());
	private String name;
	private Vector<Researcher> authors = new Vector<Researcher>(); //authors
	private int pages;
	private Date date;
	private int citations;
	private String doi;
	
	public ResearchPaper() {
		
	}
	
	public ResearchPaper(String name, int pages, int citations, String doi) {
		this.name = name;
		this.pages = pages;
		this.date = new Date();
		this.citations = citations;
		this.doi = doi;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Vector<Researcher> getAuthors() {
		return authors;
	}
	public void addAuthor(Researcher r) {
		authors.add(r);
	}
	
	public int getPages() {
		return this.pages;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public int getCitations() {
		return this.citations;
	}
	
	public String getDoi() {
		return this.doi;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setCitations(int citations) {
		this.citations = citations;
	}
	
	public void setDoi(String doi) {
		this.doi = doi;
	}
	
	public String getCitation(Format format) {
		if(format == Format.PlainTeX) {
			return String.format("%s et al., \"%s\", %tY, pages: %d, doi: %s", this.authors, this.name, this.date, this.pages, this.doi);
		}
		if(format == Format.BibTeX) {
			return String.format("@article{author={%s}, title={%s}, year={%tY}, , pages={%d}, doi={%s}}", this.authors, this.name, this.date, this.pages, this.doi);
		}
		return "Unsupported format";
	}
	
	public String toString() {	
		return "ResearchPaper's name: " + this.name + ", authors: " + this.authors + ", pages: " + this.pages + ", date: " + this.date + ", citations: " + this.citations + ", doi: " + this.doi;
	}
	

	@Override
	public int compareTo(ResearchPaper r) {
		// TODO Auto-generated method stub
		if(this.citations > r.citations) return -1;
		if(this.citations < r.citations) return 1;
		return 0;
	}
}
