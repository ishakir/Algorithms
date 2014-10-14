package sort.priorityqueue;

public class UnorderedArrayPriorityQueue<Item extends Comparable<Item>> implements MaxPriorityQueue<Item> {

	private Item[] items;
	private int N;
	
	public UnorderedArrayPriorityQueue(int maxSize) {
		items = (Item[]) new Comparable[maxSize];
		N = 0;
	}
	
	@Override
	public void insert(Item v) {
		items[N++] = v;
	}

	@Override
	public Item max() {
		int max = 0;
		for(int i = 0; i < N; i++) {
			if(!less(i, max)) max = i;
		}
		return items[max];
	}

	@Override
	public Item delMax() {
		int max = 0;
		for(int i = 0; i < N; i++) {
			if(!less(i, max)) max = i;
		}
		Item maxItem = items[max];
		for(int i = max; i < N - 1; i++) {
			items[i] = items[i+1];
		}
		N--;
		return maxItem;
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public int size() {
		return N;
	}

	private boolean less(int i, int j) {
		return items[i].compareTo(items[j]) < 0;
	}
	
}
