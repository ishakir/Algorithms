package sort.priorityqueue.test;

import sort.priorityqueue.UnorderedArrayPriorityQueue;

public class UnorderedArrayPriorityQueueTest extends PriorityQueueTestBase<UnorderedArrayPriorityQueue<Integer>> {

	@Override
	protected UnorderedArrayPriorityQueue<Integer> instantiate() {
		return new UnorderedArrayPriorityQueue<Integer>(20);
	}

}
