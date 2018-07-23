/**
 * 
 */
package com.wei.ds.ll;

/**
 * @author LL
 *
 */
public class DsLinkStack {
	private DsLinkList linkList;
	
	public DsLinkStack(){
		linkList = new DsLinkList();
	}
	
	public void push(int data){
		linkList.addFirst(data);
	}
	
	public int pop(){
		return linkList.deleteFirst();
	}
	
	public boolean isEmpty(){
		return linkList.isEmpty();
	}
	
	public void display(){
		System.out.println("Stack(top-->bottom)");
		linkList.display();
	}
}
