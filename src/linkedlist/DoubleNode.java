package linkedlist;

public class DoubleNode<Item> {
	
	private final Item item;
	private DoubleNode<Item> previous;
	private DoubleNode<Item> next;
	
	public DoubleNode(Item item) {
		this.item = item;
	}
	
	public DoubleNode(Item item, DoubleNode<Item> previous, DoubleNode<Item> next) {
		this.item = item;
		setPrevious(previous);
		setNext(next);
	}
	
	public void setPrevious(DoubleNode<Item> previous) {
		this.previous = previous;
		previous.next = this;
	}
	
	public void setNext(DoubleNode<Item> next) {
		this.next = next;
		next.previous = this;
	}
	
	public DoubleNode<Item> getNext() {
		return this.next;
	}
	
	public DoubleNode<Item> getPrevious() {
		return this.previous;
	}
	
	public void detachPrevious() {
		previous.next = null;
		this.previous = null;
	}
	
	public void detachNext() {
		next.previous = null;
		this.next = null;
	}
	
	public Item getItem() {
		return this.item;
	}

}
