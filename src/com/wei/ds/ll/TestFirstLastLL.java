/**
 * 
 */
package com.wei.ds.ll;

/**
 * @author LL
 *
 */
public class TestFirstLastLL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FirstLastLinkList ll = new FirstLastLinkList();
		for(int i=0;i<10;i++){
			ll.insertFirst(i);
		}
		for(int i=10;i<20;i++){
			ll.insertLast(i);
		}
		ll.display();
		
		ll.deleteFirst();
		ll.display();
	}

}
