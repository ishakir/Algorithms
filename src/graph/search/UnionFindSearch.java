package graph.search;

import graph.Graph;
import basic.unionfind.UnionFind;
import basic.unionfind.WeightedQuickUnion;

public class UnionFindSearch implements Search {
	
	private UnionFind uf;
	private int v;
	
	public UnionFindSearch(Graph G, int v) {
		uf = new WeightedQuickUnion(G.V());
		
		for(int i = 0; i < G.V(); i++) {
			for(int j : G.adj(i)) {
				uf.union(i, j);
			}
		}
	}
	
	@Override
	public boolean marked(int s) {
		return uf.connected(v, s);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
