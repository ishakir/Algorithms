package linkedlist;

public class Node<Item> {
	public Item item;
	public Node<Item> next;

	public Node(Item item, Node<Item> next) {
		this.item = item;
		this.next = next;
	}
	
	@Override
	public String toString() {
		if(next == null) {
			return item.toString();
		} else {
			return item + "->" + next.toString();
		}
	}
}
