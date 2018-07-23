/**
 * 
 */
package com.wei.ds.hash;

/**
 * @author LL
 *
 */
public class HashTable {
	private DataItem []hashArray;
	private int arraySize;
	private DataItem nonItem;
	
	public HashTable(int size){
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);
	}
	
	public void insert(DataItem item){
		int key = item.getKey();
		int hash = hashFunc(key);
		int stepSize = step(key);
		
		while(hashArray[hash] != null && hashArray[hash].getKey() != -1){
			hash += stepSize;
			hash %= arraySize;
		}
		hashArray[hash] = item;
	}
	
	public DataItem delete(int key){
		int hash = hashFunc(key);
		int stepSize = step(key);
		
		while(hashArray[hash] != null){
			if(hashArray[hash].getKey() == key){
				DataItem temp = hashArray[hash];
				hashArray[hash] = nonItem;
				return temp;
			}
			hash += stepSize;
			hash %= arraySize;
		}
		return null;
	}
	
	public DataItem find(int key){
		int hash = hashFunc(key);
		int stepSize = step(key);
		
		while(hashArray[hash] != null){
			if(hashArray[hash].getKey() == key){
				return hashArray[hash];
			}
			hash += stepSize;
			hash %= arraySize;
		}
		return null;
	}
	
	public int hashFunc(int key){
		return key%arraySize;
	}
	
	public int step(int key){
		return 5 - key % 5;
	}
	
	public void display(){
		System.out.print("Table: ");
		
		for(int j=0;j<arraySize;j++){
			if(hashArray[j] != null){
				System.out.print(hashArray[j].getKey() + " ");
			}else{
				System.out.print("** ");
			}
		}
		System.out.println();
	}
}
