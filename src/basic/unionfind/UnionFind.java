package basic.unionfind;

public abstract class UnionFind {
	
	protected int[] id;
	protected int count;
	
	public UnionFind(int N) {
		count = N;
		id = new int[N];
		for(int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	public int count() {
		return count;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	protected abstract int find(int p);
	public abstract void union(int p, int q);
	
	public void printState() {
		for(int i = 0; i < id.length; i++) {
			System.out.print(id[i] + ",");
		}
		System.out.println();
	}

}
