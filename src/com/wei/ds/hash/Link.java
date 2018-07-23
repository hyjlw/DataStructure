/**
 * 
 */
package com.wei.ds.hash;

/**
 * @author LL
 *
 */
public class Link {
	private int data;
	public Link next;
	
	public Link(int data){
		this.data = data;
	}
	
	public int getKey(){
		return this.data;
	}
	
	public void display(){
		System.out.print(data + " ");
	}
}
