package search.client;

import search.BinarySearchSymbolTable;
import search.SymbolTable;

public class Grades {
	
	public static enum GradeScore {
		A_PLUS, A, A_MINUS, B_PLUS, B, B_MINUS, C_PLUS, C, C_MINUS, D, F
	}
	
	private SymbolTable<GradeScore, Double> gradeScoreNumber;
	
	public Grades() {
		gradeScoreNumber = new BinarySearchSymbolTable<Grades.GradeScore, Double>(20);
		gradeScoreNumber.put(GradeScore.A_PLUS, 4.33);
		gradeScoreNumber.put(GradeScore.A, 4.00);
		gradeScoreNumber.put(GradeScore.A_MINUS, 3.67);
		gradeScoreNumber.put(GradeScore.B_PLUS, 3.33);
		gradeScoreNumber.put(GradeScore.B, 3.00);
		gradeScoreNumber.put(GradeScore.B_MINUS, 2.67);
		gradeScoreNumber.put(GradeScore.C_PLUS, 2.33);
		gradeScoreNumber.put(GradeScore.C, 2.00);
		gradeScoreNumber.put(GradeScore.C_MINUS, 1.67);
		gradeScoreNumber.put(GradeScore.D, 1.00);
		gradeScoreNumber.put(GradeScore.F, 0.00);
	}
	
	public double GPA(GradeScore[] scores) {
		double sum = 0;
		for(GradeScore score : scores) {
			sum += gradeScoreNumber.get(score);
		}
		
		double length = scores.length;
		
		return sum / length;
	}
	
}
