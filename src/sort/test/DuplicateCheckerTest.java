package sort.test;

import static org.junit.Assert.*;

import org.junit.Test;

import sort.client.DuplicateChecker;

public class DuplicateCheckerTest {

	@Test
	public void testNoDuplicates() {
		Integer[] noDuplicates = new Integer[] { 2, 9, 7, 3, 1, 10, 6, 8, 4, 5 };
		DuplicateChecker<Integer> checker = new DuplicateChecker<Integer>(noDuplicates);
		assertFalse(checker.hasDuplicates());
	}
	
	@Test
	public void testDuplicates() {
		Integer[] duplicates = new Integer[] {6, 8, 1, 6, 2, 6, 5, 3, 9, 4, 10};
		DuplicateChecker<Integer> check = new DuplicateChecker<Integer>(duplicates);
		assertTrue(check.hasDuplicates());
	}

}
