package graph.client;

import graph.AdjacancyListGraph;
import graph.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileGraphReader {
	
	private String filename;
	
	public FileGraphReader(String filename) {
		this.filename = filename;
	}
	
	public void readAndPrint() {
		Graph G = read();
		System.out.println(G.toString());
	}
	
	public Graph read() {
		File file = new File(filename);
		try {
			Scanner sc = new Scanner(file);
			int noVerticies = Integer.parseInt(sc.nextLine());
			sc.nextLine();
			
			Graph G = new AdjacancyListGraph(noVerticies);
			
			while(sc.hasNextLine()) {
				String[] numbers = sc.nextLine().split(" ");
				int edgeStart = Integer.parseInt(numbers[0]);
				int edgeEnd = Integer.parseInt(numbers[1]);
				G.addEdge(edgeStart, edgeEnd);
			}
			
			return G;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		FileGraphReader reader = new FileGraphReader("data/graph/tinyGen2.txt");
		reader.readAndPrint();
	}

}
