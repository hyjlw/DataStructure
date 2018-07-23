/**
 * 
 */
package com.wei.ds.graph;

/**
 * @author LL
 *
 */
public class TestGraphWR {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GraphWR graph = new GraphWR();
		
		for(char c='A'; c<'G'; c++){
			graph.addVertex(c);
		}
		
		graph.addEdge(0, 1, 6);
		graph.addEdge(0, 3, 4);
		graph.addEdge(1, 2, 10);
		graph.addEdge(1, 3, 7);
		graph.addEdge(1, 4, 7);
		graph.addEdge(2, 3, 8);
		graph.addEdge(2, 4, 5);
		graph.addEdge(2, 5, 6);
		graph.addEdge(3, 4, 12);
		graph.addEdge(4, 5, 7);
		
		System.out.print("Minimum spanning tree: ");
		graph.mstw();
		System.out.println();
	}

}
