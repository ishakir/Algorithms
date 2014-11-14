package basic.queue.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import basic.queue.CircularLinkedListQueue;
import basic.queue.Queue;

public class CircularLinkedListQueueTest {

	@Test
	public void testAddAndRemoveElement() {
		Queue<Integer> q = new CircularLinkedListQueue<Integer>();
		q.enqueue(3);
		assertEquals(new Integer(3), q.dequeue());
	}
	
	@Test
	public void testNewIsEmpty() {
		Queue<Integer> q = new CircularLinkedListQueue<Integer>();
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void testAddingIncreasesSize() {
		Queue<Integer> q = new CircularLinkedListQueue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		assertEquals(3, q.size());
	}
	
	@Test
	public void testRemovingDecreasesSize() {
		Queue<Integer> q = new CircularLinkedListQueue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		assertEquals(2, q.size());
	}
	
	@Test
	public void addingAFewElementsReturnsInOrderAdded() {
		Queue<Integer> q = new CircularLinkedListQueue<Integer>();
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
		Queue<Integer> q = new CircularLinkedListQueue<Integer>();
		q.enqueue(1);
		q.dequeue();
		assertNull(q.dequeue());
	}

}
