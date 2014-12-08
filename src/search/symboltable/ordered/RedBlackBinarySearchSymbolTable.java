package search.symboltable.ordered;


public class RedBlackBinarySearchSymbolTable<Key extends Comparable<Key>, Value> extends AbstractOrderedSymbolTable<Key, Value>{
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;
	
	private class Node {
		Key key;
		Value val;
		Node left, right;
		int N;
		boolean color;
		
		Node(Key key, Value val, int N, boolean color) {
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;
		}
		
	}
	
	private Boolean isRed(Node x) {
		if(x == null) return false;
		return x.color == RED;
	}
	
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + h.left.N + h.right.N;
		return x;
	}
	
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	private int size(Node h) {
		if(h == null) return 0;
		else return h.N;
	}
	
	@Override
	public Key min() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key max() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key floor(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key ceil(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int rank(Key key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Key select(int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Key> keys(Key lo, Key hi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(Key key, Value val) {
		root = put(root, key, val);
		root.color = BLACK;
	}
	
	private Node put(Node h, Key key, Value val) {
		if(h == null) return new Node(key, val, 1, RED);
		
		int cmp = key.compareTo(h.key);
		if(cmp < 0) h.left = put(h.left, key, val);
		else if(cmp > 0) h.right = put(h.right, key, val);
		else h.val = val;
		
		if(isRed(h.right) && !isRed(h.left))    h = rotateLeft(h);
		if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
		if(isRed(h.left) && isRed(h.right))     flipColors(h);
		
		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}

	@Override
	public Value get(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<Key> keys() {
		// TODO Auto-generated method stub
		return null;
	}

}
