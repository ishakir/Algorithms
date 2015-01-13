package search.set.ordered.test;

import search.set.ordered.BinarySearchSet;

public class BinarySearchSetTest extends OrderedSetTestBase<BinarySearchSet<String>> {

	@Override
	protected BinarySearchSet<String> initialize() {
		return new BinarySearchSet<String>(16);
	}

}
