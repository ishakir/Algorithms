package graph.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import graph.Graph;
import graph.client.FileGraphReader;

import org.junit.Test;

public class FileGraphReaderTest {

	private Graph G;
	
	public FileGraphReaderTest() {
		G = new FileGraphReader("data/graph/tinyGen2.txt").read();
	}
	
	@Test
	public void testCorrectNumberOfEdges() {
		assertEquals(16, G.E());
	}
	
	@Test
	public void testCorrectNumberOfVertices() {
		assertEquals(12, G.V());
	}
	
	@Test
	public void testEdge() {
		assertTrue(G.hasEdge(0, 2));
	}

}
