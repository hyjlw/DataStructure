/**
 * 
 */
package com.wei.ds.ll;

/**
 * @author LL
 *
 */
public class DsLinkQueueApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DsLinkQueue queue = new DsLinkQueue();
		
		for(int i=0;i<10;i++){
			queue.enqueue(i);
		}
		
		queue.display();
		
		queue.dequeue();
		queue.dequeue();
		
		queue.display();
	}

}
