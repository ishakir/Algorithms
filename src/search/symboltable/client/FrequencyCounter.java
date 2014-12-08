package search.symboltable.client;

import misc.io.StdIn;
import misc.io.StdOut;
import search.symboltable.SequentialSearchSymbolTable;
import search.symboltable.SymbolTable;

public class FrequencyCounter {

	public static void main(String[] args) {
		int minlen = 1;
		SymbolTable<String, Integer> st = new SequentialSearchSymbolTable<String, Integer>();
		
		while(!StdIn.isEmpty()) {
			String word = StdIn.readString();
			if(word.length() < minlen) continue;
			if(!st.contains(word)) st.put(word, 1);
			else                   st.put(word, st.get(word) + 1);
		}
		
		String max = "";
		st.put(max, 0);
		for(String word: st.keys()) {
			if(st.get(word) > st.get(max)) {
				max = word;
			}
		}
		StdOut.println(max + " " + st.get(max));
		
	}
	
}
