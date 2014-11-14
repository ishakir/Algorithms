package linkedlist.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import linkedlist.Node;
import linkedlist.client.Remove;

import org.junit.Test;

public class RemoveTest {
	
	private final String stringToRemove = "REMOVE ME!!";
	
	@Test
	public void testRemovesOneElement() {
		Node<String> toRemove = new Node<String>(stringToRemove, null);
		Node<String> first = new Node<String>("Another String", toRemove);
		
		Remove remove = new Remove(first);
		remove.remove(stringToRemove);
		
		assertNull(first.next);
	}
	
	@Test
	public void testRemovesFirstElement() {
		Node<String> last = new Node<String>("A string", null);
		Node<String> first = new Node<String>(stringToRemove, last);
		
		Remove remove = new Remove(first);
		Node<String> newFirst = remove.remove(stringToRemove);
		
		assertEquals(last, newFirst);
	}
	
	@Test
	public void testRemovesTwoMiddleElements() {
		Node<String> last = new Node<String>("A string", null);
		Node<String> removeOne = new Node<String>(stringToRemove, last);
		Node<String> removeTwo = new Node<String>(stringToRemove, removeOne);
		Node<String> first = new Node<String>("Another String", removeTwo);
		
		Remove remove = new Remove(first);
		remove.remove(stringToRemove);
		
		assertEquals(first.next, last);
	}

}
