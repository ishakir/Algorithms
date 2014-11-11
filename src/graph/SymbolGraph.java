package graph;

public interface SymbolGraph {
	
	boolean contains(String key);
	int index(String key);
	String name(int v);
	Graph G();
	
}
