package sort.priorityqueue.test;

import sort.priorityqueue.OrderedArrayPriorityQueue;

public class OrderedArrayPriorityQueueTest extends PriorityQueueTestBase<OrderedArrayPriorityQueue<Integer>> {

	@Override
	protected OrderedArrayPriorityQueue<Integer> instantiate() {
		return new OrderedArrayPriorityQueue<Integer>(20);
	}

}
