/**
 * 
 */
package com.wei.ds.ll;

/**
 * @author LL
 *
 */
public class LinkList {
	private Entry first;
	
	public LinkList(){
		
	}
	
	public Entry getFirst(){
		return first;
	}
	
	public void setFirst(Entry newEntry){
		this.first = newEntry;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public ListIterator getListIterator(){
		return new ListIterator(this);
	}
	
	public void display(){
		Entry current = first;
		while(current!=null){
			current.display();
			current = current.next;
		}
		System.out.println();
	}
	
	private static class ListIterator{
		private Entry current;
		private Entry previous;
		private LinkList list;
		
		public ListIterator(LinkList theList){
			list = theList;
			reset();
		}
		
		public void insertAfter(int data){
			Entry newEntry = new Entry(data);
			if(list.isEmpty()){
				list.setFirst(newEntry);
				current = newEntry;
			}else{
				newEntry.next = current.next;
				current.next = newEntry;
				nextEntry();
			}
		}
		
		public void insertBefore(int data){
			Entry newEntry = new Entry(data);
			if(previous == null){
				newEntry.next = list.getFirst();
				list.setFirst(newEntry);
				reset();
			}else{
				newEntry.next = previous.next;
				previous.next = newEntry;
				current = newEntry;
			}
		}
		
		public int deleteCurrent(){
			int value = current.data;
			
			if(previous == null){
				list.setFirst(current.next);
				reset();
			}else{
				previous.next = current.next;
				if(atEnd()){
					reset();
				}else{
					current = current.next;
				}
			}
			
			return value;
		}
		
		public void nextEntry(){
			previous = current;
			current = current.next;
		}
		
		public Entry getCurrent(){
			return current;
		}
		
		public void reset(){
			current = list.getFirst();
			previous = null;
		}
		
		public boolean atEnd(){
			return current.next == null;
		}
	}
}
