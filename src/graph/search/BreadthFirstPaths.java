package graph.search;

import graph.Graph;
import basic.queue.LinkedListQueue;
import basic.queue.Queue;
import basic.stack.LinkedListStack;
import basic.stack.Stack;

public class BreadthFirstPaths implements Paths {
	
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	
	public BreadthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}
	
	private void bfs(Graph G, int s) {
		Queue<Integer> queue = new LinkedListQueue<Integer>();
		marked[s] = true;
		queue.enqueue(s);
		while(!queue.isEmpty()) {
			int v = queue.dequeue();
			for(int w : G.adj(v)) {
				if(!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					queue.enqueue(w);
				}
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
