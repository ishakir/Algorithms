package search.set.math.test;

import search.set.math.SeparateChainingHashMathSet;

public class SeparateChainingHashMathSetTest extends MathSetTestBase<SeparateChainingHashMathSet<Boolean>> {


	@Override
	protected SeparateChainingHashMathSet<Boolean> instantiate(
			Boolean[] universe) {
		return new SeparateChainingHashMathSet<Boolean>(universe);
	}

}
