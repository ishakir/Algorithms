package basic.queue.test;

import basic.queue.CircularLinkedListQueue;

public class CircularLinkedListQueueTest extends QueueTestBase<CircularLinkedListQueue<Integer>> {

	@Override
	protected CircularLinkedListQueue<Integer> createInstance() {
		return new CircularLinkedListQueue<Integer>();
	}

}
