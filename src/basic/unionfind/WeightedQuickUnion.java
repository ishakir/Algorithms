package basic.unionfind;

public class WeightedQuickUnion extends UnionFind {

	private int[] sz;
	
	public WeightedQuickUnion(int N) {
		super(N);
		sz = new int[N];
		for(int i = 0; i < N; i++) {
			sz[i] = 1;
		}
	}
	
	@Override
	protected int find(int p) {
		while(p != id[p]) p = id[p];
		return p;
	}

	@Override
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if(i == j) return;
		
		if(sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
	}
	
	@Override
	public void printState() {
		super.printState();
		for(int i = 0; i < sz.length; i++) {
			System.out.print(sz[i] + ",");
		}
		System.out.println();
		System.out.println();
	}

}
