package search.set.ordered;

import basic.queue.LinkedListQueue;
import basic.queue.Queue;

public class BinarySearchSet<Key extends Comparable<Key>> implements OrderedSet<Key> {
	
	private Key[] keys;
	private int N;
	
	public BinarySearchSet(int capacity) {
		keys = (Key[]) new Comparable[capacity];
	}
	
	@Override
	public void add(Key key) {
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0) {
			keys[i] = key;
			return;
		}
		for(int j = N; j > i; j--) {
			keys[j] = keys[j - 1];
		}
		keys[i] = key;
		N++;
	}

	@Override
	public void delete(Key key) {
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0) {
			keys[i] = null;
			N--;
			for(int j = N; j > i; j--) {
				keys[j] = keys[j - 1];
			}
		}
	}

	@Override
	public boolean contains(Key key) {
		if(isEmpty()) return false;
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0) return true;
		else									 return false;
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public int size() {
		return N;
	}

	@Override
	public Key min() {
		return keys[0];
	}

	@Override
	public Key max() {
		return keys[N - 1];
	}

	@Override
	public Key floor(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key ceil(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int rank(Key key) {
		int lo = 0, hi = N - 1;
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if(cmp < 0) {
				hi = mid - 1;
			} else if(cmp > 0) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return lo;
	}

	@Override
	public Key select(int k) {
		return keys[k];
	}

	@Override
	public void deleteMin() {
		delete(min());
	}

	@Override
	public void deleteMax() {
		delete(max());
	}

	@Override
	public int size(Key lo, Key hi) {
		if(hi.compareTo(lo) < 0) {
			return 0;
		} else if(contains(hi)) {
			return rank(hi) - rank(lo) + 1;
		} else {
			return rank(hi) - rank(lo);
		}
	}

	@Override
	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> q = new LinkedListQueue<Key>();
		for(int i = rank(lo); i < rank(hi); i++) {
			q.enqueue(keys[i]);
		}
		if(contains(hi)) {
			q.enqueue(keys[rank(hi)]);
		}
		return q;
	}

}
