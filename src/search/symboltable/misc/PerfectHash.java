package search.symboltable.misc;

import java.util.HashSet;
import java.util.Set;

public class PerfectHash {

	private int a;
	private int M;
	private int[] alphabetNumbers = {19, 5, 1, 18, 3, 8, 24, 13, 16, 12};
	
	public PerfectHash(int a, int M) {
		this.a = a;
		this.M = M;
	}
	
	private int hash(int number) {
		return (a * number) % M;
	}
	
	public int noCollisions() {
		Set<Integer> distinct = new HashSet<Integer>();
		for(int i = 0; i < alphabetNumbers.length; i++) {
			distinct.add(hash(alphabetNumbers[i]));
		}
		return alphabetNumbers.length - distinct.size();
	}
	
	public static void main(String[] args) {
		int M = 11;
		boolean completed = false;
		while(!completed) {
			for(int a = 1; a < M; a++) {
				PerfectHash test = new PerfectHash(a, M);
				int noCollisions = test.noCollisions();
				System.out.println("Trying a="+a+", M="+M+" found "+noCollisions+" collisions");
				completed = noCollisions == 0;
			}
			M++;
		}
	}
	
}
