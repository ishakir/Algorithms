package sort;

public class Insertion<Item extends Comparable<Item>> extends Sort<Item> {

	public Insertion(Item[] a) {
		super(a);
	}

	@Override
	public Item[] sort() {
		int N = a.length;
		for(int i = 0; i < N; i++) {
			for(int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(j, j - 1);
				show();
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		Integer[] intArray = {9,2,5,3,8,1,7,4,6};
		Sort<Integer> sort = new Insertion<Integer>(intArray);
		sort.show();
		sort.sort();
	}

}
