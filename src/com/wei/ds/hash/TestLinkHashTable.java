/**
 * 
 */
package com.wei.ds.hash;

/**
 * @author LL
 *
 */
public class TestLinkHashTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size = 37;
		LinkHashTable ht = new LinkHashTable(size);
		
		for(int i=0; i<size * 10; i++){
			ht.insert(new Link((int) (Math.random()*1000)));
		}
		
		ht.display();
		
		ht.insert(new Link(443));
		
		Link link = ht.find(443);
		
//		ht.display();
		
		if(link != null){
			System.out.println("find item: " + link.getKey());
			ht.delete(link.getKey());
		
//			ht.display();
		}
	}

}
