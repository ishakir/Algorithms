package search.test;

import search.BinarySearchSymbolTable;

public class BinarySearchSymbolTableTest extends SymbolTableTestBase<BinarySearchSymbolTable<String, Integer>>{

	@Override
	protected BinarySearchSymbolTable<String, Integer> initialize() {
		return new BinarySearchSymbolTable<String, Integer>(5);
	}

}
