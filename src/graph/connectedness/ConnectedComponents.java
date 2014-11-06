package graph.connectedness;

public interface ConnectedComponents {
	
	boolean connected(int v, int w);
	int count();
	int id(int v);
	
}
