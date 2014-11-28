package graph.search.test;

import static org.junit.Assert.*;
import graph.AdjacancyListGraph;
import graph.Graph;
import graph.search.Search;

import org.junit.Test;

public abstract class SearchTestBase<T extends Search> {
	
	private Graph G;
	
	public SearchTestBase() {
		G = new AdjacancyListGraph(13);
		
		G.addEdge(0, 5);
		G.addEdge(4, 3);
		G.addEdge(0, 1);
		G.addEdge(9, 12);
		G.addEdge(6, 4);
		G.addEdge(5, 4);
		G.addEdge(0, 2);
		G.addEdge(11, 12);
		G.addEdge(9, 10);
		G.addEdge(0, 6);
		G.addEdge(7, 8);
		G.addEdge(9, 11);
		G.addEdge(5, 3);
	}
	
	protected abstract T instantiate(Graph G, int s);
	
//	@Test
//	public void test0connectedTo1() {
//		Search search = instantiate(G, 0);
//		assertTrue(search.marked(1));
//	}
	
	@Test
	public void test1notConnectedTo7() {
		Search search = instantiate(G, 7);
		assertFalse(search.marked(1));
	}
	
//	@Test
//	public void testConnectedSubComponentOf7size() {
//		Search search = instantiate(G, 7);
//		assertEquals(2, search.count());
//	}
//	
//	@Test
//	public void testConnectedSubComponentOf0size() {
//		Search search = instantiate(G, 0);
//		assertEquals(7, search.count());
//	}
//	
//	@Test
//	public void testConnectedSubComponentOf9size() {
//		Search search = instantiate(G, 9);
//		assertEquals(4, search.count());
//	}

}
