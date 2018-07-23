package com.wei.ds.hash;

public class LinkHashTable {
	private int arraySize;
	private SortedList []hashArray;
	
	public LinkHashTable(int size){
		arraySize = size;
		hashArray = new SortedList[arraySize];
		for(int i=0;i<arraySize;i++){
			hashArray[i] = new SortedList();
		}
	}
	
	public void insert(Link theLink){
		int key = theLink.getKey();
		int hash = hashFunc(key);
		hashArray[hash].insert(theLink);
	}
	
	public Link delete(int key){
		int hash = hashFunc(key);
		return hashArray[hash].delete(key);
	}
	
	public Link find(int key){
		int hash = hashFunc(key);
		
		Link theLink = hashArray[hash].find(key);
		return theLink;
	}
	
	public int hashFunc(int key){
		return key % arraySize;
	}
	
	public void display(){
		for(int i=0;i<arraySize; i++){
			System.out.print(i + ". ");
			hashArray[i].display();
		}
	}
}
