/**
 * 
 */
package com.wei.ds.graphd;

/**
 * @author LL
 * 
 */
public class DAGraph {
	private final int MAX_VERTS = 20;
	private Vertex[] vertexList;
	private int adjMatrix[][];
	private int nVerts;
	private char[] sortedArray;

	public DAGraph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMatrix = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int j = 0; j < MAX_VERTS; j++) {
			for (int k = 0; k < MAX_VERTS; k++) {
				adjMatrix[j][k] = 0;
			}
		}
		sortedArray = new char[MAX_VERTS];
	}

	public void addVertex(char label) {
		vertexList[nVerts++] = new Vertex(label);
	}

	public void addEdge(int start, int end) {
		adjMatrix[start][end] = 1;
	}

	public void display(int v) {
		System.out.print(vertexList[v].label);
	}

	public void topo() {
		int origNVerts = nVerts;
		while (nVerts > 0) {
			int currentVertex = noSuccessors();
			if (currentVertex == -1) {
				System.out.println("ERROR: Graph has cycles");
				return;
			}
			sortedArray[nVerts - 1] = vertexList[currentVertex].label;

			deleteVertex(currentVertex);
		}

		System.out.print("Topological sorted order: ");
		for (int j = 0; j < origNVerts; j++) {
			System.out.print(sortedArray[j]);
		}
		System.out.println();
	}

	private void deleteVertex(int vertex) {
		if(vertex != nVerts - 1){
			for(int j=vertex;j<nVerts-1;j++){
				vertexList[j] = vertexList[j+1];
			}
			for(int row=vertex; row<nVerts-1; row++){
				moveRowUp(row, nVerts);
			}
			for(int col=vertex; col<nVerts-1; col++){
				moveColLeft(col, nVerts-1);
			}
			
		}
		nVerts--;
	}

	private void moveColLeft(int col, int length) {
		for(int row=0; row<length; row++){
			adjMatrix[row][col] = adjMatrix[row][col+1];
		}
	}

	private void moveRowUp(int row, int length) {
		for(int col=0; col<length; col++){
			adjMatrix[row][col] = adjMatrix[row+1][col];
		}
	}

	private int noSuccessors() {
		boolean isEdge;

		for (int row = 0; row < nVerts; row++) {
			isEdge = false;
			for (int col = 0; col < nVerts; col++) {
				if (adjMatrix[row][col] > 0) {
					isEdge = true;
					break;
				}
			}
			if (!isEdge) {
				return row;
			}
		}
		return -1;
	}

}

class Vertex {
	public char label;
	public boolean isVisited;

	public Vertex(char label) {
		this.label = label;
		isVisited = false;
	}
}
