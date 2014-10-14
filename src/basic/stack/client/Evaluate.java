package basic.stack.client;

import basic.stack.DynamicCapacityStack;
import basic.stack.Stack;

public class Evaluate {
	
	private String expression;
	
	public Evaluate(String expression) {
		this.expression = expression;
	}
	
	public double evaluate() {
		Stack<Character> ops = new DynamicCapacityStack<Character>(1);
		Stack<Double> vals = new DynamicCapacityStack<Double>(1);
		
		for(int i = 0; i < expression.length(); i++) {
			char s = expression.charAt(i);
			if(s == '(');
			else if(s == '+') ops.push(s);
			else if(s == '-') ops.push(s);
			else if(s == '*') ops.push(s);
			else if(s == '/') ops.push(s);
			else if(s == ')') {
				char op = ops.pop();
				double v = vals.pop();
				if(op == '+') v = vals.pop() + v;
				else if(op == '-') v = vals.pop() - v;
				else if(op == '*') v = vals.pop() * v;
				else if(op == '/') v = vals.pop() / v;
				vals.push(v);
			} else {
				vals.push(Double.parseDouble(String.valueOf(s)));
			}	
		}
		
		return vals.pop();
	}
}
