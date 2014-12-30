package search.symboltable;

public class SeparateChainingHashSymbolTable<Key, Value> extends AbstractSymbolTable<Key, Value> {

	private int M;
	private SequentialSearchSymbolTable<Key, Value>[] st;
	
	public SeparateChainingHashSymbolTable() {
		this(997);
	}
	
	public SeparateChainingHashSymbolTable(int M) {
		this.M = M;
		st = (SequentialSearchSymbolTable<Key, Value>[]) new SequentialSearchSymbolTable[M];
		for(int i = 0; i < M; i++) {
			st[i] = new SequentialSearchSymbolTable<Key, Value>();
		}
	}
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public Value get(Key key) {
		return (Value) st[hash(key)].get(key);
	}
	
	public void put(Key key, Value val) {
		st[hash(key)].put(key, val);
	}

	@Override
	public int size() {
		int size = 0;
		for(int i = 0; i < M; i++) {
			size += st[i].size();
		}
		return size;
	}

	@Override
	public Iterable<Key> keys() {
		return null;
	}
	
}
