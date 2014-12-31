package search.set.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import search.set.Set;

public abstract class SetTestBase<T extends Set<String>> {

	protected abstract T initialize();
	
	@Test
	public void testCanPutAndGet() {
		Set<String> st = initialize();
		st.add("hello");
		assertTrue(st.contains("hello"));
	}
	
	@Test
	public void emptySymbolTableIsEmpty() {
		Set<String> st = initialize();
		assertTrue(st.isEmpty());
	}
	
	@Test
	public void symbolTableWithElementInIsNonEmpty() {
		Set<String> st = initialize();
		st.add("hello");
		assertFalse(st.isEmpty());
	}
	
	@Test
	public void addRemoveLeavesTableEmpty() {
		Set<String> st = initialize();
		st.add("hello");
		st.delete("hello");
		assertTrue(st.isEmpty());
	}
	
	@Test
	public void sizeIsKeptCorrecty() {
		Set<String> st = initialize();
		st.add("hello");
		st.add("goodbye");
		assertEquals(2, st.size());
	}
	
	@Test
	public void stDoesNotContainElement() {
		Set<String> st = initialize();
		st.add("hello");
		assertFalse(st.contains("goodbye"));
	}

}
