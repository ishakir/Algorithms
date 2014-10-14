package basic.unionfind;

public class QuickFind extends UnionFind {

	public QuickFind(int N) {
		super(N);
	}

	@Override
	public int find(int p) {
		return id[p];
	}

	@Override
	public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		
		if(pID == qID) return;
		
		for(int i = 0; i < id.length; i++) {
			if(id[i] == pID) id[i] = qID;
		}
		count--;
	}
	
}
