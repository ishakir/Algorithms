package linkedlist.client;

import linkedlist.Node;

public class RemoveKthNode<Item> {

	public Node<Item> first;
	
	public RemoveKthNode(Node<Item> first) {
		this.first = first;
	}
	
	public Node<Item> removeKth(int i) {
		Node<Item> first = this.first;
		Node<Item> next = first.next;
		if(i == 1) {
			return next;
		} else {
			int count = 2;
			while(count < i && next != null) {
				first = next;
				next = next.next;
				count++;
			}
			if(next == null) {
				first.next = null;
				return this.first;
			}
			first.next = next.next;
			return this.first;
		}
		
	}
	
}
