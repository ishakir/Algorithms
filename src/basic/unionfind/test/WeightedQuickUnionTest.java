package basic.unionfind.test;

import basic.unionfind.WeightedQuickUnion;

public class WeightedQuickUnionTest extends UnionFindTestBase<WeightedQuickUnion> {

	@Override
	public WeightedQuickUnion instantiate(int V) {
		return new WeightedQuickUnion(V);
	}

}
