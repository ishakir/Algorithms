package search;

import java.util.Iterator;


public class SequentialSearchSymbolTable<Key, Value> extends
		AbstractSymbolTable<Key, Value> {

	private int size;
	private Node first;
	
	private class Node {
		Key key;
		Value value;
		Node next;
		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	@Override
	public void put(Key key, Value val) {
		for(Node x = first; x != null; x = x.next) {
			if(key.equals(x.key)) {
				x.value = val;
				if(val == null) {
					size--;
				}
			}
		}
		first = new Node(key, val, first);
		size++;
	}

	@Override
	public Value get(Key key) {
		for(Node x = first; x != null; x = x.next) {
			if(key.equals(x.key)) {
				return x.value;
			}
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterable<Key> keys() {
		return new KeyIterator();
	}
	
	private class KeyIterator implements Iterable<Key> {
		@Override
		public Iterator<Key> iterator() {
			return new Iterator<Key>() {
				
				private Node next = first;
				
				@Override
				public boolean hasNext() {
					return first.next != null;
				}

				@Override
				public Key next() {
					next = next.next;
					return next.key;
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}
				
			};
		}
	}

}
