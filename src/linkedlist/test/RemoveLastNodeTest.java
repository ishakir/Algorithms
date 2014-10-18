package linkedlist.test;

import static org.junit.Assert.*;
import linkedlist.Node;
import linkedlist.client.RemoveLastNode;

import org.junit.Test;

public class RemoveLastNodeTest {

	@Test
	public void testRemoveLastNode() {
		Node<String> last = new Node<String>("hello", null);
		Node<String> middle = new Node<String>("sup", last);
		Node<String> first = new Node<String>("howdy", middle);
		
		RemoveLastNode<String> remover = new RemoveLastNode<String>(first);
		Node<String> removed = remover.remove();
		
		Node<String> next = removed;
		while(next != null) {
			System.out.println(next);
			if(next.item.equals("hello")) {
				fail();
			}
			next = next.next;
		}
	}

}
