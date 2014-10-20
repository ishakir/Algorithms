package linkedlist.test;

import static org.junit.Assert.*;
import linkedlist.Node;
import linkedlist.client.Find;

import org.junit.Test;

public class FindTest {

	@Test
	public void testFindFirst() {
		Node<String> last = new Node<String>("hello", null);
		Node<String> middle = new Node<String>("sup", last);
		Node<String> first = new Node<String>("howdy", middle);
		
		Find<String> finder = new Find<String>(first);
		assertTrue(finder.find("howdy"));
	}
	
	@Test
	public void testFindMiddle() {
		Node<String> last = new Node<String>("hello", null);
		Node<String> middle = new Node<String>("sup", last);
		Node<String> first = new Node<String>("howdy", middle);
		
		Find<String> finder = new Find<String>(first);
		assertTrue(finder.find("sup"));
	}
	
	@Test
	public void testFindLast() {
		Node<String> last = new Node<String>("hello", null);
		Node<String> middle = new Node<String>("sup", last);
		Node<String> first = new Node<String>("howdy", middle);
		
		Find<String> finder = new Find<String>(first);
		assertTrue(finder.find("hello"));
	}
	
	@Test
	public void testNotFound() {
		Node<String> last = new Node<String>("hello", null);
		Node<String> middle = new Node<String>("sup", last);
		Node<String> first = new Node<String>("howdy", middle);
		
		Find<String> finder = new Find<String>(first);
		assertFalse(finder.find("dude"));
	}

}
