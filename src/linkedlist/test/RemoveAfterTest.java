package linkedlist.test;

import static org.junit.Assert.*;
import linkedlist.Node;
import linkedlist.client.RemoveAfter;

import org.junit.Test;

public class RemoveAfterTest {

	@Test
	public void testRemoveNext() {
		Node<String> last = new Node<String>("hello", null);
		Node<String> middle = new Node<String>("sup", last);
		Node<String> first = new Node<String>("howdy", middle);
		
		RemoveAfter<String> remover = new RemoveAfter<String>(first);
		Node<String> removed = remover.removeAfter();
		
		assertEquals(removed.next, last);
	}
	
	@Test
	public void testDoNothingIfNextNull() {
		Node<String> first = new Node<String>("hello", null);
		
		RemoveAfter<String> remover = new RemoveAfter<String>(first);
		Node<String> removed = remover.removeAfter();
		
		assertNull(removed.next);
	}
}
