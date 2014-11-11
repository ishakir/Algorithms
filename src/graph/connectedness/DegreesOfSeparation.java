package graph.connectedness;

import graph.Graph;
import graph.SymbolGraph;
import graph.SymbolGraphImpl;
import graph.search.BreadthFirstPaths;
import graph.search.Paths;

public class DegreesOfSeparation {
	
	private static final String filename = "data/graph/movies.txt";
	private static final String delimiter = "/";
	private static final String star = "Bacon, Kevin";
	private static final String separated = "Kidman, Nicole";
	
	public static void main(String[] args) {
		
		SymbolGraph sg = new SymbolGraphImpl(filename, delimiter);
		Graph G = sg.G();
		
		if(!sg.contains(star)) {
			System.out.println(star + " not in database");
			return;
		}
		
		int s = sg.index(star);
		Paths bfs = new BreadthFirstPaths(G, s);
		
		if(sg.contains(separated)) {
			int t = sg.index(separated);
			if(bfs.hasPathTo(t)) {
				System.out.println("Route from '"+star+"' to '"+separated+"' is:");
				for(int v : bfs.pathTo(t)) {
					System.out.println("    "+sg.name(v));
				}
			} else {
				System.out.println("'"+star+"' not connected to '"+separated+"'");
			}
		} else {
			System.out.println(separated + " not in database");
		}
		
	}
	
}
