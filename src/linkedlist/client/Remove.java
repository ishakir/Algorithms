package linkedlist.client;

import linkedlist.Node;

public class Remove {

	private Node<String> first;

	public Remove(Node<String> first) {
		this.first = first;
	}

	public Node<String> remove(String key) {
		while (first != null && first.item.equals(key)) {
			first = first.next;
		}

		Node<String> beforeNext = null;
		Node<String> next = first;

		while (next != null) {
			if (next.item.equals(key)) {
				beforeNext.next = next.next;
			} else {
				beforeNext = next;
			}
			next = next.next;
		}

		return first;
	}

}
