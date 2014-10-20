package linkedlist.client;

import linkedlist.Node;

public class RemoveLastNode<Item> {
	private Node<Item> first;
	
	public RemoveLastNode(Node<Item> first) {
		this.first = first;
	}
	
	public Node<Item> remove() {
		Node<Item> previous = first;
		Node<Item> current = first.next;
		while(current != null) {
			if(current.next == null) {
				previous.next = null;
			}
			previous = current;
			current = current.next;
		}
		return first;
	}
}
