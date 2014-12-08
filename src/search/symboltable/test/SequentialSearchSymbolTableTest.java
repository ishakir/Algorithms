package search.symboltable.test;

import search.symboltable.SequentialSearchSymbolTable;

public class SequentialSearchSymbolTableTest extends SymbolTableTestBase<SequentialSearchSymbolTable<String,Integer>>{

	@Override
	protected SequentialSearchSymbolTable<String, Integer> initialize() {
		return new SequentialSearchSymbolTable<String, Integer>();
	}

}
