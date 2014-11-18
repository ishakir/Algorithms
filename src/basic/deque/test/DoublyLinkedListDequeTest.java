package basic.deque.test;

import basic.deque.DoublyLinkedListDeque;

public class DoublyLinkedListDequeTest extends DequeTestBase<DoublyLinkedListDeque<Integer>> {

	@Override
	protected DoublyLinkedListDeque<Integer> createInstance() {
		return new DoublyLinkedListDeque<Integer>();
	}

}
