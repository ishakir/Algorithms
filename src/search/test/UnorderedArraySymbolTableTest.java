package search.test;

import search.UnorderedArraySymbolTable;

public class UnorderedArraySymbolTableTest extends SymbolTableTestBase<UnorderedArraySymbolTable<String,Integer>> {

	@Override
	protected UnorderedArraySymbolTable<String, Integer> initialize() {
		return new UnorderedArraySymbolTable<String, Integer>(10);
	}

}
