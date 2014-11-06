package graph.connectedness.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import graph.AdjacancyListGraph;
import graph.Graph;
import graph.connectedness.TwoColour;

import org.junit.Test;

public class TwoColourTest {
	
	@Test
	public void testNonBipartiteGraph() {
		Graph G = new AdjacancyListGraph(3);
		G.addEdge(0, 1);
		G.addEdge(1, 2);
		G.addEdge(2, 0);
		
		TwoColour tc = new TwoColour(G);
		assertFalse(tc.isBipartite());
	}
	
	@Test
	public void testBipartiteGraph() {
		Graph G = new AdjacancyListGraph(3);
		G.addEdge(0, 1);
		G.addEdge(0, 2);
		
		TwoColour tc = new TwoColour(G);
		assertTrue(tc.isBipartite());
	}

}
