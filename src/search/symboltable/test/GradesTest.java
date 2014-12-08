package search.symboltable.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import search.symboltable.client.Grades;

public class GradesTest {
	
	private Grades grades = new Grades();
	
	@Test
	public void aIsFour() {
		Grades.GradeScore[] scores = {Grades.GradeScore.A};
		assertEquals(4.00, grades.GPA(scores), 0.00);
	}
	
	@Test
	public void fIsZero() {
		Grades.GradeScore[] scores = {Grades.GradeScore.F};
		assertEquals(0.00, grades.GPA(scores), 0.00);
	}
	
	@Test
	public void calculatesGPA() {
		Grades.GradeScore[] scores = {Grades.GradeScore.A, Grades.GradeScore.A, Grades.GradeScore.F};
		assertEquals(2.67, grades.GPA(scores), 0.01);
	}

}
