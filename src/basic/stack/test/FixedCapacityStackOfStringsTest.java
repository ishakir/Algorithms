package basic.stack.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import basic.stack.FixedCapacityStackOfStrings;
import basic.stack.Stack;

public class FixedCapacityStackOfStringsTest {
	
	private final String testStringOne = "A test string";
	private final String testStringTwo = "Another test string";
	
	@Test
	public void testIsFull() {
		FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(1);
		stack.push(testStringOne);
		assertTrue(stack.isFull());
	}
	
	@Test
	public void testCopy() {
		FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(2);
		stack.push(testStringOne);
		stack.push(testStringTwo);
		Stack<String> copyStack = stack.copy();
		
		assertEquals(testStringTwo, copyStack.pop());
		assertEquals(testStringOne, copyStack.pop());
	}

}
