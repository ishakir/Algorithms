package graph.connectedness.test;

import static org.junit.Assert.*;
import graph.AdjacancyListGraph;
import graph.Graph;
import graph.connectedness.ConnectedComponents;
import graph.connectedness.DepthFirstConnectedComponents;

import org.junit.Test;

public class DepthFirstConnectedComponentsTest {
	
	private Graph G;
	
	public DepthFirstConnectedComponentsTest() {
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
	public void testCount() {
		ConnectedComponents cc = new DepthFirstConnectedComponents(G);
		assertEquals(3, cc.count());
	}
	
	@Test
	public void test9connectedTo10() {
		ConnectedComponents cc = new DepthFirstConnectedComponents(G);
		assertTrue(cc.connected(9, 10));
	}
	
	@Test
	public void test0connectedTo4() {
		ConnectedComponents cc = new DepthFirstConnectedComponents(G);
		assertTrue(cc.connected(0, 4));
	}
	
	@Test
	public void test9notConnectedTo4() {
		ConnectedComponents cc = new DepthFirstConnectedComponents(G);
		assertFalse(cc.connected(4, 9));
	}

}
