package sort;

public class MergeBU<Item extends Comparable<Item>> extends Sort<Item> {
	
	private Item[] aux;
	
	public MergeBU(Item[] a) {
		super(a);
	}
	
	@Override
	public Item[] sort() {
		int N = a.length;
		aux = (Item[]) new Comparable[N];
		for(int sz = 1; sz < N; sz = sz + sz) {
			for(int lo = 0; lo < N - sz; lo += sz + sz) {
				merge(lo, lo + sz -1, Math.min(lo + sz + sz - 1, N - 1));
			}
		}
		return null;
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
		Sort<Character> sort = new MergeBU<Character>(intArray);
		sort.show();
		sort.sort();
		sort.show();
	}
	
}
