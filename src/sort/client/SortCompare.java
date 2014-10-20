package sort.client;

import java.util.Random;

import misc.Stopwatch;
import sort.Insertion;
import sort.Selection;
import sort.Shell;

public class SortCompare {
	
	public static <Item extends Comparable<Item>> double time(String alg, Item[] a) {
		Stopwatch timer = new Stopwatch();
		if(alg.equals("Insertion")) new Insertion<Item>(a).sort();
		if(alg.equals("Selection")) new Selection<Item>(a).sort();
		if(alg.equals("Shell"))     new Shell<Item>(a).sort();
		return timer.elapsedTime();
	}
	
	public static double timeRandomInput(String alg, int N, int T) {
		double total = 0.0;
		Double[] a = new Double[N];
		Random random = new Random();
		System.out.println(alg);
		for(int t = 0; t < T; t++) {
			System.out.println(t);
			for(int i = 0; i < N; i++) {
				a[i] = random.nextDouble();
			}
			total += time(alg, a);
		}
		return total;
	}
	
	public static void main(String[] args) {
		int arraySize = 10000;
		int noOfTimes = 100;
		double selectionTime = timeRandomInput("Selection", arraySize, noOfTimes);
		double insertionTime = timeRandomInput("Insertion", arraySize, noOfTimes);
		double shellTime = timeRandomInput("Shell", arraySize, noOfTimes);
		System.out.println("Selection: "+selectionTime);
		System.out.println("Insertion: "+insertionTime);
		System.out.println("Shell: "+shellTime);
	}
	
}
