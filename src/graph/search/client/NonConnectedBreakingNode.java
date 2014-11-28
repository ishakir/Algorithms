package graph.search.client;

import graph.Graph;

public class NonConnectedBreakingNode {
	
	private Graph G;
	
	private boolean[] marked;
	private int count;
	
	private int foundVertex;
	
	public NonConnectedBreakingNode(Graph G) {
		this.G = G;
		marked = new boolean[G.V()];
	}
	
	public int find(int start) {
		dfs(start);
		return foundVertex;
	}
	
	private void dfs(int start) {
		marked[start] = true;
		count++;
		if(count == G.V() - 1) {
			foundVertex = start;
		}
		for(int w : G.adj(start)) {
			if(!marked[w]) dfs(w);
		}
	}

}
