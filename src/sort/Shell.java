package sort;

public class Shell<Item extends Comparable<Item>> extends Sort<Item> {

	private int[] incrementSequence;
	
	public Shell(Item[] a) {
		super(a);
		
		// Calculate some increment sequence up front
		int h = 1;
		int counter = 1;
		while(h < a.length / 3) {
			h = 3*h + 1;
			counter++;
		}
		incrementSequence = new int[counter];
		int counter2 = 0;
		while(h >= 1) {
			incrementSequence[counter2] = h;
			h = h / 3;
			counter2++;
		}
	}
	
	public Shell(Item[] a, int[] incrementSequence) {
		super(a);
		this.incrementSequence = incrementSequence;
	}

	@Override
	public Item[] sort() {
		int N = a.length;
		for(int k = 0; k < incrementSequence.length; k++) { // h-sort the array
			int h = incrementSequence[k];
			for(int i = h; i < N; i++) {
				for(int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
					exch(j, j - h);
				}
			}
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
