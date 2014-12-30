package basic.misc;

public class BetweenZeroAndOne {

	private static boolean betweenZeroAndOne(double x) {
		return x < 1.0 && x > 0.0;
	}
	
	public static void main(String[] args) {
		double x = 0.0000000000001;
		double y = 0.00000000000000000001;
		
		System.out.println(betweenZeroAndOne(x) && betweenZeroAndOne(y));
	}

}
