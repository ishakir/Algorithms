package bag;

import java.util.Iterator;

public class LinkedListBag<Item> implements Bag<Item> {

	private Node first;
	private int N;
	
	private class Node {
		Item item;
		Node next;
	}
	
	@Override
	public void add(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}

	@Override public boolean isEmpty() { return first == null; }
	@Override public int size() { return N; }

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		
		public boolean hasNext() {
			return current != null;
		}
		
		public void remove() {}
		
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

}
