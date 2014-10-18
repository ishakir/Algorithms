package linkedlist.client;

import linkedlist.Node;

public class RemoveAfter<Item> {
	
	private Node<Item> first;
	
	public RemoveAfter(Node<Item> first) {
		this.first = first;
	}
	
	public Node<Item> removeAfter() {
		Node<Item> toRemove = first.next;
		if(toRemove == null) {
			return first;
		}
		first.next = toRemove.next;
		return first;
	}
	
}
