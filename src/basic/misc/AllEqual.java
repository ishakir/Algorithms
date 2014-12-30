package basic.misc;

public class AllEqual {
	
	public static void main(String[] args) {
		int a = 1;
		int b = 0;
		int c = 0;
		
		boolean equal = (a == b) && (b == c);
		
		if(equal) {
			System.out.println("equal");
		} else {
			System.out.println("not equal");
		}
	}

}
