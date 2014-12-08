package search.symboltable.test;

import static org.junit.Assert.*;

import org.junit.Test;

import search.symboltable.SymbolTable;

public abstract class SymbolTableTestBase<T extends SymbolTable<String, Integer>> {

	protected abstract T initialize();
	
	@Test
	public void testCanPutAndGet() {
		SymbolTable<String, Integer> st = initialize();
		st.put("hello", 7);
		assertEquals(new Integer(7), st.get("hello"));
	}
	
	@Test
	public void emptySymbolTableIsEmpty() {
		SymbolTable<String, Integer> st = initialize();
		assertTrue(st.isEmpty());
	}
	
	@Test
	public void symbolTableWithElementInIsNonEmpty() {
		SymbolTable<String, Integer> st = initialize();
		st.put("hello", 7);
		assertFalse(st.isEmpty());
	}
	
	@Test
	public void addRemoveLeavesTableEmpty() {
		SymbolTable<String, Integer> st = initialize();
		st.put("hello", 7);
		st.delete("hello");
		assertTrue(st.isEmpty());
	}
	
	@Test
	public void sizeIsKeptCorrecty() {
		SymbolTable<String, Integer> st = initialize();
		st.put("hello", 7);
		st.put("goodbye", 9);
		assertEquals(2, st.size());
	}
	
	@Test
	public void stDoesContainElement() {
		SymbolTable<String, Integer> st = initialize();
		st.put("hello", 7);
		assertTrue(st.contains("hello"));
	}
	
	@Test
	public void stDoesNotContainElement() {
		SymbolTable<String, Integer> st = initialize();
		st.put("hello", 7);
		assertFalse(st.contains("goodbye"));
	}

}
