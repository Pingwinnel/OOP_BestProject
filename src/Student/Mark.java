package Student;

import java.io.Serializable;
import java.util.HashMap;

import utilities.transformMark;

/**
* @generated
*/

public class Mark implements Serializable{
	
	public Mark() {
		
	}
	public Mark(double mark) {
		this.digitGrades=mark;
		this.letterGrades=transformMark.transform(mark);
	}
    
    /**
    * @generated
    */
    private int score;
    
    /**
    * @generated
    */
    private String letterGrades;
    
    /**
    * @generated
    */
    private double digitGrades;
    
    /**
    * @generated
    */
    private double firstAtt;
    
    /**
    * @generated
    */
    private double secondAtt;
    
    /**
    * @generated
    */
    private double finalExamScore;
    
    /**
    * @generated
    */
    private double fullAtt;
    
    

    public String toString() {
        //TODO
        return "";
    }
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getLetterGrades() {
		return letterGrades;
	}
	public void setLetterGrades(String letterGrades) {
		this.letterGrades = letterGrades;
	}
	public double getDigitGrades() {
		return digitGrades;
	}
	public void setDigitGrades(double digitGrades) {
		this.digitGrades = digitGrades;
	}
	public double getFirstAtt() {
		return firstAtt;
	}
	public void setFirstAtt(double firstAtt) {
		this.firstAtt = firstAtt;
	}
	public double getSecondAtt() {
		return secondAtt;
	}
	public void setSecondAtt(double secondAtt) {
		this.secondAtt = secondAtt;
	}
	public double getFinalExamScore() {
		return finalExamScore;
	}
	public void setFinalExamScore(double finalExamScore) {
		this.finalExamScore = finalExamScore;
	}
	public double getFullAtt() {
		return fullAtt;
	}
	public void setFullAtt(double fullAtt) {
		this.fullAtt = fullAtt;
	}
    
    
    
    
    
    
}
