package basic.unionfind.client;

import basic.unionfind.QuickFind;
import basic.unionfind.QuickUnion;
import basic.unionfind.UnionFind;
import basic.unionfind.WeightedQuickUnion;

public class UnionFindPrinter {
	
	public static void main(String[] args) {
		UnionFind unionFind = new WeightedQuickUnion(10); // new QuickUnion(10), new QuickFind(10);
		unionFind.printState();
		unionFind.union(9, 0);
		unionFind.printState();
		unionFind.union(3, 4);
		unionFind.printState();
		unionFind.union(5, 8);
		unionFind.printState();
		unionFind.union(7, 2);
		unionFind.printState();
		unionFind.union(2, 1);
		unionFind.printState();
		unionFind.union(5, 7);
		unionFind.printState();
		unionFind.union(0, 3);
		unionFind.printState();
		unionFind.union(4, 2);
		unionFind.printState();
	}
	
}
