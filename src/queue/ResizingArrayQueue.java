package queue;

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
		if(tail == items.length) {
			resize(items.length * 2);
		}
		items[tail++] = item;
		System.out.println("Added item "+item);
		printInfo();
	}

	@Override
	public Item dequeue() {
		if(size() == 0) return null;
		Item item = items[head];
		items[head] = null;
		head = (head + 1) % items.length;
		printInfo();
		if(size() < items.length / 4) {
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
	
	private void resize(int newSize) {
		Item[] tempArray = (Item[]) new Object[newSize];
		for(int i = head; i < tail; i++) {
			tempArray[i - head] = items[i];
		}
		tail = tail - head;
		head = 0;
		items = tempArray;
	}
	
	private void printInfo() {
		System.out.println("Head is "+head);
		System.out.println("Tail is "+tail);
		System.out.println("items is");
		for(int i = 0; i < items.length; i++) {
			System.out.println(i + ": " + items[i]);
		}
	}
	
	public static void main(String[] args) {
		Queue<String> stringQueue = new ResizingArrayQueue<String>(1);
		
		stringQueue.enqueue("Hello");
		stringQueue.enqueue("My");
		stringQueue.enqueue("Name");
		stringQueue.enqueue("Is");
		stringQueue.enqueue("Imran");
		
		System.out.println(stringQueue.dequeue());
		System.out.println(stringQueue.dequeue());
		System.out.println(stringQueue.dequeue());
		
		for(int i = 0; i < 6; i++) {
			stringQueue.enqueue("Stuff");
		}
		
		for(int i = 0; i < 8; i++) {
			stringQueue.dequeue();
		}
		
		System.out.println(stringQueue.isEmpty());
	}

}
