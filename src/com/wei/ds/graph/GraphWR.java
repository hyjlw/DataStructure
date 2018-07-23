/**
 * 
 */
package com.wei.ds.graph;

/**
 * @author LL
 * 
 */
public class GraphWR {
	private final int MAX_VERTS = 20;
	private final int INFINITY = 1000000;
	private Vertex []vertexList;
	private int adjMatrix[][];
	private int nVerts;
	private int currentVert;
	private PriorityQ pQueue;
	private int nTree;
	
	public GraphWR(){
		vertexList = new Vertex[MAX_VERTS];
		adjMatrix = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int j=0; j<MAX_VERTS; j++){
			for(int k=0; k<MAX_VERTS; k++){
				adjMatrix[j][k] = INFINITY;
			}
		}
		pQueue = new PriorityQ();
	}
	
	public void addVertex(char label){
		vertexList[nVerts++] = new Vertex(label);
	}
	
	public void addEdge(int start, int end, int weight){
		adjMatrix[start][end] = weight;
		adjMatrix[end][start] = weight;
	}
	
	public void display(int v){
		System.out.print(vertexList[v].label);
	}
	
	public void mstw(){
		currentVert = 0;
		
		while(nTree < nVerts - 1){
			vertexList[currentVert].isInTree = true;
			nTree++;
			
			for(int j=0; j<nVerts; j++){
				if(j==currentVert){
					continue;
				}
				if(vertexList[j].isInTree){
					continue;
				}
				int distance = adjMatrix[currentVert][j];
				
				if(distance == INFINITY){
					continue;
				}
				putInPQ(j, distance);
			}
			if(pQueue.size() == 0){
				System.out.println("Graph not connected.");
				return;
			}
			Edge edge = pQueue.removeMin();
			int sourceVert = edge.srcVert;
			currentVert = edge.destVert;
			
			System.out.print(vertexList[sourceVert].label);
			System.out.print(vertexList[currentVert].label);
			System.out.print(" ");
		}
		for(int j=0; j<nVerts; j++){
			vertexList[j].isInTree = false;
		}
	}

	private void putInPQ(int newVert, int newDist) {
		int queueIndex = pQueue.find(newVert);
		
		if(queueIndex != -1){
			Edge temp = pQueue.peekN(queueIndex);
			int oldDist = temp.distance;
			if(oldDist > newDist){
				pQueue.removeN(queueIndex);
				Edge edge = new Edge(currentVert, newVert, newDist);
				pQueue.insert(edge);
			}
		}else{
			Edge edge = new Edge(currentVert, newVert, newDist);
			pQueue.insert(edge);
		}
	}

	private static class Vertex {
		public char label;
		public boolean isInTree;

		public Vertex(char label) {
			this.label = label;
			this.isInTree = false;
		}
	}
}

class Edge {
	public int srcVert;
	public int destVert;
	public int distance;

	public Edge(int srcVert, int destVert, int distance) {
		this.srcVert = srcVert;
		this.destVert = destVert;
		this.distance = distance;
	}

}

class PriorityQ {
	private final int SIZE = 20;
	private Edge[] qArray;
	private int size;

	public PriorityQ() {
		qArray = new Edge[SIZE];
		size = 0;
	}

	public void insert(Edge item) {
		int j;

		for (j = 0; j < size; j++) {
			if (item.distance >= qArray[j].distance) {
				break;
			}
		}
		for (int k = size - 1; k >= j; k--) {
			qArray[k + 1] = qArray[k];
		}
		qArray[j] = item;
		size++;
	}

	public Edge removeMin() {
		return qArray[--size];
	}
	
	public int find(int v){
		for(int j=0; j<size; j++){
			if(qArray[j].destVert == v){
				return j;
			}
		}
		return -1;
	}

	public void removeN(int n) {
		for (int j = n; j < size - 1; j++) {
			qArray[j] = qArray[j + 1];
		}
		size--;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Edge peekN(int n) {
		return qArray[n];
	}
}