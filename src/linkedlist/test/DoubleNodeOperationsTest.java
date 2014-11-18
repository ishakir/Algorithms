package linkedlist.test;

import static org.junit.Assert.*;
import linkedlist.DoubleNode;
import linkedlist.client.DoubleNodeOperations;

import org.junit.Test;

public class DoubleNodeOperationsTest {

	private DoubleNodeOperations<Integer> operations = new DoubleNodeOperations<Integer>();
	
	@Test
	public void testInsertAtStart() {
		DoubleNode<Integer> first = new DoubleNode<Integer>(1);
		DoubleNode<Integer> middle = new DoubleNode<Integer>(2);
		DoubleNode<Integer> last = new DoubleNode<Integer>(3);
		
		middle.setPrevious(first);
		middle.setNext(last);
		
		operations.insertAtBeginning(0, middle);
		assertEquals(new Integer(0), first.getPrevious().getItem());
	}
	
	@Test
	public void testInsertAtEnd() {
		DoubleNode<Integer> first = new DoubleNode<Integer>(1);
		DoubleNode<Integer> middle = new DoubleNode<Integer>(2);
		DoubleNode<Integer> last = new DoubleNode<Integer>(3);
		
		middle.setPrevious(first);
		middle.setNext(last);
		
		operations.insertAtEnd(4, middle);
		assertEquals(new Integer(4), last.getNext().getItem());
	}
	
	@Test
	public void testRemoveFromstart() {
		DoubleNode<Integer> first = new DoubleNode<Integer>(1);
		DoubleNode<Integer> middle = new DoubleNode<Integer>(2);
		DoubleNode<Integer> last = new DoubleNode<Integer>(3);
		
		middle.setPrevious(first);
		middle.setNext(last);
		
		operations.removeFromBeginning(last);
		assertNull(middle.getPrevious());
		assertNull(first.getNext());
	}
	
	@Test
	public void testRemoveFromEnd() {
		DoubleNode<Integer> first = new DoubleNode<Integer>(1);
		DoubleNode<Integer> middle = new DoubleNode<Integer>(2);
		DoubleNode<Integer> last = new DoubleNode<Integer>(3);
		
		middle.setPrevious(first);
		middle.setNext(last);
		
		operations.removeFromEnd(first);
		assertNull(middle.getNext());
		assertNull(last.getPrevious());
	}
	
	@Test
	public void testInsertBefore() {
		DoubleNode<Integer> first = new DoubleNode<Integer>(1);
		DoubleNode<Integer> middle = new DoubleNode<Integer>(2);
		DoubleNode<Integer> last = new DoubleNode<Integer>(3);
		
		middle.setPrevious(first);
		middle.setNext(last);
		
		operations.insertBefore(0, middle);
		assertEquals(new Integer(0), middle.getPrevious().getItem());
		assertEquals(new Integer(0), first.getNext().getItem());
	}
	
	@Test
	public void testInsertAfter() {
		DoubleNode<Integer> first = new DoubleNode<Integer>(1);
		DoubleNode<Integer> middle = new DoubleNode<Integer>(2);
		DoubleNode<Integer> last = new DoubleNode<Integer>(3);
		
		middle.setPrevious(first);
		middle.setNext(last);
		
		operations.insertAfter(0, middle);
		assertEquals(new Integer(0), middle.getNext().getItem());
		assertEquals(new Integer(0), last.getPrevious().getItem());
	}
	
	@Test
	public void testRemove() {
		DoubleNode<Integer> first = new DoubleNode<Integer>(1);
		DoubleNode<Integer> middle = new DoubleNode<Integer>(2);
		DoubleNode<Integer> last = new DoubleNode<Integer>(3);
		
		middle.setPrevious(first);
		middle.setNext(last);
		
		operations.remove(middle);
		assertEquals(new Integer(3), first.getNext().getItem());
		assertEquals(new Integer(1), last.getPrevious().getItem());
	}

}
