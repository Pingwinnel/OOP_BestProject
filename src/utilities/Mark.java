package utilities;

import java.util.Objects;

public class Mark {
	private int att1;
	private int att2;
	private int finalExamScore;
	private int score;
	private String letterGrade;
	
	//all the rest fields write them!!!
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getLetterGrade() {
		return letterGrade;
	}
	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}
	public int getAtt1() {
		return att1;
	}
	public void setAtt1(int att1) {
		this.att1 = att1;
	}
	public int getAtt2() {
		return att2;
	}
	public void setAtt2(int att2) {
		this.att2 = att2;
	}
	public int getFinalExamScore() {
		return finalExamScore;
	}
	public void setFinalExamScore(int finalExamScore) {
		this.finalExamScore = finalExamScore;
	}
	@Override
	public String toString() {
		return "att1: " + att1 + ", att2: " + att2 + ", finalExamScore: " + finalExamScore +
				", Letter Grade: "+letterGrade +", score: "+score;
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
