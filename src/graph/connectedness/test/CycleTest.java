package graph.connectedness.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import graph.AdjacancyListGraph;
import graph.Graph;
import graph.connectedness.Cycle;

import org.junit.Test;

public class CycleTest {
	
	private Graph G;
	
	public CycleTest() {
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
	
	@Test
	public void testCycleExists() {
		Cycle cycle = new Cycle(G);
		assertTrue(cycle.hasCycle());
	}
	
	@Test
	public void testCycleDoesNotExist() {
		Graph graph = new AdjacancyListGraph(3);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		
		Cycle cycle = new Cycle(graph);
		assertFalse(cycle.hasCycle());
	}

}
