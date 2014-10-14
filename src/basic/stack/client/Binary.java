package basic.stack.client;

import basic.stack.FixedCapacityStack;

public class Binary {
	
	private int value;
	
	public Binary(int value) {
		this.value = value;
	}
	
	public String binaryRep() {
		FixedCapacityStack<String> stack = new FixedCapacityStack<String>(20);
		while(value > 0) {
			stack.push(String.valueOf(value % 2));
			value = value / 2;
		}
		String returnVal = "";
		while(!stack.isEmpty()) {
			returnVal = returnVal + stack.pop();
		}
		return returnVal;
	}
	
}
