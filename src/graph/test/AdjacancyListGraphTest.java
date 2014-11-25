package graph.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import graph.AdjacancyListGraph;
import graph.Graph;

import org.junit.Test;

public class AdjacancyListGraphTest {
	
	private Graph G;
	
	public AdjacancyListGraphTest() {
		G = new AdjacancyListGraph(3);
		G.addEdge(0, 1);
	}
	
	@Test
	public void testInitialGraphHasCorrectNoVerticies() {
		G = new AdjacancyListGraph(3);
		assertEquals(3, G.V());
	}
	
	@Test
	public void testCopyConstructorHasEdge() {
		Graph GC = new AdjacancyListGraph(G);
		assertTrue(GC.hasEdge(0, 1));
	}
	
	@Test
	public void testCopyConstructorHasRightNumberOfEdges() {
		Graph GC = new AdjacancyListGraph(G);
		assertEquals(1, GC.E());
	}
	
	@Test
	public void testCopyConstructorHasRightNumberOfVertices() {
		Graph GC = new AdjacancyListGraph(G);
		assertEquals(3, GC.V());
	}
	
	@Test
	public void copyConstructorIsADeepCopy() {
		Graph GC = new AdjacancyListGraph(G);
		Graph GC2 = new AdjacancyListGraph(GC);
		GC.addEdge(1, 2);
		assertEquals(1, GC2.E());
	}
	
	@Test
	public void testHasEdgeWhenEdgeExists() {
		assertTrue(G.hasEdge(0, 1));
	}
	
	@Test
	public void testHasEdgeWhenNoEdgeExists() {
		assertFalse(G.hasEdge(0, 2));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCannotAddSelfLoops() {
		G.addEdge(0, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCannotAddParallelEdges() {
		G.addEdge(0, 1);
	}

}
