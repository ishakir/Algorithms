package basic.deque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import basic.deque.Deque;

public abstract class DequeTestBase<T extends Deque<Integer>> {
	
	protected abstract T createInstance();
	private int[] lotsOfValues;
	
	public DequeTestBase() {
		lotsOfValues = new int[50];
		for(int i = 0 ; i < 50; i++) {
			lotsOfValues[i] = i;
		}
	}
	
	@Test
	public void testEmptyDequeIsEmpty() {
		T deque = createInstance();
		assertTrue(deque.isEmpty());
	}
	
	@Test
	public void testNonEmptyLeftDequeIsNotEmpty() {
		T deque = createInstance();
		deque.pushLeft(1);
		assertFalse(deque.isEmpty());
	}
	
	@Test
	public void testNonEmptyRightDequeIsNotEmpty() {
		T deque = createInstance();
		deque.pushRight(1);
		assertFalse(deque.isEmpty());
	}
	
	@Test
	public void testCanAddLeftAndRetrieveLeft() {
		T deque = createInstance();
		deque.pushLeft(1);
		assertEquals(new Integer(1), deque.popLeft());
		assertTrue(deque.isEmpty());
	}
	
	@Test
	public void testCanAddRightAndRetrieveRight() {
		T deque = createInstance();
		deque.pushRight(1);
		assertEquals(new Integer(1), deque.popRight());
		assertTrue(deque.isEmpty());
	}
	
	@Test
	public void testCanAddLeftAndRetrieveRight() {
		T deque = createInstance();
		deque.pushLeft(1);
		assertEquals(new Integer(1), deque.popRight());
		assertTrue(deque.isEmpty());
	}
	
	@Test
	public void testCanAddRightAndRetrieveLeft() {
		T deque = createInstance();
		deque.pushRight(1);
		assertEquals(new Integer(1), deque.popRight());
		assertTrue(deque.isEmpty());
	}
	
	@Test
	public void testWorksAsStackOnRight() {
		T deque = createInstance();
		deque.pushRight(1);
		deque.pushRight(2);
		assertEquals(new Integer(2), deque.popRight());
		assertEquals(1, deque.size());
	}
	
	@Test
	public void testWorksAsStackOnLeft() {
		T deque = createInstance();
		deque.pushRight(1);
		deque.pushLeft(2);
		assertEquals(new Integer(2), deque.popLeft());
		assertEquals(1, deque.size());
	}
	
	@Test
	public void testWorksAsAQueueLeftToRight() {
		T deque = createInstance();
		deque.pushLeft(1);
		deque.pushLeft(2);
		assertEquals(new Integer(1), deque.popRight());
		assertEquals(1, deque.size());
	}
	
	@Test
	public void testWorksAsAQueueRightToLeft() {
		T deque = createInstance();
		deque.pushRight(1);
		deque.pushRight(2);
		assertEquals(new Integer(1), deque.popLeft());
		assertEquals(1, deque.size());
	}
	
	@Test
	public void addLotsOfValuesLeftRetrieveLeft() {
		T deque = createInstance();
		
		for(int i = 0; i < lotsOfValues.length; i++) {
			deque.pushLeft(i);
		}
		
		for(int i = lotsOfValues.length - 1; i >= 0; i--) {
			assertEquals(new Integer(i), deque.popLeft());
		}
	}
	
	@Test
	public void addLotsOfValuesRightRetrieveRight() {
		T deque = createInstance();
		
		for(int i = 0; i < lotsOfValues.length; i++) {
			deque.pushRight(i);
		}
		
		for(int i = lotsOfValues.length - 1; i >= 0; i--) {
			assertEquals(new Integer(i), deque.popRight());
		}
	}
	
	@Test
	public void addLotsOfValuesLeftRetrieveRight() {
		T deque = createInstance();
		
		for(int i = 0; i < lotsOfValues.length; i++) {
			deque.pushLeft(i);
		}
		
		for(int i = 0; i < lotsOfValues.length; i++) {
			assertEquals(new Integer(i), deque.popRight());
		}
	}
	
	@Test
	public void addLotsOfValuesRightRetrieveLeft() {
		T deque = createInstance();
		
		for(int i = 0; i < lotsOfValues.length; i++) {
			deque.pushRight(i);
		}
		
		for(int i = 0; i < lotsOfValues.length; i++) {
			assertEquals(new Integer(i), deque.popLeft());
		}
	}
	

}
