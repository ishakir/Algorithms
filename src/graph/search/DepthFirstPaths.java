package graph.search;

import graph.Graph;
import basic.stack.LinkedListStack;
import basic.stack.Stack;

public class DepthFirstPaths implements Paths {

	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	
	public DepthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v) {
		marked[v] = true;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}
	
	@Override
	public boolean hasPathTo(int v) {
		return marked[v];
	}

	@Override
	public Iterable<Integer> pathTo(int v) {
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new LinkedListStack<Integer>();
		for(int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}

}
