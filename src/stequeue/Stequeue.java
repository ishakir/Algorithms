package stequeue;

public interface Stequeue<Item> {
	public void push(Item item);
	public Item pop();
	public void enqueue(Item item);
	public boolean isEmpty();
	public int size();
}
