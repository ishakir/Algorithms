package search.symboltable.ordered;

import basic.queue.LinkedListQueue;
import basic.queue.Queue;

public class OrderedSequentialSearchSymbolTable<Key extends Comparable<Key>, Value> extends AbstractOrderedSymbolTable<Key, Value>{
	
	private class Node {
		Key key;
		Value value;
		Node next;
		public String toString() { if(next == null) return key.toString(); else return key + "->" + next.toString(); }
	}
	
	private Node first;
	private int size;
	
	@Override
	public Key min() {
		return first.key;
	}

	@Override
	public Key max() {
		Node next = first;
		while(next.next != null) {
			next = next.next;
		}
		return next.key;
	}

	@Override
	public Key floor(Key key) {
		return floorRecur(key, first);
	}
	
	private Key floorRecur(Key key, Node curr) {
		if(curr == null) {
			return null;
		} else if(curr.next == null || curr.next.key.compareTo(key) > 0) {
			return curr.key;
		} else {
			return floorRecur(key, curr.next);
		}
	}

	@Override
	public Key ceil(Key key) {
		return ceilRecur(key, first);
	}
	
	public Key ceilRecur(Key key, Node curr) {
		if(curr == null) {
			return null;
		} else if(curr.key.compareTo(key) > 0) {
			return curr.key;
		} else {
			return ceilRecur(key, curr.next);
		}
	}

	@Override
	public int rank(Key key) {
		return rankRecur(key, first, 0);
	}
	
	private int rankRecur(Key key, Node curr, int count) {
		if(curr == null) {
			return -1;
		} else if(curr.key.equals(key)) {
			return count;
		} else {
			return rankRecur(key, curr.next, ++count);
		}
	}

	@Override
	public Key select(int k) {
		return selectRecur(first, k);
	}
	
	private Key selectRecur(Node curr, int count) {
		if(curr == null) {
			return null;
		} else if(count == 0) {
			return curr.key;
		} else {
			return selectRecur(curr.next, --count);
		}
	}

	@Override
	public Iterable<Key> keys(Key lo, final Key hi) {
		Queue<Key> q = new LinkedListQueue<Key>();
		
		Node current = first;
		System.out.println("Examining "+current.key);
		while(current != null) {
			if(current.key.compareTo(lo) >= 0 && current.key.compareTo(hi) <= 0) {
				q.enqueue(current.key);
			}
			current = current.next;
		}
		
		return q;
	}

	@Override
	public void put(Key key, Value val) {
		if(val == null) {
			removeRecur(key, null, first);
		} else {
			Node newNode = new Node();
			newNode.key = key;
			newNode.value = val;
			putRecur(null, first, newNode);
		}
	}
	
	private void removeRecur(Key key, Node prev, Node curr) {
		if(key.equals(curr.key)) {
			if(prev == null) {
				first = null;
			} else {
				prev.next = curr.next;
			}
			size--;
		} else if(curr.next != null) {
			removeRecur(key, curr, curr.next);
		}
	}
	
	private void putRecur(Node prev, Node curr, Node newNode) {
		if(prev == null && curr == null) {
			first = newNode;
			size++;
		} else if (curr == null) {
			prev.next = newNode;
			size++;
		} else if (prev == null && curr.key.compareTo(newNode.key) > 0) {
			newNode.next = curr;
			first = newNode;
			size++;
		} else if(curr.key.compareTo(newNode.key) > 0) {
			prev.next = newNode;
			newNode.next = curr;
			size++;
		} else if(curr.key.equals(newNode.key)) {
			curr.value = newNode.value;
		} else {
			putRecur(curr, curr.next, newNode);
		}
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
		// TODO Auto-generated method stub
		return null;
	}

}
