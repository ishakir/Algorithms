package sort.priorityqueue.test;

import sort.priorityqueue.UnorderedLinkedListPriorityQueue;

public class UnorderedLinkedListPriorityQueueTest extends
		PriorityQueueTestBase<UnorderedLinkedListPriorityQueue<Integer>> {

	@Override
	protected UnorderedLinkedListPriorityQueue<Integer> instantiate() {
		return new UnorderedLinkedListPriorityQueue<Integer>();
	}

}
