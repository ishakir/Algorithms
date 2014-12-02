package sort.priorityqueue.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import sort.priorityqueue.MaxPriorityQueue;

public abstract class PriorityQueueTestBase<T extends MaxPriorityQueue<Integer>> {
	
	protected abstract T instantiate();
	
	@Test
	public void testEmptyPQisEmpty() {
		assertTrue(instantiate().isEmpty());
	}
	
	@Test
	public void testAddRemoveIsStillEmpty() {
		MaxPriorityQueue<Integer> pq = instantiate();
		pq.insert(5);
		pq.delMax();
		assertTrue(pq.isEmpty());
	}
	
	@Test
	public void testSizeIncreases() {
		MaxPriorityQueue<Integer> pq = instantiate();
		pq.insert(1);
		pq.insert(2);
		pq.insert(3);
		assertEquals(3, pq.size());
	}
	
	@Test
	public void testSizeTrackedOnInsertRemove() {
		MaxPriorityQueue<Integer> pq = instantiate();
		pq.insert(1);
		pq.insert(2);
		pq.insert(3);
		pq.delMax();
		pq.insert(4);
		pq.insert(5);
		pq.delMax();
		pq.delMax();
		assertEquals(2, pq.size());
	}
	
	@Test
	public void testResultsReturnedInPriorityOrder() {
		MaxPriorityQueue<Integer> pq = instantiate();
		for(int i = 0; i < 10; i++) {
			pq.insert(i);
		}
		for(int i = 9; i >= 0; i--) {
			assertEquals(new Integer(i), pq.delMax());
		}
	}
	
	@Test
	public void testMaxReturnsMax() {
		MaxPriorityQueue<Integer> pq = instantiate();
		pq.insert(1);
		pq.insert(2);
		pq.insert(3);
		assertEquals(new Integer(3), pq.max());
	}
	
	@Test
	public void testMaxDoesntDecreaseSize() {
		MaxPriorityQueue<Integer> pq = instantiate();
		pq.insert(1);
		pq.insert(2);
		pq.insert(3);
		pq.max();
		assertEquals(3, pq.size());
	}
	
}
