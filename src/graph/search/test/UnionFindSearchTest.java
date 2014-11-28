package graph.search.test;

import graph.Graph;
import graph.search.UnionFindSearch;

public class UnionFindSearchTest extends SearchTestBase<UnionFindSearch> {

	@Override
	protected UnionFindSearch instantiate(Graph G, int s) {
		return new UnionFindSearch(G, s);
	}

}
