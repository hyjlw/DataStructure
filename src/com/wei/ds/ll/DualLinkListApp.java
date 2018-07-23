/**
 * 
 */
package com.wei.ds.ll;

/**
 * @author LL
 *
 */
public class DualLinkListApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DualLinkList list = new DualLinkList();
		
		for(int i=0;i<5;i++){
			list.insertFirst(i);
		}
		for(int i=5;i<10;i++){
			list.insertLast(i);
		}
		
		list.displayForward();
		list.displayBackward();
		
		list.deleteFirst();
		list.deleteLast();
		list.displayForward();
		
		list.insertAfter(77, 3);
		list.insertAfter(27, 7);
		list.displayForward();
	}

}
