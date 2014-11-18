package linkedlist.client;

import linkedlist.Node;

public class Reverse<Item> {

	private Node<Item> first;
	
	public Reverse(Node<Item> first) {
		this.first = first;
	}
	
	public Node<Item> iterativeReverse() {
		Node<Item> previous = null;
		Node<Item> current = first;
		while(current != null) {
			Node<Item> next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}
	
	public Node<Item> recursiveReverse() {
		return recursiveInner(first);
	}
	
	private Node<Item> recursiveInner(Node<Item> first) {
		if(first == null) return null;
		if(first.next == null) return first;
		Node<Item> second = first.next;
		Node<Item> rest = recursiveInner(second);
		second.next = first;
		return rest; 
	}
	
}
