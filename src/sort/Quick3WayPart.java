package sort;

import misc.StdRandom;

public class Quick3WayPart<Item extends Comparable<Item>> extends Sort<Item> {

	public Quick3WayPart(Item[] a) {
		super(a);
	}

	@Override
	public Item[] sort() {
		StdRandom.shuffle(a);
		sort(0, a.length - 1);
		return a;
	}
	
	private void sort(int lo, int hi) {
		if(hi <= lo) return;
		int lt = lo, i = lo + 1, gt = hi;
		Item v = a[lo];
		while(i <= gt) {
			int cmp = a[i].compareTo(v);
			if     (cmp < 0) exch(lt++, i++);
			else if(cmp > 0) exch(i, gt--);
			else             i++;
		}
		sort(lo, lt - 1);
		sort(gt + 1, hi);
	}

}
