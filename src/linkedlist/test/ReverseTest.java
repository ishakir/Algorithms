package linkedlist.test;

import static org.junit.Assert.assertEquals;
import linkedlist.Node;
import linkedlist.client.Reverse;

import org.junit.Test;

public class ReverseTest {

	@Test
	public void testReverseIterative() {
		Node<Integer> first = new Node<Integer>(1, new Node<Integer>(2, new Node<Integer>(3, null)));
		Node<Integer> newFirst = new Reverse<Integer>(first).iterativeReverse();
		
		assertEquals(new Integer(3), newFirst.item);
		assertEquals(new Integer(2), newFirst.next.item);
		assertEquals(new Integer(1), newFirst.next.next.item);
	}
	
	@Test
	public void testReverseRecursive() {
		Node<Integer> first = new Node<Integer>(1, new Node<Integer>(2, new Node<Integer>(3, null)));
		Node<Integer> newFirst = new Reverse<Integer>(first).recursiveReverse();
		
		assertEquals(new Integer(3), newFirst.item);
		assertEquals(new Integer(2), newFirst.next.item);
		assertEquals(new Integer(1), newFirst.next.next.item);
	}

}
