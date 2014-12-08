package search.symboltable.ordered.test;

import search.symboltable.ordered.BinarySearchSymbolTable;
import search.symboltable.test.SymbolTableTestBase;

public class BinarySearchSymbolTableTest extends OrderedSymbolTableTestBase<BinarySearchSymbolTable<String, Integer>>{

	@Override
	protected BinarySearchSymbolTable<String, Integer> initialize() {
		return new BinarySearchSymbolTable<String, Integer>(5);
	}

}
