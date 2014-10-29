package sort;

public class Quick<Item extends Comparable<Item>> extends Sort<Item> {

	public Quick(Item[] a) {
		super(a);
	}

	@Override
	public Item[] sort() {
		// We should shuffle here to remove the dependance on input
		// Will do this once a reasonable shuffle is implemented
		innerSort(0, a.length - 1);
		return a;
	}
	
	private void innerSort(int lo, int hi) {
		if(hi <= lo) return;
		int j = partition(lo, hi);
		innerSort(lo, j - 1);
		innerSort(j + 1, hi);
	}
	
	private int partition(int lo, int hi) {
		int i = lo, j = hi + 1;
		Item v = a[lo];
		while(true) {
			while(less(a[++i], v)) if(i == hi) break;
			while(less(v, a[--j])) if (j == lo) break;
			if(i >= j) break;
			exch(i, j);
		}
		exch(lo, j);
		return j;
	}
	
}
