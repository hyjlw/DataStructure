/**
 * 
 */
package com.wei.ds.ll;

/**
 * @author LL
 *
 */
public class TestLL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DsLinkList ll = new DsLinkList();
		for(int i=0;i<16;i++){
			ll.addFirst(i);
		}
		
		ll.display();
		
		ll.deleteFirst();
		ll.display();
		
		ll.delete(5);
		ll.display();
	}
}
