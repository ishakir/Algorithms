package basic.deque;

public interface Deque<Item> {
	
	boolean isEmpty();
	int size();
	
	void pushLeft(Item item);
	void pushRight(Item item);
	
	Item popLeft();
	Item popRight();
	
}
