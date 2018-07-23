/**
 * 
 */
package com.wei.ds.ll;

/**
 * @author LL
 *
 */
public class DualEntry {
	public int data;
	public DualEntry next;
	public DualEntry previous;
	
	public DualEntry(int data){
		this.data = data;
	}
	
	public void display(){
		System.out.print("{" + data + "}");
	}
}
