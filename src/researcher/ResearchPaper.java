/**
 * @author Yerasyil
 * @version 25.12.2023
 */
package researcher;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

/**
 * The ResearchPaper class represents a research paper with attributes such as name, authors, pages,
 * date, citations,and provides methods for getting and setting these attributes, generating
 * citations in different formats, and comparing papers based on citations.
 */
public class ResearchPaper implements Comparable<ResearchPaper>, Serializable{

// Data.papers().stream().filter(n->n.participants.contains(pakita).collect(Collectors.toList());
	private String name;
	// The line `private Vector<Researcher> authors = new Vector<Researcher>(); //authors` is initializing
	// the `authors` attribute of the `ResearchPaper` class as an empty `Vector` of `Researcher` objects.
	// This means that by default, a `ResearchPaper` object will have no authors.
	private Vector<Researcher> authors = new Vector<Researcher>(); //authors
	private int pages;
	private Date date;
	// The line `private int citations;` is declaring a private integer variable named `citations` in the
	// `ResearchPaper` class. This variable represents the number of citations that the research paper has
	// received. It is used to calculate of h index of  research paper.
	private int citations;
	// The line `private String doi;` is declaring a private string variable named `doi` in the
	// `ResearchPaper` class. This variable represents the Digital Object Identifier (DOI) of the research
	// paper. A DOI is a unique alphanumeric string assigned to a digital object, such as a research
	// paper, to provide a persistent link to its location on the internet. The DOI is often used as a
	// standard way to reference and identify research papers.
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
	
	/**
	 * The getCitation function returns a citation in either PlainTeX or BibTeX format based on the given
	 * format parameter.
	 * 
	 * @param format The format parameter is an enum type called Format. It has two possible values:
	 * PlainTeX and BibTeX.
	 * @return The method getCitation returns a string representation of a citation in the specified
	 * format. If the format is PlainTeX, it returns a formatted string with the authors, title, year,
	 * pages, and doi. If the format is BibTeX, it returns a formatted string in the BibTeX format. If the
	 * format is not supported, it returns the string "Unsupported format".
	 */
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
	// The `compareTo` method is used to compare two `ResearchPaper` objects based on their number of
	// citations. It is implemented as part of the `Comparable` interface, which allows objects of a class
	// to be compared and sorted.
	public int compareTo(ResearchPaper r) {
		// TODO Auto-generated method stub
		if(this.citations > r.citations) return -1;
		if(this.citations < r.citations) return 1;
		return 0;
	}
}
