/**
 * 
 */
package com.wei.ds.ll;

/**
 * @author LL
 *
 */
public class FirstLastLinkList {
	private Entry first;
	private Entry last;
	
	public FirstLastLinkList(){
		first = null;
		last = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void insertFirst(int data){
		Entry entry = new Entry(data);
		if(isEmpty()){
			last = entry;
		}
		entry.next = first;
		first = entry;
	}
	
	public void insertLast(int data){
		Entry entry = new Entry(data);
		if(isEmpty()){
			first = entry;
		} else {
			last.next = entry;
		}
		last = entry;
	}
	
	public int deleteFirst(){
		int data = first.data;
		if(first.next==null){
			last = null;
		}
		first = first.next;
		return data;
	}
	
	public void display(){
		System.out.println("List(first-->last)");
		Entry current = first;
		while(current!=null){
			current.display();
			current = current.next;
		}
		System.out.println();
	}
}
