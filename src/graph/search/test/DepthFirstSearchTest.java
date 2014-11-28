package graph.search.test;

import graph.Graph;
import graph.search.DepthFirstSearch;

public class DepthFirstSearchTest extends SearchTestBase<DepthFirstSearch> {

	@Override
	protected DepthFirstSearch instantiate(Graph G, int s) {
		return new DepthFirstSearch(G, s);
	}

}
