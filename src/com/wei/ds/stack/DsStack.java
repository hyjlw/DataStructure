/**
 * 
 */
package com.wei.ds.stack;

/**
 * @author LL
 *
 */
public class DsStack {
	private int top;
	private int []array;
	private int maxSize;
	
	public DsStack(){
		this(16);
	}
	
	public DsStack(int size){
		maxSize = size;
		array = new int[maxSize];
		top = -1;
	}
	
	public void push(int data){
		array[++top] = data;
	}
	
	public int pop(){
		return array[top--];
	}
	public int peek(){
		return array[top];
	}
	public boolean isEmpty(){
		return top == -1;
	}
}
