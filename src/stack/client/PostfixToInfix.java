package stack.client;

import stack.FixedCapacityStack;

public class PostfixToInfix {

	private String expression;
	
	public PostfixToInfix(String expression) {
		this.expression = expression;
	}
	
	public String convert() {
		FixedCapacityStack<String> stack = new FixedCapacityStack<String>(20);
		
		for(int i = expression.length() - 1; i >= 0; i--) {
			String a = expression.substring(i, i + 1);
			if(i == 0) {
				stack.push(a);
				resolveFinalClosingBrace(stack);
			} else if(isClosingBrace(a)) {
				resolveClosingBrace(stack);
			} else {
				System.out.println("Pushing "+a);
				stack.push(a);
			}
		}
		
		return stack.pop();
	}
	
	private boolean isClosingBrace(String a) {
		return a.equals(")");
	}
	
	private void resolveFinalClosingBrace(FixedCapacityStack<String> stack) {
		while(stack.size() != 1) {
			String expression1 = stack.pop();
			String operator = stack.pop();
			String expression2 = stack.pop();
			
			System.out.println("Pushing "+"("+expression1+operator+expression2+")");
			stack.push("("+expression1+operator+expression2+")");
		}
	}
	
	private void resolveClosingBrace(FixedCapacityStack<String> stack) {
		if(stack.size() < 4) {
			return;
		}
		
		System.out.println("Popping 4");
		String spareOperator = stack.pop();

		String expression1 = stack.pop();
		String operator = stack.pop();
		String expression2 = stack.pop();
		
		if(isClosingBrace(expression1) || isClosingBrace(operator) || isClosingBrace(expression2)) {
			return;
		} else {
			System.out.println("Pushing "+"("+expression1+operator+expression2+")");
			stack.push("("+expression1+operator+expression2+")");
			System.out.println("Pushing "+spareOperator);
			stack.push(spareOperator);
			resolveClosingBrace(stack);
		}
		
	}
	
}
