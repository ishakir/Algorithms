package basic.stack;

public interface Stack<Item> extends Iterable<Item> {
	public void push(Item item);
	public Item pop();
	public Item peek();
	public boolean isEmpty();
	public int size();
}
