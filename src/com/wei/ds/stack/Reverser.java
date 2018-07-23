/**
 * 
 */
package com.wei.ds.stack;

/**
 * @author LL
 *
 */
public class Reverser {
	private String input;
	
	public Reverser(String in){
		input = in;
	}
	
	public String doReverse(){
		int size = input.length();
		DsStack stack = new DsStack(size);
		for(int i=0;i<input.length();i++){
			char ch = input.charAt(i);
			stack.push(ch);
		}
		String output = "";
		while(!stack.isEmpty()){
			output = output  + (char)stack.pop();
		}
		return output;
	}
}
