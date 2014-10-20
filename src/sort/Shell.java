package sort;

public class Shell<Item extends Comparable<Item>> extends Sort<Item> {

	public Shell(Item[] a) {
		super(a);
	}

	@Override
	public Item[] sort() {
		int N = a.length;
		int h = 1;
		while(h < N/3) h = 3*h + 1;
		while(h >= 1) { // h-sort the array
			for(int i = h; i < N; i++) {
				for(int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
					exch(j, j - h);
				}
			}
			h = h / 3;
		}
		return a;
	}
	
	public static void main(String[] args) {
		Character[] intArray = {'S','H','E','L','L','S','O','R','T','E','X','A','M','P','L','E'};
		Sort<Character> sort = new Shell<Character>(intArray);
		sort.show();
		sort.sort();
		sort.show();
	}

}
