package basic.unionfind.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import basic.unionfind.UnionFind;

public abstract class UnionFindTestBase<T extends UnionFind> {

	private T uf;
	private T G;

	public UnionFindTestBase() {
		uf = instantiate(10);

		uf.union(4, 3);
		uf.union(3, 8);
		uf.union(6, 5);
		uf.union(9, 4);
		uf.union(2, 1);
		uf.union(8, 9);
		uf.union(5, 0);
		uf.union(7, 2);
		uf.union(6, 1);
		uf.union(1, 0);
		uf.union(6, 7);
		
		G = instantiate(13);
		
		G.union(0, 5);
		G.union(4, 3);
		G.union(0, 1);
		G.union(9, 12);
		G.union(6, 4);
		G.union(5, 4);
		G.union(0, 2);
		G.union(11, 12);
		G.union(9, 10);
		G.union(0, 6);
		G.union(7, 8);
		G.union(9, 11);
		G.union(5, 3);
	}

	public abstract T instantiate(int V);

//	@Test
//	public void test1and6connected() {
//		assertTrue(uf.connected(1, 6));
//	}
//
//	@Test
//	public void test0and7connected() {
//		assertTrue(uf.connected(0, 7));
//	}
//
//	@Test
//	public void test8and9connected() {
//		assertTrue(uf.connected(8, 9));
//	}
//
//	@Test
//	public void test0and9notConnected() {
//		assertFalse(uf.connected(0, 9));
//	}
//
//	@Test
//	public void testCountIs2() {
//		assertEquals(2, uf.count());
//	}
	
	@Test
	public void test1notConnectedTo7() {
		assertFalse(G.connected(0, 7));
	}
	
}
