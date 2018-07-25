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
		Heap heap = new MinHeap(size);
		
		for(int i=0;i<20; i++){
			int key = (int) (Math.random()*100);
			System.out.println("insert key: " + key);
			heap.insert(key);
		}
		
		heap.display();
		
		System.out.println("insert value: 23");
		heap.insert(23);
		heap.display();
		
		System.out.println("remove top value");
		heap.remove();
		heap.display();
		
		System.out.println("change value of index[5] to: 77");
		heap.change(5, 77);
		heap.display();
		
		heapSort();
	}
	
	public static void heapSort(){
		int size = 31;
		int heapSize = 16;
		MaxHeap heap = new MaxHeap(size);
		
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
