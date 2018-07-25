/**
 * 
 */
package com.wei.ds.heap;

/**
 * @author LL
 *
 */
public class MaxHeap extends Heap {

	public MaxHeap(int size) {
		super(size);
	}

	public void insert(int key) {
		if (currentSize == maxSize) {
			throw new RuntimeException("The heap is full.");
		}
		Node newNode = new Node(key);
		heapNodes[currentSize] = newNode;
		trickleUp(currentSize++);
	}

	protected void trickleUp(int index) {
		int parent = (index - 1) / 2;
		Node bottom = heapNodes[index];
		while (index > 0 && heapNodes[parent].getKey() < bottom.getKey()) {
			heapNodes[index] = heapNodes[parent];
			index = parent;
			parent = (parent - 1) / 2;
		}
		heapNodes[index] = bottom;
	}

	public Node remove() {
		Node root = heapNodes[0];
		heapNodes[0] = heapNodes[--currentSize];
		trickleDown(0);

		return root;
	}

	protected void trickleDown(int index) {
		int largerChild;
		Node top = heapNodes[index];
		while (index < currentSize / 2) {
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;

			if (rightChild < currentSize && heapNodes[leftChild].getKey() < heapNodes[rightChild].getKey()) {
				largerChild = rightChild;
			} else {
				largerChild = leftChild;
			}

			if (top.getKey() >= heapNodes[largerChild].getKey()) {
				break;
			}

			heapNodes[index] = heapNodes[largerChild];
			index = largerChild;
		}
		heapNodes[index] = top;
	}

	public void change(int index, int newValue) {
		if (index < 0 || index >= currentSize) {
			throw new RuntimeException("Invalid index: " + index);
		}
		int oldValue = heapNodes[index].getKey();
		heapNodes[index].setKey(newValue);

		if (oldValue < newValue) {
			trickleUp(index);
		} else {
			trickleDown(index);
		}
	}
}
