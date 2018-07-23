/**
 * 
 */
package com.wei.ds.stack;

/**
 * @author LL
 * 
 */
public class DsQueue {
	private int maxSize;
	private int[] array;
	private int rear;
	private int front;
	private int index;

	public DsQueue() {
		this(16);
	}

	public DsQueue(int size) {
		maxSize = size;
		array = new int[maxSize];
		front = 0;
		rear = -1;
		index = 0;
	}

	public void enqueue(int data) {
		if (rear == maxSize - 1) {
			rear = -1;
		}
		array[++rear] = data;
		index++;
	}
	
	public void enqueue(int data, boolean flag){
		if(!flag){
			enqueue(data);
		} else {
			int j;
			if(index==0){
				array[++rear] = data;
				index++;
			} else {
				for(j=index-1;j>=0;j--){
					if(data > array[j]){
						array[j+1] = array[j];
					} else {
						break;
					}
				}
				array[j+1]=data;
				rear++;
				index++;
			}
		}
	}

	public int dequeue() {
		int temp = array[front++];
		if (front == maxSize) {
			front = 0;
		}
		index--;
		return temp;
	}

	public int peek() {
		return array[front];
	}

	public boolean isFull() {
		return index == maxSize;
	}

	public boolean isEmpty() {
		return index == 0;
	}

	public int size() {
		return index;
	}
}
