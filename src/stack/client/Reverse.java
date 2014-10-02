package stack.client;

import stack.DynamicCapacityStack;
import io.StdIn;

public class Reverse {
	public static void main(String[] args) {
		DynamicCapacityStack<Integer> stack = new DynamicCapacityStack<>(1);
		
		while(!StdIn.isEmpty()) {
			stack.push(StdIn.readInt());
		}
		
		for(int i : stack) {
			System.out.println(i);
		}
	}
}
