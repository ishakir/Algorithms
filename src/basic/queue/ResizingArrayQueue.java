package basic.queue;

import java.util.Iterator;

public class ResizingArrayQueue<Item> implements Queue<Item> {

	private Item[] items;
	private int head;
	private int tail;

	public ResizingArrayQueue(int initialCapacity) {
		items = (Item[]) new Object[initialCapacity];
		head = 0;
		tail = 0;
	}

	@Override
	public void enqueue(Item item) {
		if (tail == items.length) {
			resize(items.length * 2);
		}
		items[tail++] = item;
	}

	@Override
	public Item dequeue() {
		if (size() == 0)
			return null;
		Item item = items[head];
		items[head] = null;
		head = (head + 1) % items.length;
		if (size() < items.length / 4) {
			resize(items.length / 2);
		}
		return item;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return tail - head;
	}

	// TODO are the conditions for when this gets called right?
	private void resize(int newSize) {
		Item[] tempArray = (Item[]) new Object[newSize];
		for (int i = head; i < tail; i++) {
			tempArray[i - head] = items[i];
		}
		tail = tail - head;
		head = 0;
		items = tempArray;
	}

	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item> {
		private final int initialSize = size();
		private int i = initialSize;

		public boolean hasNext() {
			return i < initialSize;
		}

		public Item next() {
			return items[i++];
		}

		public void remove() {
		}
	}

}
