package basic.queue.test;

import static org.junit.Assert.*;

import org.junit.Test;

import basic.queue.client.InfixToPostfix;

public class InfixToPostfixTest {

	@Test
	public void test() {
		InfixToPostfix computation = new InfixToPostfix("((1+2)*((3-4)*(5-6)))");
		assertEquals("1+2)*3-4)*5-6)))", computation.convert());
	}

}
