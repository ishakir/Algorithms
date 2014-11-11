package basic.bag;

public interface Bag<Item> extends Iterable<Item> {
	public void add(Item item);
	public boolean isEmpty();
	public boolean contains(Item item);
	public int size();
}
