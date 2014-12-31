package search.set.test;

import search.set.SequentialSearchSet;

public class SequentialSearchSetTest extends SetTestBase<SequentialSearchSet<String>> {

	@Override
	protected SequentialSearchSet<String> initialize() {
		return new SequentialSearchSet<String>();
	}

}
