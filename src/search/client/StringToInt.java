package search.client;

import misc.io.StdIn;
import misc.io.StdOut;
import search.SequentialSearchSymbolTable;
import search.SymbolTable;

public class StringToInt {

	public static void main(String[] args) {
		SymbolTable<String, Integer> st = new SequentialSearchSymbolTable<String, Integer>();
		
		for(int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
			for(String s : st.keys()) {
				StdOut.println(s + " " +st.get(s));
			}
		}
	}
	
}
