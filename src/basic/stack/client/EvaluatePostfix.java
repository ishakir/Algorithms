package basic.stack.client;

public class EvaluatePostfix {
	
	private String expression;
	
	public EvaluatePostfix(String expression) {
		this.expression = expression;
	}
	
	public double evaluate() {
		PostfixToInfix converter = new PostfixToInfix(expression);
		Evaluate evaluator = new Evaluate(converter.convert());
		return evaluator.evaluate();
	}
	
}
