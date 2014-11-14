package linkedlist.test;

import static org.junit.Assert.assertEquals;
import linkedlist.Node;
import linkedlist.client.FindLargest;

import org.junit.Test;

public class FindLargestTest {

	private Node<Integer> largestFirst = new Node<Integer>(3,
			new Node<Integer>(2, new Node<Integer>(1, null)));

	private Node<Integer> largestMiddle = new Node<Integer>(2,
			new Node<Integer>(3, new Node<Integer>(1, null)));

	private Node<Integer> largestLast = new Node<Integer>(1, new Node<Integer>(
			2, new Node<Integer>(3, null)));

	@Test
	public void testLoopLargestFirst() {
		FindLargest finder = new FindLargest(largestFirst);
		assertEquals(new Integer(3), finder.maxLoop());
	}
	
	@Test
	public void testLoopLargestMiddle() {
		FindLargest finder = new FindLargest(largestMiddle);
		assertEquals(new Integer(3), finder.maxLoop());
	}
	
	@Test
	public void testLoopLargestLast() {
		FindLargest finder = new FindLargest(largestLast);
		assertEquals(new Integer(3), finder.maxLoop());
	}
	
	@Test
	public void testRecurseLargestFirst() {
		FindLargest finder = new FindLargest(largestFirst);
		assertEquals(new Integer(3), finder.maxRecurse());
	}
	
	@Test
	public void testRecurseLargestMiddle() {
		FindLargest finder = new FindLargest(largestMiddle);
		assertEquals(new Integer(3), finder.maxRecurse());
	}
	
	@Test
	public void testRecurseLargestLast() {
		FindLargest finder = new FindLargest(largestLast);
		assertEquals(new Integer(3), finder.maxRecurse());
	}

}