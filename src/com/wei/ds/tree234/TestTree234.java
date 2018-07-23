/**
 * 
 */
package com.wei.ds.tree234;

/**
 * @author LL
 *
 */
public class TestTree234 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree234 tree = new Tree234();
		
		for(int i=0;i<16;i++){
			tree.insert((int) (Math.random()*1000));
		}
		
		tree.display();
	}

}
