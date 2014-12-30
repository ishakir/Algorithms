package search.symboltable.test;

import search.symboltable.SeparateChainingHashSymbolTable;

public class SeparateChainingHashSymbolTableTest extends SymbolTableTestBase<SeparateChainingHashSymbolTable<String,Integer>> {

	@Override
	protected SeparateChainingHashSymbolTable<String, Integer> initialize() {
		return new SeparateChainingHashSymbolTable<String, Integer>();
	}

}
