package graph;

import java.util.HashMap;
import java.util.Map;

import misc.io.In;

public class SymbolGraphImpl implements SymbolGraph {
	
	// TODO replace with Symbol Table impementation when done
	private Map<String, Integer> st;
	private String[] keys;
	private Graph G;
	
	public SymbolGraphImpl(String stream, String sp) {
		st = new HashMap<String, Integer>();
		In in = new In(stream);
		
		while(in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			for(int i = 0; i < a.length; i++) {
				if(!st.containsKey(a[i])) {
					st.put(a[i], st.size());
				}
			}
		}
		
		keys = new String[st.size()];
		for(String name : st.keySet()) {
			keys[st.get(name)]= name;
		}
		
		G = new AdjacancyListGraph(st.size());
		in = new In(stream);
		while(in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			int v = st.get(a[0]);
			for(int i = 1; i < a.length; i++) {
				G.addEdge(v, st.get(a[i]));
			}
		}
	}
	
	public boolean contains(String s) { return st.containsKey(s); }
	public int index(String s)        { return st.get(s); }
	public String name(int v)         { return keys[v]; }
	public Graph G()                  { return G; }
	
}