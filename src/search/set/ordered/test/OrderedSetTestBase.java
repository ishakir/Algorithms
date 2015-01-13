package search.set.ordered.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import search.set.ordered.OrderedSet;
import search.set.test.SetTestBase;

public abstract class OrderedSetTestBase<T extends OrderedSet<String>> extends SetTestBase<T> {

	@Test
	public void testMinIsFirstElement() {
		OrderedSet<String> os = initialize();
		os.add("hello");
		assertEquals("hello", os.min());
	}

	@Test
	public void testMaxIsFirstElement() {
		OrderedSet<String> os = initialize();
		os.add("hello");
		assertEquals("hello", os.max());
	}
	
	@Test
	public void testMinIsSmallestElement() {
		OrderedSet<String> os = initialize();
		os.add("a");
		os.add("b");
		assertEquals("a", os.min());
	}
	
	@Test
	public void testMaxIsLargestElement() {
		OrderedSet<String> os = initialize();
		os.add("a");
		os.add("b");
		assertEquals("b", os.max());
	}
	
	@Test
	public void testFloorGivesSmallestElement() {
		OrderedSet<String> os = initialize();
		os.add("aaa");
		os.add("bbb");
		assertEquals("aaa", os.floor("abb"));
	}
	
	@Test
	public void testCeilGivesLargestElement() {
		OrderedSet<String> os = initialize();
		os.add("aaa");
		os.add("bbb");
		assertEquals("bbb", os.ceil("abb"));
	}
	
	@Test
	public void testRank() {
		OrderedSet<String> os = initialize();
		os.add("aaa");
		os.add("bbb");
		assertEquals(0, os.rank("aaa"));
		assertEquals(1, os.rank("bbb"));
	}
	
	@Test
	public void testSelect() {
		OrderedSet<String> os = initialize();
		os.add("aaa");
		os.add("bbb");
		assertEquals("aaa", os.select(0));
		assertEquals("bbb", os.select(1));
	}
	
	@Test
	public void testSize() {
		OrderedSet<String> os = initialize();
		os.add("aaa");
		os.add("bbb");
		os.add("ccc");
		assertEquals(3, os.size("aaa", "ccc"));
	}
	
}
