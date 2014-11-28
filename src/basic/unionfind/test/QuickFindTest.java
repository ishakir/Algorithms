package basic.unionfind.test;

import basic.unionfind.QuickFind;

public class QuickFindTest extends UnionFindTestBase<QuickFind> {

	@Override
	public QuickFind instantiate(int V) {
		return new QuickFind(V);
	}

}
