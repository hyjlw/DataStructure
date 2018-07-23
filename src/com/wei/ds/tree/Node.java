/**
 * 
 */
package com.wei.ds.tree;

/**
 * @author LL
 *
 */
public class Node {
	public int data;
	public Node leftChild;
	public Node rightChild;
	
	public Node(int data){
		this.data = data;
	}
	
	public void display(){
		System.out.print("{" + data + "}");
	}
}
