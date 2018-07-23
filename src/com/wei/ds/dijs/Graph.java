/**
 * 
 */
package com.wei.ds.dijs;

/**
 * @author LL
 *
 */
public class Graph {
	private final int MAX_VERTS = 20;
	private final int INFINITY = Integer.MAX_VALUE;
	
	private Vertex vertexList[];
	private int adjMatrix[][];
	private int nVerts;
	private int nTree;
	private DistPar sPath[];
	private int currentVert;
	private int startToCurrent;
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMatrix = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		nTree = 0;
		for(int j=0; j<MAX_VERTS; j++){
			for(int k=0; k<MAX_VERTS; k++){
				adjMatrix[j][k] = INFINITY;
			}
		}
		sPath = new DistPar[MAX_VERTS];
	}
	
	public void addVertex(char label){
		vertexList[nVerts++] = new Vertex(label);
	}
	
	public void addEdge(int start, int end, int weight){
		adjMatrix[start][end] = weight;
	}
	
	public void path(){
		int startTree = 0;
		vertexList[startTree].isInTree = true;
		nTree = 1;
		
		for(int j=0; j<nVerts; j++){
			int tempDist = adjMatrix[startTree][j];
			sPath[j] = new DistPar(startTree, tempDist);
		}
		
		while(nTree < nVerts){
			int indexMin =getMin();
			int minDist = sPath[indexMin].distance;
			
			if(minDist == INFINITY){
				System.out.println("There are unreachable vertices.");
				break;
			}else{
				currentVert = indexMin;
				startToCurrent = sPath[indexMin].distance;
			}
			vertexList[currentVert].isInTree = true;
			nTree++;
			adjustSPath();
		}
		displayPaths();
		nTree = 0;
		for(int j=0; j<nVerts; j++){
			vertexList[j].isInTree = false;
		}
	}

	private void displayPaths() {
		for(int j=0; j<nVerts; j++){
			System.out.print(vertexList[j].label + "=");
			if(sPath[j].distance == INFINITY){
				System.out.print("inf");
			}else{
				System.out.print(sPath[j].distance);
			}
			char parent = vertexList[sPath[j].parentVert].label;
			System.out.print("{" + parent + "}");
		}
		System.out.println();
	}

	private void adjustSPath() {
		int column = 1;
		while(column < nVerts){
			if(vertexList[column].isInTree){
				column++;
				continue;
			}
			int currentToFringe = adjMatrix[currentVert][column];
			int startToFringe = startToCurrent + currentToFringe;
			int sPathDist = sPath[column].distance;
			
			if(startToFringe < sPathDist){
				sPath[column].parentVert = currentVert;
				sPath[column].distance = startToFringe;
			}
			column++;
		}
	}

	private int getMin() {
		int minDist = INFINITY;
		int indexMin = 0;
		
		for(int j=1; j<nVerts; j++){
			if(!vertexList[j].isInTree && sPath[j].distance < minDist){
				minDist = sPath[j].distance;
				indexMin = j;
			}
		}
		return indexMin;
	}
}

class DistPar{
	public int distance;
	public int parentVert;
	
	public DistPar(int parentVert, int distance) {
		this.distance = distance;
		this.parentVert = parentVert;
	}
}

class Vertex{
	public char label;
	public boolean isInTree;
	
	public Vertex(char label){
		this.label = label;
		this.isInTree = false;
	}
}