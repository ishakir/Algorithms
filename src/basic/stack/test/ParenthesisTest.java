package basic.stack.test;

import static org.junit.Assert.*;

import org.junit.Test;

import basic.stack.client.Parenthesis;


public class ParenthesisTest {

	@Test
	public void testValid() {
		Parenthesis parenthesis = new Parenthesis("[()]{}{[()()]()}");
		assertTrue(parenthesis.areValid());
	}
	
	@Test
	public void testInvalid() {
		Parenthesis parenthesis = new Parenthesis("[(])");
		assertFalse(parenthesis.areValid());
	}
	
	@Test 
	public void testNotFinished() {
		Parenthesis parenthesis = new Parenthesis("[[({{}})]");
		assertFalse(parenthesis.areValid());
	}

}
