package sort.client;

import sort.Merge;
import sort.Sort;

public class DuplicateChecker<Item extends Comparable<Item>> {
	
	private Item[] items;
	
	public DuplicateChecker(Item[] items) {
		this.items = items;
	}
	
	public boolean hasDuplicates() {
		Sort<Item> sort = new Merge<Item>(items);
		Item[] sorted = sort.sort();
		for(int i = 1; i < sorted.length; i++) {
			if(sorted[i].compareTo(sorted[i-1]) == 0) {
				return false;
			}
		}
		return true;
	}

}
