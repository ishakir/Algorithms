package linkedlist.client;

import linkedlist.Node;

public class Find<Item> {

	private Node<Item> first;
	
	public Find(Node<Item> first) {
		this.first = first;
	}
	
	public boolean find(Item item) {
		Node<Item> next = first;
		while(next != null) {
			if(next.item.equals(item)) {
				return true;
			}
			next = next.next;
		}
		return false;
	}
	
}
