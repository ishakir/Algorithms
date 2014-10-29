package graph;

import basic.bag.Bag;
import basic.bag.LinkedListBag;

public class AdjacancyListGraph extends AbstractGraph {
	
	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	
	public AdjacancyListGraph(int V) {
		this.V = V; this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0; v < V; v++) {
			adj[v] = new LinkedListBag<Integer>();
		}
	}
	
	@Override
	public int V() {
		return V;
	}

	@Override
	public int E() {
		return E;
	}

	@Override
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}

	@Override
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

}
