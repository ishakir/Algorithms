package search.set.math.test;

import static org.junit.Assert.*;

import org.junit.Test;

import search.set.math.MathSet;

public abstract class MathSetTestBase<T extends MathSet<Boolean>> {
	
	private final Boolean[] universe = { true, false };
	
	private final MathSet<Boolean> empty;
	private final MathSet<Boolean> justTrue;
	private final MathSet<Boolean> justFalse;
	private final MathSet<Boolean> full;
	
	// This plus some testcases implicitely test add
	public MathSetTestBase() {
		empty = instantiate(universe);
		
		justTrue = instantiate(universe);
		justTrue.add(true);
		
		justFalse = instantiate(universe);
		justFalse.add(false);
		
		full = instantiate(universe);
		full.add(true);
		full.add(false);
	}
	
	protected abstract T instantiate(Boolean[] universe);
	
	@Test
	public void testSize() {
		assertEquals(0, empty.size());
		assertEquals(1, justTrue.size());
		assertEquals(1, justFalse.size());
		assertEquals(2, full.size());
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(empty.isEmpty());
		assertFalse(justTrue.isEmpty());
		assertFalse(justFalse.isEmpty());
		assertFalse(full.isEmpty());
	}
	
	@Test
	public void testContainsEmpty() {
		assertFalse(empty.contains(true));
		assertFalse(empty.contains(false));
	}
	
	@Test
	public void testContainsFull() {
		assertTrue(full.contains(true));
		assertTrue(full.contains(false));
	}
	
	@Test
	public void testContainsOnlyOne() {
		assertTrue(justTrue.contains(true));
		assertFalse(justTrue.contains(false));
	}
	
	@Test
	public void testDelete() {
		MathSet<Boolean> set = empty.complement();
		set.delete(true);
		assertFalse(set.contains(true));
		assertEquals(1, set.size());
	}
	
	@Test
	public void testUnion() {
		MathSet<Boolean> union = justTrue.union(justFalse);
		assertEquals(2, union.size());
	}
	
	@Test
	public void testEmptyUnion() {
		MathSet<Boolean> union = justTrue.union(empty);
		assertTrue(union.contains(true));
	}
	
	@Test
	public void testUnionCollision() {
		MathSet<Boolean> union = full.union(justTrue);
		assertTrue(union.contains(true));
		assertTrue(union.contains(false));
	}
	
	@Test
	public void testIntersection() {
		MathSet<Boolean> intersection = full.intersection(justTrue);
		assertTrue(intersection.contains(true));
		assertFalse(intersection.contains(false));
	}
	
	@Test
	public void testEmptyIntersection() {
		MathSet<Boolean> intersection = full.intersection(empty);
		assertTrue(intersection.isEmpty());
	}
	
	@Test
	public void testComplement() {
		MathSet<Boolean> complement = full.complement();
		assertTrue(complement.isEmpty());
	}
	
	@Test
	public void testComplementEmpty() {
		MathSet<Boolean> complement = empty.complement();
		assertEquals(2, complement.size());
	}
	
	@Test
	public void testComplementJustTrue() {
		MathSet<Boolean> complement = justTrue.complement();
		assertTrue(complement.contains(false));
		assertFalse(complement.contains(true));
	}

}
