/**
 * 
 */
package com.wei.ds.ll;

/**
 * @author LL
 *
 */
public class DsLinkListApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DsLinkStack stack = new DsLinkStack();
		
		for(int i=0;i<10;i++){
			stack.push(i);
		}
		stack.display();
		
		stack.pop();
		stack.pop();
		
		stack.display();
	}

}
