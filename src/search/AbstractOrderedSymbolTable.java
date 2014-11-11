package search;

public abstract class AbstractOrderedSymbolTable<Key extends Comparable<Key>, Value>
		extends AbstractSymbolTable<Key, Value> implements
		OrderedSymbolTable<Key, Value> {

	@Override
	public void deleteMin() {
		delete((min()));
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
	
}
