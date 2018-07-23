/**
 * 
 */
package com.wei.ds.stack;

/**
 * @author LL
 *
 */
public class TestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DsStack stack = new DsStack();
		for(int i=0; i<10; i++){
			stack.push((int) (Math.random()*100));
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
		
		Reverser rev = new Reverser("asdfghjkl;'");
		System.out.println(rev.doReverse());
	}

}
