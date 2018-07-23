/**
 * 
 */
package com.wei.ds.hash;

/**
 * @author LL
 *
 */
public class TestHashTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size = 32;
		HashTable ht = new HashTable(size);
		
		for(int i=0; i<size * 2 / 3; i++){
			ht.insert(new DataItem((int) (Math.random()*1000)));
		}
		
		ht.display();
		
		DataItem item = ht.find(443);
		
		if(item != null){
			System.out.println("find item: " + item.getKey());
			ht.delete(item.getKey());
		}
		
		ht.display();
	}

}
