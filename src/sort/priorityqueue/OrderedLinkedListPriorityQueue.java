package sort.priorityqueue;

public class OrderedLinkedListPriorityQueue<Key extends Comparable<Key>> implements MaxPriorityQueue<Key> {
	
	private class Node<Item> {
		public Item item;
		public Node<Item> next;
		public String toString() { if(next == null) return item.toString(); else return item + "->"; }
	}
	
	private Node<Key> first;

	@Override
	public void insert(Key v) {
		
		if(first == null) {
			first = new Node<Key>();
			first.item = v;
			return;
		}
		
		// Find the first value that the inserted key is larger than
		// put this one between that and the previous one
		Node<Key> previousFromNext = null;
		Node<Key> next = first;
		
		while(next != null && less(v, next.item)) {
			previousFromNext = next;
			next = next.next;
		}
		
		Node<Key> toInsert = new Node<Key>();
		toInsert.item = v;
		toInsert.next = next;
		if(previousFromNext == null) {
			first = toInsert;
		} else {
			previousFromNext.next = next;
		}
	}

	@Override
	public Key max() {
		return first.item;
	}

	@Override
	public Key delMax() {
		Key toReturn = first.item;
		first = first.next;
		return toReturn;
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
	
	public void show() {
		System.out.println(first);
	}
	
	public static void main(String[] args) {
		OrderedLinkedListPriorityQueue<Integer> mpq = new OrderedLinkedListPriorityQueue<Integer>();
		mpq.show();
		mpq.insert(3);
		mpq.show();
		mpq.insert(7);
		mpq.show();
		mpq.insert(20);
		mpq.show();
		mpq.insert(2);
		mpq.show();
		System.out.println(mpq.delMax());
		mpq.show();
		System.out.println(mpq.delMax());
		mpq.show();
		System.out.println(mpq.delMax());
		mpq.show();
		System.out.println(mpq.delMax());
		mpq.show();
	}
	
}
