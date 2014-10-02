package bag;

public interface Bag<Item> extends Iterable<Item> {
	public void add(Item item);
	public boolean isEmpty();
	public int size();
}
