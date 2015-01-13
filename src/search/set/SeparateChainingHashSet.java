package search.set;

public class SeparateChainingHashSet<Key> implements Set<Key> {
	
	private int noBuckets;
	private Node<Key>[] buckets;
	private int size;
	
	private class Node<Item> {
		Item key;
		Node<Item> next;
	}
	
	public SeparateChainingHashSet(int noBuckets) {
		this.noBuckets = noBuckets;
		buckets = (Node<Key>[]) new Node[noBuckets];
	}
	
	@Override
	public void add(Key key) {
		Node<Key> first = buckets[hash(key)];
		if(first == null) {
			first = new Node<Key>();
			first.key = key;
			buckets[hash(key)] = first;
		} else {
			Node<Key> last = first;
			while(last.next != null) {
				if(last.key.equals(key)) {
					return;
				}
				last = last.next;
			}
			Node<Key> newNode = new Node<Key>();
			newNode.key = key;
			last.next = newNode;
		}
		size++;
	}

	@Override
	public void delete(Key key) {
		Node<Key> prev = null;
		Node<Key> next = buckets[hash(key)];
		while(next != null) {
			if(next.key.equals(key)) {
				if(prev == null) {
					buckets[hash(key)] = null;
				} else {
					prev.next = next.next;
					size--;
					return;
				}
			}
			prev = next;
			next.next = next;
		}
	}

	@Override
	public boolean contains(Key key) {
		Node<Key> next = buckets[hash(key)];
		while(next != null) {
			if(next.key.equals(key)) {
				return true;
			}
			next = next.next;
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
	
	private int hash(Key key) {
		return key.hashCode() % noBuckets;
	}

}
