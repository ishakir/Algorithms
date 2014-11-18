package basic.queue.test;

import basic.queue.ResizingArrayQueue;

public class ResizingArrayQueueTest extends QueueTestBase<ResizingArrayQueue<Integer>> {

	@Override
	protected ResizingArrayQueue<Integer> createInstance() {
		return new ResizingArrayQueue<Integer>(10);
	}

}
