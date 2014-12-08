package search.symboltable;

import java.util.Iterator;

public class UnorderedArraySymbolTable<Key, Value> extends AbstractSymbolTable<Key, Value> {

	private int size;
	private Key[] keys;
	private Value[] values;
	
	public UnorderedArraySymbolTable(int capacity) {
		size = 0;
		keys = (Key[]) new Object[capacity];
		values = (Value[]) new Object[capacity];
	}
	
	@Override
	public void put(Key key, Value val) {
		int firstNullKeyIndex = 0;
		for(int i = 0; i < values.length; i++) {
			if(keys[i] == null) {
				if(firstNullKeyIndex == 0) {
					firstNullKeyIndex = i;
				}
			} else if(key.equals(keys[i])) {
				values[i] = val;
				if(val == null) {
					keys[i] = null;
					size--;
				}
				return;
			}
		}
		keys[firstNullKeyIndex] = key;
		values[firstNullKeyIndex] = val;
		size++;
	}

	@Override
	public Value get(Key key) {
		for(int i = 0; i < keys.length; i++) {
			if(keys[i] != null && keys[i].equals(key)) {
				return values[i];
			}
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterable<Key> keys() {
		return new KeysIterable();
	}
	
	private class KeysIterable implements Iterable<Key> {
		
		private int currentIndex;
		
		@Override
		public Iterator<Key> iterator() {
			return new Iterator<Key>() {

				@Override
				public boolean hasNext() {
					while(currentIndex < keys.length) {
						if(keys[currentIndex] != null) {
							return true;
						}
						currentIndex++;
					}
					return false;
				}

				@Override
				public Key next() {
					return keys[currentIndex++];
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}
			};
		}
		
	}

}
