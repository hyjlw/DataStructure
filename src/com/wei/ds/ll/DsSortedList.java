/**
 * 
 */
package com.wei.ds.ll;

/**
 * @author LL
 *
 */
public class DsSortedList {
	private Entry first;
	
	public DsSortedList(){
		first = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void insert(int data){
		Entry newEntry = new Entry(data);
		
		Entry previous = null;
		Entry current = first;
		
		while(current!=null&&data>current.data){
			previous = current;
			current = current.next;
		}
		if(previous == null){
			first = newEntry;
		} else {
			previous.next = newEntry;
		}
		newEntry.next = current;
	}
	
	public int remove(){
		Entry entry = first;
		first = first.next;
		return entry.data;
	}
	
	public void display(){
		System.out.println("List(first-->last)");
		Entry current = first;
		while(current != null){
			current.display();
			current = current.next;
		}
		System.out.println();
	}
}
