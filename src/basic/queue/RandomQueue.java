package basic.queue;

import java.util.Iterator;
import java.util.Random;

// Does not implement queue, as it does not satisfy the FIFO condition
public class RandomQueue<Item> implements Iterable<Item> {
	
	private Item[] items;
	private int head;
	private int tail;
	private Random random;
	
	public RandomQueue() {
		items = (Item[]) new Object[10];
		head = 0;
		tail = 0;
		random = new Random();
	}
	
	public void enqueue(Item item) {
		if (tail == items.length) {
			resize(items.length * 2);
		}
		items[tail++] = item;
	}

	public Item dequeue() {
		if (size() == 0){
			return null;
		}
		int itemToRemoveIndex = head + random.nextInt(size());
		
		Item item = items[itemToRemoveIndex];
		items[itemToRemoveIndex] = items[head];
		items[head++] = null;
		
		if (size() < items.length / 4) {
			resize(items.length / 2);
		}
		return item;
	}
	
	public Item sample() {
		int sampleItemIndex = head + random.nextInt(size());
		return items[sampleItemIndex];
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
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		return tail - head;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
