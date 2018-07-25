/**
 * 
 */
package com.wei.ds.heap;

/**
 * @author weilin
 *
 */
public class MinHeap extends Heap {
	
	public MinHeap() {
		super();
	}
	
	public MinHeap(int size) {
		super(size);
	}
	
	protected void trickleDown(int index) {
		int smallerChild;
		Node top = heapNodes[index];

		while(index < currentSize / 2) {
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;
			
			if(rightChild < currentSize && heapNodes[leftChild].getKey() < top.getKey()) {
				smallerChild = leftChild;
			} else {
				smallerChild = rightChild;
			}
			
			if(heapNodes[smallerChild].getKey() >= top.getKey()) {
				break;
			}
			
			heapNodes[index] = heapNodes[smallerChild];
			
			index = smallerChild;
		}
		
		heapNodes[index] = top;
	}
	
	
	protected void trickleUp(int index) {
		Node bottom = heapNodes[index];
		
		int parent = (index - 1) / 2;
		while(index > 0) {
			if(heapNodes[parent].getKey() > bottom.getKey()) {
				heapNodes[index] = heapNodes[parent];
			} else {
				break;
			}
			
			index = parent;
			parent = (parent - 1) / 2;
		}
		
		heapNodes[index] = bottom;
	}
	
	
	public void insert(int key) {
		Node node = new Node(key);
		
		if(currentSize >= maxSize) {
			throw new RuntimeException("The heap is full.");
		}
		
		heapNodes[currentSize] = node;
		trickleUp(currentSize++);
	}
	
	public Node remove() {
		if(currentSize <= 0) {
			throw new RuntimeException("The heap is empty.");
		}
		
		Node first = heapNodes[0];
		
		heapNodes[0] = heapNodes[--currentSize];
		heapNodes[currentSize + 1] = null;
		
		trickleDown(0);
		
		return first;
	}
	
	public void change(int index, int value)  {
		if(index >= currentSize || index < 0) {
			throw new RuntimeException("Index invalid");
		}
		
		int old = heapNodes[index].getKey();
		heapNodes[index].setKey(value);
		
		if(old > value) {
			trickleUp(index);
		} else {
			trickleDown(index);
		}
		
	}
}
