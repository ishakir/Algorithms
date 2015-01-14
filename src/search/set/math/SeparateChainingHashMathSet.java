package search.set.math;

import search.symboltable.SeparateChainingHashSymbolTable;

public class SeparateChainingHashMathSet<Key> implements MathSet<Key> {
	
	private final SeparateChainingHashSymbolTable<Key, Boolean> keys;
	private int size;
	private final Key[] universe;
	
	public SeparateChainingHashMathSet(Key[] universe) {
		keys = new SeparateChainingHashSymbolTable<Key, Boolean>();
		this.universe = universe;
		for(Key key : universe) {
			 keys.put(key, false);
		}
	}
	
	@Override
	public void add(Key key) {
		if(keys.contains(key) && !keys.get(key)) {
			keys.put(key, true);
			size++;
		}
	}

	@Override
	public MathSet<Key> complement() {
		MathSet<Key> newSet = new SeparateChainingHashMathSet<Key>(universe);
		for(Key key : universe) {
			if(!contains(key)) {
				newSet.add(key);
			}
		}
		return newSet;
	}

	@Override
	public MathSet<Key> union(MathSet<Key> a) {
		MathSet<Key> newSet = new SeparateChainingHashMathSet<Key>(universe);
		for(Key key : universe) {
			if(contains(key) || a.contains(key)) {
				newSet.add(key);
			}
		}
		return newSet;
	}

	@Override
	public MathSet<Key> intersection(MathSet<Key> a) {
		MathSet<Key> newSet = new SeparateChainingHashMathSet<Key>(universe);
		for(Key key : universe) {
			if(contains(key) && a.contains(key)) {
				newSet.add(key);
			}
		}
		return newSet;
	}

	@Override
	public void delete(Key key) {
		if(keys.contains(key) && keys.get(key)) {
			keys.put(key, false);
			size--;
		}
	}

	@Override
	public boolean contains(Key key) {
		return keys.contains(key) && keys.get(key);
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

}
