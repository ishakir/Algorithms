package search;

import basic.queue.LinkedListQueue;
import basic.queue.Queue;

public class BinarySearchSymbolTable<Key extends Comparable<Key>, Value>
		extends AbstractOrderedSymbolTable<Key, Value> {
	
	private Key[] keys;
	private Value[] values;
	private int N;
	
	public BinarySearchSymbolTable(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		values = (Value[]) new Object[capacity];
	}
	
	@Override
	public Key min() {
		return keys[0];
	}

	@Override
	public Key max() {
		return keys[N-1];
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

	@Override
	public void put(Key key, Value val) {
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0) {
			values[i] = val;
			if(val == null) N--;
			return;
		}
		for(int j = N; j > i; j--) {
			keys[j] = keys[j-1];
			values[j]  = values[j-1];
		}
		keys[i] = key;
		values[i] = val;
		N++;
	}

	@Override
	public Value get(Key key) {
		if(isEmpty()) return null;
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0) return values[i];
		else                                     return null;
	}

	@Override
	public int size() {
		return N;
	}

	@Override
	public Iterable<Key> keys() {
		// TODO Auto-generated method stub
		return null;
	}

}
