/**
 * 
 */
package com.wei.ds.heap;

/**
 * @author LL
 *
 */
public abstract class Heap {
	private static final int DEFAULT_SIZE = 32;
	
	protected Node []heapNodes;
	protected int maxSize;
	protected int currentSize;
	
	public Heap() {
		this(DEFAULT_SIZE);
	}
	
	public Heap(int size) {
		this.maxSize = size;
		this.currentSize = 0;
		this.heapNodes = new Node[size];
	}
	
	public boolean isEmpty(){
		return currentSize == 0;
	}
	
	public abstract void insert(int key);

	protected abstract void trickleUp(int index) ;
	
	public abstract Node remove();

	protected abstract void trickleDown(int index) ;
	
	public abstract void change(int index, int newValue);
	
	public void display(){
		System.out.print("Heap Array: ");
		for(int m=0; m<currentSize; m++){
			if(heapNodes[m] != null){
				System.out.print(heapNodes[m].getKey() + " ");
			}else{
				System.out.print("-- ");
			}
		}
		System.out.println();
		
		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0;
		
		String dots = "...................................";
		System.out.println(dots + dots);
		while(currentSize>0){
			if(column == 0){
				for(int k=0; k<nBlanks; k++){
					System.out.print(" ");
				}
			}
			System.out.print(heapNodes[j].getKey());
			if(++j == currentSize){
				break;
			}
			
			if(++column == itemsPerRow){
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				System.out.println();
			}else{
				for(int k=0; k<nBlanks * 2 - 2; k++){
					System.out.print(" ");
				}
			}
		}
		System.out.println("\n" + dots + dots);
	}
}
