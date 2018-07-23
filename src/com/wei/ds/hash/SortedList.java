/**
 * 
 */
package com.wei.ds.hash;

/**
 * @author LL
 *
 */
public class SortedList {
	private Link first;
	
	public SortedList(){
		first = null;
	}
	
	public Link find(int key){
		Link current = first;
		while(current != null && current.getKey() <= key){
			if(current.getKey() == key){
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	public Link delete(int key){
		Link previous = null;
		Link current = first;
		
		while(current != null && key != current.getKey()){
			previous = current;
			current = current.next;
		}
		if(previous == null){
			Link deleteLink = first;
			first = first.next;
			return deleteLink;
		}else{
			previous.next = current.next;
			return current;
		}
	}
	
	public void insert(Link theLink){
		int key = theLink.getKey();
		Link previous = null;
		Link current = first;
		
		while(current != null && key > current.getKey()){
			previous = current;
			current = current.next;
		}
		if(previous == null){
			first = theLink;
		} else {
			previous.next = theLink;
		}
		theLink.next = current;
	}
	
	public void display(){
		System.out.print("List(first-->last)");
		
		Link current = first;
		while(current != null){
			current.display();
			current = current.next;
		}
		System.out.println();
	}
}
