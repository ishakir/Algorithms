package sort.priorityqueue;

public class OrderedArrayPriorityQueue<Item extends Comparable<Item>>
		implements MaxPriorityQueue<Item> {
	
	private Item[] items;
	private int N;
	
	public OrderedArrayPriorityQueue(int maxSize) {
		items = (Item[]) new Comparable[maxSize];
	}
	
	@Override
	public void insert(Item v) {
		items[N++] = v;
		int count = N - 1;
		while(N > 1 && count > 0 && less(items[count], items[count - 1])) {
			exch(count, count - 1);
			count--;
		}
	}

	@Override
	public Item max() {
		return items[N-1];
	}

	@Override
	public Item delMax() {
		Item max = items[--N];
		items[N+1] = null;
		return max;
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public int size() {
		return N;
	}

	protected boolean less(Item v, Item w) {
		return v.compareTo(w) < 0;
	}
	
	protected void exch(int i, int j) {
		Item t = items[i];
		items[i] = items[j];
		items[j] = t;
	}
	
}
