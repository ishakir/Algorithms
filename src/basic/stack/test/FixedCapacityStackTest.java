package basic.stack.test;

import static org.junit.Assert.*;

import org.junit.Test;

import basic.stack.FixedCapacityStack;


public class FixedCapacityStackTest {

	@Test
	public void testEmptyIsEmpty() {
		FixedCapacityStack<String> stack = new FixedCapacityStack<String>(2);
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testEmptyIsNotFull() {
		FixedCapacityStack<String> stack = new FixedCapacityStack<String>(2);
		assertFalse(stack.isFull());
	}
	
	@Test
	public void testHalfEmptyIsNotEmpty() {
		FixedCapacityStack<String> stack = new FixedCapacityStack<String>(2);
		stack.push("A String");
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void testHalfEmptyIsNotFull() {
		FixedCapacityStack<String> stack = new FixedCapacityStack<String>(2);
		stack.push("A String");
		assertFalse(stack.isFull());
	}
	
	@Test
	public void testFullIsFull() {
		FixedCapacityStack<String> stack = new FixedCapacityStack<String>(2);
		stack.push("A String");
		stack.push("A string");
		assertTrue(stack.isFull());
	}
	
	@Test
	public void testFullIsNotEmpty() {
		FixedCapacityStack<String> stack = new FixedCapacityStack<String>(2);
		stack.push("A String");
		stack.push("A String");
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void testPeekGivesCorrectValue() {
		FixedCapacityStack<Integer> stack = new FixedCapacityStack<Integer>(2);
		stack.push(1);
		stack.push(2);
		assertEquals(2, (int) stack.peek());
	}
	
	@Test
	public void testPeekDoesntPop() {
		FixedCapacityStack<Integer> stack = new FixedCapacityStack<Integer>(2);
		stack.push(1);
		stack.push(2);
		stack.peek();
		assertEquals(2, stack.size());
	}

}
