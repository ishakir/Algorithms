package sort;

import sort.priorityqueue.HeapMaxPriorityQueue;
import sort.priorityqueue.MaxPriorityQueue;

public class Heap<Item extends Comparable<Item>> extends Sort<Item> {
	
	public Heap(Item[] a) {
		super(a);
	}
	
	// For now we'll just use the priority queue implementation, we lose
	// a bit of space but is more readable
	@Override
	public Item[] sort() {
		MaxPriorityQueue<Item> priorityQueue = new HeapMaxPriorityQueue<Item>(a.length);
		for(int i = 0; i < a.length; i++) {
			priorityQueue.insert(a[i]);
		}
		for(int i = 0; i < a.length; i++) {
			a[i] = priorityQueue.delMax();
		}
		return a;
	}
	
	public static void main(String[] args) {
		Integer[] intArray = {9,2,5,3,8,1,7,4,6};
		Sort<Integer> sort = new Heap<Integer>(intArray);
		Integer[] sorted = sort.sort();
		for(int i = 0; i < sorted.length; i++) {
			System.out.print(sorted[i]);
		}
	}
	
}
