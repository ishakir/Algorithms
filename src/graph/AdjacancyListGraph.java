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
	
	// Copy constructor, complexity potentially (definitely!) too high
	// Mostly because Bag.contains is O(n), maybe HashSet is a better data structure?
	public AdjacancyListGraph(Graph G) {
		this.V = G.V(); this.E = G.E();
		adj = (Bag<Integer>[]) new Bag[V];
		// Double loop, but always ends up being E operations
		for(int v= 0; v < V; v++) {
			adj[v] = new LinkedListBag<Integer>();
			for(int a : G.adj(v)) {
				if(!adj[v].contains(a)) {
					addEdge(v, a);
				}
			}
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
	public boolean hasEdge(int v, int w) {
		return adj[v].contains(w);
	}

	@Override
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

}
