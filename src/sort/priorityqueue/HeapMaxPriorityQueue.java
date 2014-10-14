package sort.priorityqueue;

public class HeapMaxPriorityQueue<Key extends Comparable<Key>> implements
		MaxPriorityQueue<Key> {

	private Key[] pq;
	private int N = 0;
	
	public HeapMaxPriorityQueue(int maxN) {
		pq = (Key[]) new Comparable[maxN + 1];
	}
	
	@Override
	public void insert(Key v) {
		pq[++N] = v;
		swim(N);
		show();
	}

	@Override
	public Key max() {
		Key max = pq[1];
		return max;
	}

	@Override
	public Key delMax() {
		Key max = pq[1];
		exch(1, N--);
		pq[N+1] = null;
		sink(1);
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
	
	private void swim(int k) {
		while(k > 1 && less(k/2, k)) {
			exch(k/2, k);
			k = k/2;
		}
	}
	
	private void sink(int k) {
		while(2*k <= N) {
			int j = 2*k;
			if(j < N && less(j, j + 1)) j++;
			if(!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	
	private void show() {
		for(int i = 0; i < pq.length; i++) {
			System.out.print(pq[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MaxPriorityQueue<Character> priorityQueue = new HeapMaxPriorityQueue<Character>(20);
		priorityQueue.insert('E');
		priorityQueue.insert('A');
		priorityQueue.insert('S');
		priorityQueue.insert('Y');
		priorityQueue.insert('Q');
		priorityQueue.insert('U');
		priorityQueue.insert('E');
		priorityQueue.insert('S');
		priorityQueue.insert('T');
		priorityQueue.insert('I');
		priorityQueue.insert('O');
		priorityQueue.insert('N');
	}

}
