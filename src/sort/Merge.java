package sort;

public class Merge<Item extends Comparable<Item>> extends Sort<Item> {
	
	public Merge(Item[] a) {
		super(a);
	}

	private Item[] aux;

	@Override
	public Item[] sort() {
		aux = (Item[]) new Comparable[a.length];
		innerSort(0, a.length - 1);
		return a;
	}
	
	private void innerSort(int lo, int hi) {
		if(hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		innerSort(lo, mid);
		innerSort(mid + 1, hi);
		merge(lo, mid, hi);
	}
	
	private void merge(int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		
		for(int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		for(int k = lo; k <= hi; k++) {
			if(i > mid)                    a[k] = aux[j++];
			else if (j > hi)               a[k] = aux[i++];
			else if (less(aux[j], aux[i])) a[k] = aux[j++];
			else                           a[k] = aux[i++];
		}
	}
	
	public static void main(String[] args) {
		Character[] intArray = {'M','E','R','G','E','S','O','R','T','E','X','A','M','P','L','E'};
		Sort<Character> sort = new Merge<Character>(intArray);
		sort.show();
		sort.sort();
		sort.show();
	}
	
}
