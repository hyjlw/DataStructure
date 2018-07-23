/**
 * 
 */
package com.wei.ds.graph;

/**
 * @author LL
 *
 */
public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex []vertexList;
	private int adjMatrix[][];
	private int nVerts;
	private StackX stack;
	private QueueX queue;
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMatrix = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int j=0; j<MAX_VERTS; j++){
			for(int k=0; k<MAX_VERTS; k++){
				adjMatrix[j][k] = 0;
			}
		}
		stack = new StackX();
		queue = new QueueX();
	}
	
	public void addVertex(char label){
		vertexList[nVerts++] = new Vertex(label);
	}
	
	public void addEdge(int start, int end){
		adjMatrix[start][end] = 1;
		adjMatrix[end][start] = 1;
	}
	
	public void display(int v){
		System.out.print(vertexList[v].label);
	}
	
	public void dfs(){
		vertexList[0].isVisited = true;
		display(0);
		stack.push(0);
		
		while(!stack.isEmpty()){
			int v = getAdjUnvisitedVertex(stack.peek());
			if(v == -1){
				stack.pop();
			}else{
				vertexList[v].isVisited = true;
				display(v);
				stack.push(v);
			}
		}
		
		//stack is empty, done
		for(int j = 0; j < nVerts; j++){
			vertexList[j].isVisited = false;
		}
	}
	
	public void bfs(){
		vertexList[0].isVisited = true;
		display(0);
		queue.insert(0);
		
		int v2;
		while(!queue.isEmpty()) {
			int v1 = queue.remove();
			
			while((v2 = getAdjUnvisitedVertex(v1)) != -1){
				vertexList[v2].isVisited = true;
				display(v2);
				queue.insert(v2);
			}
		}
		//queue is empty, done
		for(int j=0; j<nVerts; j++){
			vertexList[j].isVisited = false;
		}
	}
	
	public void mst(){
		vertexList[0].isVisited = true;
		stack.push(0);
		
		while(!stack.isEmpty()){
			int currentVertex = stack.peek();
			int v = getAdjUnvisitedVertex(currentVertex);
			
			if(v == -1){
				stack.pop();
			}else{
				vertexList[v].isVisited = true;
				stack.push(v);
				
				display(currentVertex);
				display(v);
				System.out.print(" ");
			}
		}
		for(int i=0; i<nVerts; i++){
			vertexList[i].isVisited = false;
		}
	}

	private int getAdjUnvisitedVertex(int v) {
		for(int j=0; j<nVerts; j++){
			if(adjMatrix[v][j] == 1 && vertexList[j].isVisited == false){
				return j;
			}
		}
		return -1;
	}
}

class Vertex{
	public char label;
	public boolean isVisited;
	
	public Vertex(char label){
		this.label = label;
		isVisited = false;
	}
}

class QueueX{
	private final int SIZE = 20;
	private int []queArray;
	private int front;
	private int rear;
	
	public QueueX(){
		queArray = new int[SIZE];
		front = 0;
		rear = -1;
	}
	
	public void insert(int data){
		if(rear == SIZE - 1){
			rear = -1;
		}
		queArray[++rear] = data;
	}
	
	public int remove(){
		int temp = queArray[front++];
		if(front == SIZE){
			front = 0;
		}
		return temp;
	}
	
	public boolean isEmpty(){
		return ((rear + 1 == front) || (front + SIZE - 1 == rear));
	}
}

class StackX{
	private final int SIZE = 20;
	private int []st;
	private int top;
	
	public StackX(){
		st = new int[SIZE];
		top = -1;
	}
	
	public int peek(){
		return st[top];
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public void push(int data){
		st[++top] = data;
	}
	
	public int pop(){
		return st[top--];
	}
}