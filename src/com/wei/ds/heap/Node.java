/**
 * 
 */
package com.wei.ds.heap;

/**
 * @author LL
 *
 */
public class Node {
	private int data;
	
	public Node(int data){
		this.data = data;
	}
	
	public int getKey(){
		return this.data;
	}
	
	public void setKey(int data){
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [" + data + "]";
	}
}
