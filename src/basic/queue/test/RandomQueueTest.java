package basic.queue.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import basic.queue.RandomQueue;

public class RandomQueueTest {
	
	@Test
	public void emptyRandomQueueIsEmpty() {
		assertTrue(new RandomQueue<Integer>().isEmpty());
	}
	
	@Test
	public void addRemoveLeavesRandomQueueEmpty() {
		RandomQueue<Integer> rq = new RandomQueue<Integer>();
		rq.enqueue(1);
		rq.dequeue();
		assertTrue(rq.isEmpty());
	}
	
	@Test
	public void canEnqueueDequeueManyItems() {
		RandomQueue<Integer> rq = new RandomQueue<Integer>();
		for(int i = 0; i < 1000; i++) {
			rq.enqueue(i);
		}
		for(int i = 0; i < 1000; i++) {
			rq.dequeue();
		}
	}

}
