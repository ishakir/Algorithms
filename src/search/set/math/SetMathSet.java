package search.set.math;

import search.set.SeparateChainingHashSet;
import search.set.Set;

public class SetMathSet<Key> implements MathSet<Key> {

	private Set<Key> keys;
	private Key[] universe;
	
	public SetMathSet(Key[] universe) {
		this.universe = universe;
		this.keys = new SeparateChainingHashSet<Key>(universe.length * 2);
	}
	
	@Override
	public void add(Key key) {
		keys.add(key);
	}

	@Override
	public MathSet<Key> complement() {
		MathSet<Key> newSet = new SetMathSet<Key>(universe);
		for(Key key : universe) {
			if(!contains(key)) {
				newSet.add(key);
			}
		}
		return newSet;
	}

	@Override
	public MathSet<Key> union(MathSet<Key> a) {
		MathSet<Key> newSet = new SetMathSet<Key>(universe);
		for(Key key : universe) {
			if(contains(key) || a.contains(key)) {
				newSet.add(key);
			}
		}
		return newSet;
	}

	@Override
	public MathSet<Key> intersection(MathSet<Key> a) {
		MathSet<Key> newSet = new SetMathSet<Key>(universe);
		for(Key key : universe) {
			if(contains(key) && a.contains(key)) {
				newSet.add(key);
			}
		}
		return newSet;
	}

	@Override
	public void delete(Key key) {
		keys.delete(key);
	}

	@Override
	public boolean contains(Key key) {
		return keys.contains(key);
	}

	@Override
	public boolean isEmpty() {
		return keys.isEmpty();
	}

	@Override
	public int size() {
		return keys.size();
	}

}
