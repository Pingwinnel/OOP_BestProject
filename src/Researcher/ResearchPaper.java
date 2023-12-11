package Researcher;

import java.util.Date;
import java.util.Vector;

public class ResearchPaper {

	private String name;
	private Vector<Researcher> participants;
	private int pages;
	private Date date;
	private int citations;
	private String doi;
	
	public ResearchPaper() {
		
	}
	
	public ResearchPaper(String name, Vector<Researcher> participants, int pages, Date date, int citations, String doi) {
		this.name = name;
		this.participants = participants;
		this.pages = pages;
		this.date = date;
		this.citations = citations;
		this.doi = doi;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Vector<Researcher> getParticipants() {
		return this.participants;
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
			return String.format("%s et al., \"%s\", %tY, pages: %d, doi: %s", this.participants, this.name, this.date, this.pages, this.doi);
		}
		if(format == Format.BibTeX) {
			return String.format("@article{author={%s}, title={%s}, year={%tY}, , pages={%d}, doi={%s}}", this.participants, this.name, this.date, this.pages, this.doi);
		}
		return "Unsupported format";
	}
	
	public String toString() {	
		return "ResearchPaper [name=" + this.name + ", participants=" + this.participants + ", pages=" + this.pages + ", date=" + this.date + ", citations=" + this.citations + ", doi=" + this.doi + "]";
	}
	
}
