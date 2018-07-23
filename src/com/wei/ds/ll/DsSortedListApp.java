/**
 * 
 */
package com.wei.ds.ll;

/**
 * @author LL
 *
 */
public class DsSortedListApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DsSortedList list = new DsSortedList();
		
		for(int i=0;i<10;i++){
			list.insert((int) (Math.random()*100));
		}
		list.display();
	}

}
