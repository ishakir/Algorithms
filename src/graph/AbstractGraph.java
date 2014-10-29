package graph;

public abstract class AbstractGraph implements Graph {
	
	public int degree(int v) {
		int degree = 0;
		for(int w : adj(v)) degree++;
		return degree;
	}
	
	public int maxDegree() {
		int max = 0;
		for(int v = 0; v < V(); v++) {
			if(degree(v) > max) {
				max = degree(v);
			}
		}
		return max;
	}
	
	public int avgDegree() {
		return 2 * E() / V();
	}
	
	public int numberOfSelfLoops() {
		int count = 0;
		for(int v = 0; v < V(); v++) {
			for(int w : adj(v)) {
				if(v == w) count++;
			}
		}
		return count / 2;
	}
	
	public String toString() {
		String s = V() + " verticies, " + E()  + " edges\n";
		for(int v = 0; v < V(); v++) {
			s += v + ": ";
			for(int w : adj(v)) {
				s += w + " ";
			}
			s += "\n";
		}
		return s;
	}
	
}
