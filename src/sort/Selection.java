package sort;


public class Selection<Item extends Comparable<Item>> extends Sort<Item> {

	public Selection(Item[] a) {
		super(a);
	}

	@Override
	public Item[] sort() {
		int N = a.length;
		for(int i = 0; i < N; i++) {
			int min = i;
			for(int j = i + 1; j < N; j++) {
				if(less(a[j], a[min])) {
					min = j;
				}
			}
			exch(i, min);
			show();
		}
		return a;
	}
	
	public static void main(String[] args) {
		Integer[] intArray = {9,2,5,3,8,1,7,4,6};
		Sort<Integer> sort = new Selection<Integer>(intArray);
		sort.show();
		sort.sort();
	}

}
