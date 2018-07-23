/**
 * 
 */
package com.wei.ds.tree234;

/**
 * @author LL
 *
 */
public class DataItem {
	public int data;
	
	public DataItem(){
		
	}
	
	public DataItem(int data){
		this.data = data;
	}
	
	public void display(){
		System.out.print("/" + data);
	}
}
