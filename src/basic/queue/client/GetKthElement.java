package basic.queue.client;

import basic.queue.Queue;
import basic.queue.ResizingArrayQueue;

public class GetKthElement {
	
	private Queue<String> strings;
	
	public GetKthElement() {
		strings = new ResizingArrayQueue<String>(10);
	}
	
	public void add(String string) {
		strings.enqueue(string);
	}
	
	public String getKthAdded(int k) {
		while(k > 1) {
			strings.dequeue();
			k--;
		}
		return strings.dequeue();
	}
	
}
