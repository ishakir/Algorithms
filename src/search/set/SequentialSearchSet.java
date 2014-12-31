package search.set;

public class SequentialSearchSet<Key> implements Set<Key> {

	private Node first;
	private int size;
	
	private class Node {
		Key key;
		Node next;
		Node(Key key, Node node) { this.key = key; this.next = node; }
	}
	
	@Override
	public void add(Key key) {
		for(Node x = first; x != null; x = x.next) {
			if(x.key.equals(key)) {
				return;
			}
		}
		first = new Node(key, first);
		size++;
	}

	@Override
	public void delete(Key key) {
		Node prev = null;
		Node next = first;
		while(next != null) {
			if(next.key.equals(key)) {
				size--;
				if(prev == null) {
					first = null;
				} else {
					prev.next = next.next;
				}
				return;
			}
			prev = next;
			next = next.next;
		}
	}

	@Override
	public boolean contains(Key key) {
		for(Node x = first; x != null; x = x.next) {
			if(x.key.equals(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

}
