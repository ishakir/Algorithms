package search.set.math;

import search.symboltable.SeparateChainingHashSymbolTable;
import search.symboltable.SymbolTable;

public class SymbolTableMathSet<Key> implements MathSet<Key> {
	
	private final SymbolTable<Key, Boolean> keys;
	private int size;
	private final Key[] universe;
	
	public SymbolTableMathSet(Key[] universe) {
		keys = new SeparateChainingHashSymbolTable<Key, Boolean>(universe.length * 2);
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
		MathSet<Key> newSet = new SymbolTableMathSet<Key>(universe);
		for(Key key : universe) {
			if(!contains(key)) {
				newSet.add(key);
			}
		}
		return newSet;
	}

	@Override
	public MathSet<Key> union(MathSet<Key> a) {
		MathSet<Key> newSet = new SymbolTableMathSet<Key>(universe);
		for(Key key : universe) {
			if(contains(key) || a.contains(key)) {
				newSet.add(key);
			}
		}
		return newSet;
	}

	@Override
	public MathSet<Key> intersection(MathSet<Key> a) {
		MathSet<Key> newSet = new SymbolTableMathSet<Key>(universe);
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
