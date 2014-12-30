package search.symboltable.test;

import search.symboltable.LinearProbingHashSymbolTable;

public class LinearProbingHashSymbolTableTest extends SymbolTableTestBase<LinearProbingHashSymbolTable<String,Integer>> {

	@Override
	protected LinearProbingHashSymbolTable<String, Integer> initialize() {
		return new LinearProbingHashSymbolTable<String, Integer>();
	}

}
