package basic.stack.client;

import basic.stack.DynamicCapacityStack;
import misc.io.StdIn;

public class Reverse {
	public static void main(String[] args) {
		DynamicCapacityStack<Integer> stack = new DynamicCapacityStack<Integer>(1);
		
		while(!StdIn.isEmpty()) {
			stack.push(StdIn.readInt());
		}
		
		for(int i : stack) {
			System.out.println(i);
		}
	}
}
