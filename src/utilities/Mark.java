package utilities;

import java.io.Serializable;
import java.util.Objects;

<<<<<<< HEAD
public class Mark implements Serializable {
	private int att1;
	private int att2;
	private int finalExamScore;
	private int score;
	private String letterGrade;
	
	
	public int getScore() {
		score=att1+att2+finalExamScore;
		return score ;
	}
=======
public class Mark implements Serializable{
	private double att1;
	private double att2;
	private double finalExamScore;
	private double score;
	private String letterGrade;
	

	public double getScore() {
		return score;
	}
	
>>>>>>> 679e6757646f56875dc48e8263c9b4466286d1a8
	public String getLetterGrade() {
		return letterGrade;
	}
	
	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
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
				", Letter Grade: "+letterGrade +", score: "+ (att1 + att2 + finalExamScore);
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
