package graph.search.test;

import static org.junit.Assert.*;
import graph.AdjacancyListGraph;
import graph.Graph;
import graph.search.client.NonConnectedBreakingNode;

import org.junit.Test;

public class NonConnectedBreakingNodeTest {

	private NonConnectedBreakingNode finder;
	
	public NonConnectedBreakingNodeTest() {
		Graph G = new AdjacancyListGraph(5);
		G.addEdge(0, 4);
		G.addEdge(1, 4);
		G.addEdge(2, 4);
		G.addEdge(3, 4);
		
		finder = new NonConnectedBreakingNode(G);
	}
	
	@Test
	public void testFinalIsnt4startingFrom0() {
		assertFalse(finder.find(0) == 4);
	}
	
	@Test
	public void testFinalIsnt4startingFrom1() {
		assertFalse(finder.find(1) == 4);
	}
	
	@Test
	public void testFinalIsnt4startingFrom2() {
		assertFalse(finder.find(2) == 4);
	}
	
	@Test
	public void testFinalIsnt4startingFrom3() {
		assertFalse(finder.find(3) == 4);
	}
	
	@Test
	public void testFinalIsnt4startingFrom4() {
		assertFalse(finder.find(4) == 4);
	}

}
