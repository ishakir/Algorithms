package stack;

import java.util.Iterator;

public class DynamicCapacityStack<Item> implements Stack<Item>, Iterable<Item> {

	private Item[] a;
	private int N;
	
	public DynamicCapacityStack(int cap) {
		a = (Item[]) new Object[cap];
	}
	
	public boolean isEmpty() { return N == 0; }
	public int size() { return N; }
	
	public void push(Item item) {
		if(N == a.length) {
			resize(2*a.length);
		}
		a[N++] = item;
		System.out.println("Added "+item+" to stack, whose size is now " + N);
		printAllItems();
	}
	
	public Item pop() {
		Item item = a[--N];
		a[N] = null;
		if(N > 0 && N == a.length/4) {
			resize(a.length / 2);
		}
		System.out.println("Removed "+item+" from stack, whose size is now " + N);
		printAllItems();
		return item;
	}
	
	private void resize(int max) {
		System.out.println("Resizing stack to " + max);
		Item[] temp = (Item[]) new Object[max];
		for(int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	private void printAllItems() {
		System.out.print("Stack is: ");
		for (Item item : this) {
			System.out.print(item+" ");
		}
		System.out.println();
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
