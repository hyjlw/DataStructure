/**
 * 
 */
package com.wei.ds.stack;

/**
 * @author LL
 *
 */
public class TestQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DsQueue queue = new DsQueue();
		for(int i=0;i<10;i++){
			queue.enqueue((int) (Math.random()*100), true);
		}
		while(!queue.isEmpty()){
			System.out.print(queue.dequeue() + " ");
		}
		System.out.println();
	}

}
