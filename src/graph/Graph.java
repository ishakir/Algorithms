package graph;

public interface Graph {
	int V();
	int E();
	void addEdge(int v, int w);
	boolean hasEdge(int v, int w);
	Iterable<Integer> adj(int v);
	String toString();
}
