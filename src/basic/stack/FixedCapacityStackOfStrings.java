package basic.stack;

import java.util.Iterator;

import misc.io.StdIn;
import misc.io.StdOut;

public class FixedCapacityStackOfStrings implements Stack<String> {

	private String[] a;
	private int N;
	
	public FixedCapacityStackOfStrings(int cap) {
		a = new String[cap];
	}
	
	public boolean isEmpty() { return N == 0; }
	public int size() {return N;}
	
	public void push(String item) {
		a[N++] = item;
	}
	
	public String pop() {
		return a[--N];
	}
	
	public static void main(String[] args) {
		FixedCapacityStackOfStrings s;
		s = new FixedCapacityStackOfStrings(100);
		
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if(!item.equals("-")) {
				s.push(item);
			} else if(!s.isEmpty()) {
				StdOut.print(s.pop() + " ");
			}
		}
		
		StdOut.println("(" + s.size() + " left on stack)");
	}
	
	public Iterator<String> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<String> {
		private int i = N;
		public boolean hasNext() { return i > 0; }
		public String next() { return a[--i]; }
		public void remove() {}
	}
	
}
