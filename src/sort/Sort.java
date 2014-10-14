package sort;

public abstract class Sort<Item extends Comparable<Item>> {
	
	protected Item[] a;
	
	public Sort(Item[] a) {
		this.a = a;
	}
	
	public abstract Item[] sort();
	
	protected boolean less(Item v, Item w) {
		return v.compareTo(w) < 0;
	}
	
	protected void exch(int i, int j) {
		Item t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public void show() {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public boolean isSorted() {
		for(int i = 1; i < a.length; i++) {
			if(less(a[i], a[i-1])) return false;
		}
		return true;
	}
	
}
