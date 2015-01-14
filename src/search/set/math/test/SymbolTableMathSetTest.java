package search.set.math.test;

import search.set.math.SymbolTableMathSet;

public class SymbolTableMathSetTest extends MathSetTestBase<SymbolTableMathSet<Boolean>> {


	@Override
	protected SymbolTableMathSet<Boolean> instantiate(
			Boolean[] universe) {
		return new SymbolTableMathSet<Boolean>(universe);
	}

}
