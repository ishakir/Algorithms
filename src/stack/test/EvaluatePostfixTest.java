package stack.test;

import static org.junit.Assert.*;

import org.junit.Test;

import stack.client.EvaluatePostfix;

public class EvaluatePostfixTest {

	@Test
	public void test() {
		EvaluatePostfix evaluator = new EvaluatePostfix("1+2)*3-4)*5-6)))");
		assertEquals(3, evaluator.evaluate(), 0);
	}

}
