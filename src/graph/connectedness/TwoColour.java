package graph.connectedness;

import graph.Graph;

public class TwoColour {
	
	private boolean[] marked;
	private boolean[] colour;
	private boolean isTwoColourable = true;
	
	public TwoColour(Graph G) {
		marked = new boolean[G.V()];
		colour = new boolean[G.V()];
		for(int s = 0; s < G.V(); s++) {
			if(!marked[s]) {
				dfs(G, s);
			}
		}
	}
	
	private void dfs(Graph G, int v) {
		marked[v] = true;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				colour[w] = !colour[v];
				dfs(G, w);
			} else if(colour[w] == colour[v]) {
				isTwoColourable = false;
			}
		}
	}
	
	public boolean isBipartite() {
		return isTwoColourable;
	}

}
