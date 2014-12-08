package search.symboltable.ordered.test;

import search.symboltable.ordered.OrderedSequentialSearchSymbolTable;

public class OrderedSequentialSearchSymbolTableTest extends OrderedSymbolTableTestBase<OrderedSequentialSearchSymbolTable<String,Integer>> {

	@Override
	protected OrderedSequentialSearchSymbolTable<String, Integer> initialize() {
		return new OrderedSequentialSearchSymbolTable<String, Integer>();
	}

}
