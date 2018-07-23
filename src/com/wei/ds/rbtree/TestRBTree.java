/**
 * 
 */
package com.wei.ds.rbtree;

/**
 * @author LL
 *
 */
public class TestRBTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RBTree tree = new RBTree();
		
		//12 1 9 2 0 11 7 19 4 15 18 5 14 13 10 16 6 3 8 17
		tree.insert(12);
		tree.insert(1);
		tree.insert(0);
		tree.insert(2);
		tree.insert(0);
		tree.insert(11);
		tree.insert(7);
		tree.insert(19);
		tree.insert(4);
		tree.insert(15);
		tree.insert(18);
		tree.insert(5);
		tree.insert(14);
		tree.insert(13);
		tree.insert(10);
		tree.insert(16);
		tree.insert(6);
		tree.insert(3);
		tree.insert(8);
		tree.insert(17);
		
		Node node = tree.find(112);
		System.out.println(node.data + " " + node.color);
	}

}
