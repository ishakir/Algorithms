package basic.queue.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import basic.queue.Queue;

public abstract class QueueTestBase<T extends Queue<Integer>> {
	
	protected abstract T createInstance();
	private int[] lotsOfValues;
	
	public QueueTestBase() {
		lotsOfValues = new int[50];
		for(int i = 0 ; i < 50; i++) {
			lotsOfValues[i] = i;
		}
	}
	
	@Test
	public void testAddAndRemoveElement() {
		Queue<Integer> q = createInstance();
		q.enqueue(3);
		assertEquals(new Integer(3), q.dequeue());
	}
	
	@Test
	public void testNewIsEmpty() {
		Queue<Integer> q = createInstance();
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void testAddingIncreasesSize() {
		Queue<Integer> q = createInstance();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		assertEquals(3, q.size());
	}
	
	@Test
	public void testRemovingDecreasesSize() {
		Queue<Integer> q = createInstance();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		assertEquals(2, q.size());
	}
	
	@Test
	public void addingAFewElementsReturnsInOrderAdded() {
		Queue<Integer> q = createInstance();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		assertEquals(new Integer(1), q.dequeue());
		assertEquals(new Integer(2), q.dequeue());
		assertEquals(new Integer(3), q.dequeue());
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void addRemoveDequeueIsNull() {
		Queue<Integer> q = createInstance();
		q.enqueue(1);
		q.dequeue();
		assertNull(q.dequeue());
	}
	
	@Test
	public void addLotsOfValuesLeftRetrieveRight() {
		Queue<Integer> q = createInstance();
		
		for(int i = 0; i < lotsOfValues.length; i++) {
			q.enqueue(i);
		}
		
		for(int i = 0; i < lotsOfValues.length; i++) {
			assertEquals(new Integer(i), q.dequeue());
		}
	}
	
}
