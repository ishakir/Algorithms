package search.symboltable.ordered.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import search.symboltable.ordered.OrderedSymbolTable;
import search.symboltable.test.SymbolTableTestBase;

public abstract class OrderedSymbolTableTestBase<T extends OrderedSymbolTable<String, Integer>> extends SymbolTableTestBase<T>{

	@Test
	public void testMinIsFirstElement() {
		OrderedSymbolTable<String, Integer> ost = initialize();
		ost.put("hello", 7);
		assertEquals("hello", ost.min());
	}
	
	@Test
	public void testMaxIsFirstElement() {
		OrderedSymbolTable<String, Integer> ost = initialize();
		ost.put("hello", 7);
		assertEquals("hello", ost.max());
	}
	
	@Test
	public void testMinIsSmallestElement() {
		OrderedSymbolTable<String, Integer> ost = initialize();
		ost.put("a", 7);
		ost.put("b", 8);
		assertEquals("a", ost.min());
	}
	
	@Test
	public void testMaxIsLargestElement() {
		OrderedSymbolTable<String, Integer> ost = initialize();
		ost.put("a", 7);
		ost.put("b", 8);
		assertEquals("b", ost.max());
	}
	
	@Test
	public void testFloorGivesSmallestElement() {
		OrderedSymbolTable<String, Integer> ost = initialize();
		ost.put("aaa", 7);
		ost.put("bbb", 8);
		assertEquals("aaa", ost.floor("abb"));
	}
	
	@Test
	public void testCeilGivesLargestElement() {
		OrderedSymbolTable<String, Integer> ost = initialize();
		ost.put("aaa", 7);
		ost.put("bbb", 8);
		assertEquals("bbb", ost.ceil("abb"));
	}
	
	@Test
	public void testRank() {
		OrderedSymbolTable<String, Integer> ost = initialize();
		ost.put("aaa", 7);
		ost.put("bbb", 8);
		assertEquals(0, ost.rank("aaa"));
		assertEquals(1, ost.rank("bbb"));
	}
	
	@Test
	public void testSelect() {
		OrderedSymbolTable<String, Integer> ost = initialize();
		ost.put("aaa", 7);
		ost.put("bbb", 8);
		assertEquals("aaa", ost.select(0));
		assertEquals("bbb", ost.select(1));
	}
	
	@Test
	public void testSize() {
		OrderedSymbolTable<String, Integer> ost = initialize();
		ost.put("aaa", 7);
		ost.put("bbb", 8);
		ost.put("ccc", 9);
		assertEquals(3, ost.size("aaa", "ccc"));
	}
	
}
