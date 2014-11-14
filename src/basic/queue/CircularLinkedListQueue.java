package basic.queue;

import java.util.Iterator;

import linkedlist.Node;

public class CircularLinkedListQueue<Item> implements Queue<Item> {

	private Node<Item> last;
	private int N;

	@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {

			private Node<Item> first = last.next;
			private Node<Item> current = first;
			
			@Override
			public boolean hasNext() {
				return !current.equals(first);
			}

			@Override
			public Item next() {
				Item next = current.item;
				current = current.next;
				return next;
			}

			@Override
			public void remove() {}
			
		};
	}

	@Override
	public void enqueue(Item item) {
		if(last == null) {
			last = new Node<Item>(item, null);
			last.next = last;
		} else {
			Node<Item> oldLast = last;
			last = new Node<Item>(item, oldLast.next);
			oldLast.next = last;
		}
		N++;
	}

	@Override
	public Item dequeue() {
		Item toReturn = null;
		
		if(last != null) {
			if(last.next == last) {
				toReturn = last.item;
				last = null;
				N--;
			} else {
				Node<Item> first = last.next;
				last.next = first.next;
				N--;
				toReturn = first.item;
			}
		}
		
		return toReturn;
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public int size() {
		return N;
	}

}
