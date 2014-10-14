package basic.stack.client;

import basic.stack.FixedCapacityStack;

public class Parenthesis {

	private String brackets;
	
	public Parenthesis(String brackets) {
		this.brackets = brackets;
	}
	
	public boolean areValid() {
		FixedCapacityStack<Character> stack = new FixedCapacityStack<Character>(brackets.length());
		for(int i = 0; i < brackets.length(); i++) {
			char c = brackets.charAt(i);
			System.out.println(i);
			System.out.println(c);
			if(c == ')' || c == ']' || c == '}') {
				char comp = stack.pop();
				System.out.println("Got "+comp+" comparing with "+c);
				if(c == ')' && comp != '(') {
					return false;
				} else if(c == ']' && comp != '[') {
					return false;
				} else if(c == '}' && comp != '{') {
					return false;
				}
			} else {
				System.out.println("Pushing "+c+" onto stack");
				stack.push(c);
			}
		}
		if(stack.size() != 0) {
			return false;
		} else {
			return true;
		}
	}
	
}
