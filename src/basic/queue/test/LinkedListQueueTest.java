package basic.queue.test;

import basic.queue.LinkedListQueue;

public class LinkedListQueueTest extends QueueTestBase<LinkedListQueue<Integer>> {

	@Override
	protected LinkedListQueue<Integer> createInstance() {
		return new LinkedListQueue<Integer>();
	}

}
