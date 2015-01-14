package search.set.math.test;

import search.set.math.SetMathSet;

public class SetMathSetTest extends MathSetTestBase<SetMathSet<Boolean>> {

	@Override
	protected SetMathSet<Boolean> instantiate(Boolean[] universe) {
		return new SetMathSet<Boolean>(universe);
	}

}
