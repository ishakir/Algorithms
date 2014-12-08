package search.symboltable.ordered.test;

import search.symboltable.ordered.RedBlackBinarySearchSymbolTable;

public class RedBlackBinarySearchSymbolTableTest extends OrderedSymbolTableTestBase<RedBlackBinarySearchSymbolTable<String,Integer>>{

	@Override
	protected RedBlackBinarySearchSymbolTable<String, Integer> initialize() {
		return new RedBlackBinarySearchSymbolTable<String, Integer>();
	}

}
