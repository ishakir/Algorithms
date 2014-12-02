package sort.priorityqueue.test;

import sort.priorityqueue.HeapMaxPriorityQueue;

public class HeapMaxPriorityQueueTest extends PriorityQueueTestBase<HeapMaxPriorityQueue<Integer>> {

	@Override
	protected HeapMaxPriorityQueue<Integer> instantiate() {
		return new HeapMaxPriorityQueue<Integer>(10);
	}

}
