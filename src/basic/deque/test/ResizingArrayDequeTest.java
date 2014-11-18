package basic.deque.test;

import basic.deque.ResizingArrayDeque;

public class ResizingArrayDequeTest extends DequeTestBase<ResizingArrayDeque<Integer>>{

	@Override
	protected ResizingArrayDeque<Integer> createInstance() {
		return new ResizingArrayDeque<Integer>(10);
	}

}
