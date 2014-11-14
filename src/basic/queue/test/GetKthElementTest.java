package basic.queue.test;

import static org.junit.Assert.*;

import org.junit.Test;

import basic.queue.client.GetKthElement;

public class GetKthElementTest {
	
	private final String stringToFind = "FINDME!";
	
	@Test
	public void testgetKthElement() {
		GetKthElement finder = new GetKthElement();
		finder.add("A string");
		finder.add(stringToFind);
		finder.add("Another String");
		
		assertEquals(stringToFind, finder.getKthAdded(2));}

}
