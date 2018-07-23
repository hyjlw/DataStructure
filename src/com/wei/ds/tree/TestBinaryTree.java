/**
 * 
 */
package com.wei.ds.tree;

/**
 * @author LL
 *
 */
public class TestBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size = 10;
		BinaryTree tree = new BinaryTree();
		for(int i=0;i<size;i++){
			tree.insert((int) (Math.random()*size));
		}
		tree.displayTree();
		
		Node key = tree.find(23);
		if(key != null)
			System.out.println(key.data);
		
		tree.insert(77);
		
		boolean flag = tree.delete(77);
		System.out.println(flag);
		
		tree.traverse(1);
		tree.traverse(2);
		tree.traverse(3);
	}

}
