package utilities;

public class transformMark {
 public static String transform(double grade) {
	 if (grade <= 100 && grade >= 90) {
         return "A";
     } else if (grade < 90 && grade >= 80) {
         return "B";
     } else if (grade < 80 && grade >= 70) {
         return "C";
     } else if (grade < 70 && grade >= 60) {
         return "D";
     } else if (grade < 60) {
         return "F";
     }
	 return null;
 }
}
