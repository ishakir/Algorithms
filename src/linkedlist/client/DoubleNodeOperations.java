package linkedlist.client;

import linkedlist.DoubleNode;

public class DoubleNodeOperations<Item> {
	
	public void insertAtBeginning(Item item, DoubleNode<Item> current) {
		if(current.getPrevious() == null) {
			current.setPrevious(new DoubleNode<Item>(item));
		} else {
			insertAtBeginning(item, current.getPrevious());
		}
	}
	
	public void insertAtEnd(Item item, DoubleNode<Item> current) {
		if(current.getNext() == null) {
			current.setNext(new DoubleNode<Item>(item));
		} else {
			insertAtEnd(item, current.getNext());
		}
	}
	
	public void removeFromBeginning(DoubleNode<Item> current) {
		if(current.getPrevious() == null) {
			current.getNext().detachPrevious();
		} else {
			removeFromBeginning(current.getPrevious());
		}
	}
	
	public void removeFromEnd(DoubleNode<Item> current) {
		if(current.getNext() == null) {
			current.getPrevious().detachNext();
		} else {
			removeFromEnd(current.getNext());
		}
	}
	
	public void insertBefore(Item item, DoubleNode<Item> current) {
		DoubleNode<Item> previous = current.getPrevious();
		new DoubleNode<Item>(item, previous, current);
	}
	
	public void insertAfter(Item item, DoubleNode<Item> current) {
		DoubleNode<Item> next = current.getNext();
		new DoubleNode<Item>(item, current, next);
	}
	
	public void remove(DoubleNode<Item> current) {
		DoubleNode<Item> previous = current.getPrevious();
		DoubleNode<Item> next = current.getNext();
		current.detachPrevious();
		current.detachNext();
		previous.setNext(next);
	}
	
}
