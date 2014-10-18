package linkedlist.client;

import linkedlist.Node;

public class InsertAfter<Item> {
	
	private Node<Item> first;
	
	public InsertAfter(Node<Item> first) {
		this.first = first;
	}
	
	public Node<Item> insertAfter(Node<Item> next) {
		Node<Item> firstNext = first.next;
		first.next = next;
		next.next = firstNext;
		return first;
	}
	
}
