package stack.client;

import java.util.List;

import stack.FixedCapacityStack;

public class PushPopStrings {
	
	private List<String> strings;
	
	public PushPopStrings(List<String> strings) {
		this.strings = strings;
	}
	
	public String evaluate() {
		FixedCapacityStack<String> stack = new FixedCapacityStack<String>(strings.size());
		String finalString = "";
		
		for(String string : strings) {
			if("-".equals(string)) { finalString = finalString + stack.pop() + " "; }
			else stack.push(string);
		}
		
		return finalString;
	}

}
