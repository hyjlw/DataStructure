/**
 * 
 */
package com.wei.ds.al;

/**
 * @author LL
 *
 */
public class TestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DSList list = new DSList();
		for(int i=0;i<20;i++){
			list.add(i);
		}
		list.display();
		list.add(list.size(), 77);
		list.display();
		int key = 6;
		boolean find = list.binaryFind(key);
		if(find){
			System.out.println("find key: " + key);
		} else {
			System.out.println("Not find key: " + key);
		}
		
		boolean flag = list.recFind(key);
		if(flag){
			System.out.println("find key: " + key);
		} else {
			System.out.println("Not find key: " + key);
		}
		
		list.deleteByPosition(5);
		list.display();
	}
}
