/**
 * 
 */
package com.wei.ds.ll;

/**
 * @author LL
 *
 */
public class DsLinkList {
	private Entry header = new Entry();
	
	public DsLinkList(){
		
	}
	
	public boolean isEmpty(){
		return header.next == null;
	}
	
	public void addFirst(int data){
		Entry entry = new Entry(data);
		if(isEmpty()){
			header.next = entry;
		} else {
			Entry first = header.next;
			entry.next = first;
			header.next = entry;
		}
	}
	
	public int deleteFirst(){
		Entry entry = header.next;
		header.next = entry.next;
		return entry.data;
	}
	
	public boolean find(int key){
		Entry current = header.next;
		while(current.data!=key){
			if(current.next == null){
				return false;
			} else {
				current = current.next;
			}
		}
		return true;
	}
	
	public int delete(int key){
		Entry current = header.next;
		Entry previous = header;
		while(current.data!=key){
			if(current.next==null){
				throw new RuntimeException("No key: " + key + " in list.");
			} else {
				previous = current;
				current = current.next;
			}
		}
		previous.next = current.next;
		return current.data;
	}
	
	public void display(){
		System.out.println("List(first-->last:)");
		Entry current = header.next;
		while(current!=null){
			current.display();
			current = current.next;
		}
		System.out.println();
	}
	
}
