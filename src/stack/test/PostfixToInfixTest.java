package stack.test;

import static org.junit.Assert.*;

import org.junit.Test;

import stack.client.PostfixToInfix;

public class PostfixToInfixTest {

	@Test
	public void testConvert() {
		PostfixToInfix converter = new PostfixToInfix("1+2)*3-4)*5-6)))");
		assertEquals("((1+2)*((3-4)*(5-6)))", converter.convert());
	}

}
