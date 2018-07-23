/**
 * 
 */
package com.wei.ds.heap;

/**
 * @author LL
 *
 */
public class TestHeap {
	public static void main(String []args){
		int size = 31;
		Heap heap = new Heap(size);
		
		for(int i=0;i<16; i++){
			heap.insert((int) (Math.random()*100));
		}
		
		heap.display();
		
		heap.insert(23);
		heap.display();
		
		heap.remove();
		heap.display();
		
		heap.change(5, 77);
		heap.display();
		
		heapSort();
	}
	
	public static void heapSort(){
		int size = 31;
		int heapSize = 16;
		Heap heap = new Heap(size);
		
		for(int i=0;i<heapSize; i++){
			heap.insert((int) (Math.random()*100));
		}
		int []array = new int[heapSize];
		for(int j=0;j<heapSize;j++){
			array[j] = heap.remove().getKey();
		}
		for(int k=0; k<heapSize; k++){
			System.out.print(array[k] + " ");
		}
	}
}
