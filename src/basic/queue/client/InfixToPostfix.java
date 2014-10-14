package basic.queue.client;

import basic.queue.LinkedListQueue;
import basic.queue.Queue;

public class InfixToPostfix {
	
	private String expression;
	
	public InfixToPostfix(String expression) {
		this.expression = expression;
	}
	
	public String convert() {
		Queue<Character> characters = new LinkedListQueue<Character>();
		for(int i = 0; i < expression.length(); i++) {
			characters.enqueue(expression.charAt(i));
		}
		String returnValue = "";
		while(!characters.isEmpty()) {
			char next = characters.dequeue();
			if(next != '(') {
				returnValue = returnValue + next;
			}
		}
		return returnValue;
	}
	
}
