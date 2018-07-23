/**
 * 
 */
package com.wei.ds.graphd;

/**
 * @author LL
 *
 */
public class TestDAGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DAGraph graph = new DAGraph();
		
		for(char c='A'; c<'I'; c++){
			graph.addVertex(c);
		}
		
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(3, 6);
		graph.addEdge(4, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 7);
		
		graph.topo();
	}

}
