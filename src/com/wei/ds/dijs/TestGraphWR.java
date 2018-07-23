/**
 * 
 */
package com.wei.ds.dijs;

/**
 * @author LL
 *
 */
public class TestGraphWR {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new Graph();
		
		for(char c='A'; c<'F'; c++){
			graph.addVertex(c);
		}
		
		graph.addEdge(0, 1, 50);
		graph.addEdge(0, 3, 80);
		graph.addEdge(1, 2, 60);
		graph.addEdge(1, 3, 90);
		graph.addEdge(2, 4, 40);
		graph.addEdge(3, 2, 20);
		graph.addEdge(3, 4, 70);
		graph.addEdge(4, 1, 50);
		
		System.out.print("Shortest Path: ");
		graph.path();
		System.out.println();
	}

}
