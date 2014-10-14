package basic.stack;

public interface Stack<Item> {
	public void push(Item item);
	public Item pop();
	public boolean isEmpty();
	public int size();
}
