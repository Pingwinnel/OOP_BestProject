package utilities;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Mark class represents the academic performance of a student in a course and includes attributes such as attendance scores, final exam score, total score and letter grade
 * @author Code Symphony
 */
public class Mark implements Serializable {
	private static final long serialVersionUID = 5063732366564975348L;
	private double att1;
	private double att2;
	private double finalExamScore;
	private double score;
	
	/**
	 * Default empty constructor for the Mark class
	 */
	public Mark() {
		
	}
	
	/**
	 * Parameterized constructor for the Mark class
	 * @param att1
	 * @param att2
	 * @param finalExamScore
	 */
	public Mark(double att1, double att2, double finalExamScore) {
		this.att1 = att1;
		this.att2 = att2;
		this.finalExamScore = finalExamScore;
	}
	
	/**
     * Calculates and retrieves the total score
     * @return The total score
     */
	public double getScore() {
		score=att1+att2+finalExamScore;
		return score ;
	}
	
	 /**
     * Retrieves the letter grade corresponding to the total score
     * @return The letter grade
     */
	public String getLetterGrade() {
		  String grades[] = {"F","F","F","F","F","F","F","F","F","F", "D", "D+", "-C", "C", "+C", "-B", "B", "+B", "-A", "A"};
		  return grades[(int)(Math.round(getScore())/5)];
	}

	public double getAtt1() {
		return att1;
	}
	public void setAtt1(double att1) {
		this.att1 = att1;
	}
	public double getAtt2() {
		return att2;
	}
	public void setAtt2(double att2) {
		this.att2 = att2;
	}
	public double getFinalExamScore() {
		return finalExamScore;
	}
	public void setFinalExamScore(double finalExamScore) {
		this.finalExamScore = finalExamScore;
	}
	@Override
	public String toString() {
		return "att1: " + att1 + ", att2: " + att2 + ", finalExamScore: " + finalExamScore +
				", Letter Grade: "+ getLetterGrade() +", score: "+ getScore();

	}
	@Override
	public int hashCode() {
		return Objects.hash(att1, att2, finalExamScore);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mark other = (Mark) obj;
		return att1 == other.att1 && att2 == other.att2 && finalExamScore == other.finalExamScore;
	}
	
}