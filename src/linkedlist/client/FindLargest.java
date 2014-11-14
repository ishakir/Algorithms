package linkedlist.client;

import linkedlist.Node;

public class FindLargest {

	private Node<Integer> first;
	
	public FindLargest(Node<Integer> first) {
		this.first = first;
	}
	
	public Integer maxLoop() {
		int currentMax = 0;
		Node<Integer> next = first;
		while(next != null) {
			if(next.item > currentMax) {
				currentMax = next.item;
			}
			next = next.next;
		}
		return currentMax;
	}
	
	public Integer maxRecurse() {
		return maxRecurseInner(0, first);
	}
	
	private Integer maxRecurseInner(Integer currentMax, Node<Integer> next) {
		if(next == null) {
			return currentMax;
		} else if(next.item > currentMax) {
			return maxRecurseInner(next.item, next.next);
		} else {
			return maxRecurseInner(currentMax, next.next);
		}
	}
}
