package sort.priorityqueue;

public class UnorderedLinkedListPriorityQueue<Key extends Comparable<Key>> implements MaxPriorityQueue<Key> {
	
	private class Node<Item> {
		public Item item;
		public Node<Item> next;
		public String toString() { if(next == null) return item.toString(); else return item + "->"; }
	}
	
	private Node<Key> first;

	@Override
	public void insert(Key v) {
		Node<Key> newFirst = new Node<Key>();
		newFirst.item = v;
		newFirst.next = first;
		first = newFirst;
	}

	@Override
	public Key max() {
		Node<Key> largest = first;
		Node<Key> next = first;
		while(next != null) {
			if(!less(next.item, largest.item)) {
				largest = next;
			}
			next = next.next;
		}
		
		return largest.item;
	}

	@Override
	public Key delMax() {
		// Use these to keep track of the largest keys
		Node<Key> previousBeforeLargest = null;
		Node<Key> largest = first;
		
		// Use these to keep track of the current iterators
		Node<Key> previous = null;
		Node<Key> next = first;
		
		while(next != null) {
			if(!less(next.item, largest.item)) {
				previousBeforeLargest = previous;
				largest = next;
			}
			previous = next;
			next = next.next;
		}
		
		// Remove the largest element from the list
		if(previousBeforeLargest == null) {
			first = first.next;
		} else {
			previousBeforeLargest.next = largest.next;
		}
		
		return largest.item;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public int size() {
		int counter = 0;
		Node<Key> next = first;
		while(next != null) {
			next = next.next;
			counter++;
		}
		return counter;
	}
	
	protected boolean less(Key v, Key w) {
		return v.compareTo(w) < 0;
	}
	
}
