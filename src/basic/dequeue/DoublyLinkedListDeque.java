package basic.dequeue;

public class DoublyLinkedListDeque<Item> implements Deque<Item> {

	private class Node<Thing> {
		public Node<Thing> left;
		public Node<Thing> right;
		public Thing item;
		public String toString() {
			if(right == null) return item.toString(); else return item + "<->" + right.toString();
		}
	}
	
	private Node<Item> left;
	private Node<Item> right;
	
	@Override
	public boolean isEmpty() {
		return left == null;
	}

	@Override
	public int size() {
		int counter = 0;
		Node<Item> temp = new Node<Item>();
		while(temp != null) {
			counter++;
			temp = temp.right;
		}
		return counter;
	}

	@Override
	public void pushLeft(Item item) {
		Node<Item> oldLeft = left;
		Node<Item> newLeft = new Node<Item>();
		newLeft.right = oldLeft;
		if(oldLeft != null) {
			oldLeft.left = newLeft;
		}
		newLeft.item = item;
		if(isEmpty()) {
			right = newLeft;
		}
		left = newLeft;
	}

	@Override
	public void pushRight(Item item) {
		Node<Item> oldRight = right;
		Node<Item> newRight = new Node<Item>();
		newRight.left = oldRight;
		if(oldRight != null) {
			oldRight.right = newRight;
		}
		newRight.item = item;
		if(isEmpty()) {
			left = newRight;
		}
		right = newRight;
	}

	@Override
	public Item popLeft() {
		if(isEmpty()) {
			return null;
		}
		Item toReturn = left.item;
		left = left.right;
		if(left == null) {
			right = null;
		} else {
			left.left = null;
		}
		return toReturn;
	}

	@Override
	public Item popRight() {
		if(isEmpty()) {
			return null;
		}
		Item toReturn = right.item;
		right = right.left;
		if(right == null) {
			left = null;
		} else {
			right.right = null;
		}
		return toReturn;
	}

}
