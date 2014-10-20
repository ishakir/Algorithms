package linkedlist.test;

import static org.junit.Assert.*;
import linkedlist.Node;
import linkedlist.client.RemoveKthNode;

import org.junit.Test;

public class RemoveKthNodeTest {

	@Test
	public void removeFirstNodeTest() {
		Node<String> last = new Node<String>("hello", null);
		Node<String> middle = new Node<String>("sup", last);
		Node<String> first = new Node<String>("howdy", middle);
		
		RemoveKthNode<String> remover = new RemoveKthNode<>(first);
		Node<String> removed = remover.removeKth(1);
		
		Node<String> next = removed;
		while(next != null) {
			if(next.item.equals("howdy")) {
				fail();
			}
			next = next.next;
		}
	}
	
	@Test
	public void removeMiddleNodeTest() {
		Node<String> last = new Node<String>("hello", null);
		Node<String> middle = new Node<String>("sup", last);
		Node<String> first = new Node<String>("howdy", middle);
		
		RemoveKthNode<String> remover = new RemoveKthNode<>(first);
		Node<String> removed = remover.removeKth(2);
		
		Node<String> next = removed;
		while(next != null) {
			if(next.item.equals("sup")) {
				fail();
			}
			next = next.next;
		}
	}
	
	@Test
	public void removeLastNodeTest() {
		Node<String> last = new Node<String>("hello", null);
		Node<String> middle = new Node<String>("sup", last);
		Node<String> first = new Node<String>("howdy", middle);
		
		RemoveKthNode<String> remover = new RemoveKthNode<>(first);
		Node<String> removed = remover.removeKth(3);
		
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
