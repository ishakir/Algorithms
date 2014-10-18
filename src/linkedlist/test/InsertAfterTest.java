package linkedlist.test;

import static org.junit.Assert.assertEquals;
import linkedlist.Node;
import linkedlist.client.InsertAfter;

import org.junit.Test;

public class InsertAfterTest {

	@Test
	public void testInsertAfterLast() {
		Node<String> first = new Node<String>("hello", null);
		Node<String> next = new Node<String>("next", null);
		
		InsertAfter<String> insertAfter = new InsertAfter<String>(first);
		insertAfter.insertAfter(next);
		
		assertEquals(first.next, next);
	}
	
	@Test
	public void testInsertAfterMiddle() {
		Node<String> last = new Node<String>("next", null);
		Node<String> first = new Node<String>("hello", last);
		
		Node<String> newNode = new Node<String>("newNode", null);
		
		InsertAfter<String> insertAfter = new InsertAfter<String>(first);
		insertAfter.insertAfter(newNode);
		
		assertEquals(newNode, first.next);
		assertEquals(last, newNode.next);
	}

}
