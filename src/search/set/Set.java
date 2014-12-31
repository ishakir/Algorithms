package search.set;

public interface Set<Key> {

	void add(Key key);
	void delete(Key key);
	boolean contains(Key key);
	boolean isEmpty();
	int size();
	String toString();
	
}
