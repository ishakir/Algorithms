package search.set.ordered;

import search.set.Set;

public interface OrderedSet<Key extends Comparable<Key>> extends Set<Key> {

	Key min();
	Key max();
	Key floor(Key key);
	Key ceil(Key key);
	int rank(Key key);
	Key select(int k);
	void deleteMin();
	void deleteMax();
	int size(Key lo, Key hi);
	Iterable<Key> keys(Key lo, Key hi);
	
}
