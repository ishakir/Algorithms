package stack.test;

import static org.junit.Assert.*;

import org.junit.Test;

import stack.client.Binary;

public class BinaryTest {

	@Test
	public void test() {
		Binary binary = new Binary(50);
		assertEquals("110010", binary.binaryRep());
	}

}
