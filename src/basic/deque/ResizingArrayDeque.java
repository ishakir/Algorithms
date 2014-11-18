package basic.deque;


public class ResizingArrayDeque<Item>  implements Deque<Item> {
	
	private Item[] items;
	private int head;
	private int tail;
	private int size;
	
	public ResizingArrayDeque(int initialCapacity) {
		items = (Item[]) new Object[initialCapacity];
		head = initialCapacity / 2;
		tail = initialCapacity / 2;
	}
	
	private int inc(int i) {
		if(++i == items.length) {
			return 0;
		} else {
			return i;
		}
	}
	
	private int dec(int i) {
		if(--i < 0) {
			return items.length - 1;
		} else {
			return i;
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void pushLeft(Item item) {
		if(!isEmpty()) {
			head = dec(head);
		}
		items[head] = item;
		size++;
		if(head == 0) {
			reset();
		}
	}

	@Override
	public void pushRight(Item item) {
		if(!isEmpty()) {
			tail = inc(tail);
		}
		items[tail] = item;
		size++;
		if(tail == items.length - 1) {
			reset();
		}
	}

	@Override
	public Item popLeft() {
		Item toReturn = items[head];
		items[head] = null;
		if(size != 1) {
			head = inc(head);
		}
		size--;
		if(size == items.length / 4) {
			reset();
		}
		return toReturn;
	}

	@Override
	public Item popRight() {
		Item toReturn = items[tail];
		items[tail] = null;
		if(size != 1) {
			tail = dec(tail);
		}
		size--;
		if(size == items.length / 4) {
			reset();
		}
		return toReturn;
	}
	
	public void show() {
		System.out.println("Head: "+head);
		System.out.println("Tail: "+tail);
		System.out.println("Size: "+size);
		for(int i = 0; i < items.length; i++) {
			System.out.print(items[i] + " ");
		}
		System.out.println();
	}
	
	private void reset() {
		//TODO implement
	}

}
