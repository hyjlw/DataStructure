/**
 * 
 */
package com.wei.ds.ll;

/**
 * @author LL
 *
 */
public class DsLinkQueue {
	private FirstLastLinkList theList;
	
	public DsLinkQueue(){
		theList = new FirstLastLinkList();
	}
	
	public boolean isEmpty(){
		return theList.isEmpty();
	}
	
	public void enqueue(int data){
		theList.insertLast(data);
	}
	
	public int dequeue(){
		return theList.deleteFirst();
	}
	
	public void display(){
		System.out.println("Queue(front-->rear)");
		theList.display();
	}
}
