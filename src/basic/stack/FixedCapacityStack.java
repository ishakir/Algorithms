package basic.stack;

import java.util.Iterator;

public class FixedCapacityStack<Item> implements Stack<Item> {
	
	private Item[] a;
	private int N;
	
	public FixedCapacityStack(int cap) {
		a = (Item[]) new Object[cap];
	}
	
	
	public boolean isEmpty() { return N == 0; }
	public boolean isFull() { return N == a.length; }
	public int size() { return N; }
	
	public void push(Item item) {
		a[N++] = item;
	}
	
	public Item pop() {
		return a[--N];
	}
	
	public Item peek() {
		return a[N - 1];
	}
	
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item> {
		private int i = N;
		public boolean hasNext() { return i > 0; }
		public Item next() { return a[--i]; }
		public void remove() {}
	}
	
}
