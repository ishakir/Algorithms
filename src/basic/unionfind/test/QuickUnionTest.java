package basic.unionfind.test;

import basic.unionfind.QuickUnion;

public class QuickUnionTest extends UnionFindTestBase<QuickUnion> {

	@Override
	public QuickUnion instantiate(int V) {
		return new QuickUnion(V);
	}

}
