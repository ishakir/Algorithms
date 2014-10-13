package stequeue;

public class LinkedListStequeue<Item> implements Stequeue<Item> {

	// Remove this once we've merged branches
	private class Node<Thing> {
		public Thing item;
		public Node<Thing> next;
		public String toString() { if(next == null) return item.toString(); else return item + "->" + next.toString(); }
	}
	
	private Node<Item> first;
	private Node<Item> last;
	
	@Override
	public void push(Item item) {
		Node<Item> oldFirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldFirst;
		if(last == null) {
			last = first;
		}
	}

	@Override
	public Item pop() {
		if(first == null) {
			return null;
		} else {
			Node<Item> newFirst = first.next;
			Node<Item> toReturn = first;
			first = newFirst;
			if(isEmpty()) {
				last = null;
			}
			return toReturn.item;
		}
	}

	@Override
	public void enqueue(Item item) {
		if(last == null) {
			push(item);
		} else {
			Node<Item> newLast = new Node<Item>();
			newLast.item = item;
			last.next = newLast;
			last = newLast;
		}
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public int size() {
		int counter = 0;
		Node<Item> temp = first;
		while(temp != null) {
			counter++;
			temp = temp.next;
		}
		return counter;
	}

}
