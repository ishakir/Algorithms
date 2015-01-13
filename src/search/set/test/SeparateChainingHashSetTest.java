package search.set.test;

import search.set.SeparateChainingHashSet;

public class SeparateChainingHashSetTest extends SetTestBase<SeparateChainingHashSet<String>> {

	@Override
	protected SeparateChainingHashSet<String> initialize() {
		return new SeparateChainingHashSet<String>(16);
	}

}
