package sort.priorityqueue.test;

import sort.priorityqueue.OrderedLinkedListPriorityQueue;

public class OrderedLinkedListPriorityQueueTest extends
		PriorityQueueTestBase<OrderedLinkedListPriorityQueue<Integer>> {

	@Override
	protected OrderedLinkedListPriorityQueue<Integer> instantiate() {
		return new OrderedLinkedListPriorityQueue<Integer>();
	}

}
