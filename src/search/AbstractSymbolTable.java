package search;

public abstract class AbstractSymbolTable<Key, Value> implements SymbolTable<Key, Value> {
	
	@Override
	public void delete(Key key) {
		put(key, null);
	}
	
	@Override
	public boolean contains(Key key) {
		return get(key) != null;
	}
	
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
	
}
