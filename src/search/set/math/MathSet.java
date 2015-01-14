package search.set.math;

public interface MathSet<Key> {

	void add(Key key);
	MathSet<Key> complement();
	MathSet<Key> union(MathSet<Key> a);
	MathSet<Key> intersection(MathSet<Key> a);
	void delete(Key key);
	boolean contains(Key key);
	boolean isEmpty();
	int size();
	
}
