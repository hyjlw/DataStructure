/**
 * 
 */
package com.wei.ds.tree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author LL
 *
 */
public class TestBinaryTree {

	private static final int MAX = 100;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size = 10;
		BinaryTree tree = new BinaryTree();

		Set<Integer> values = genInts(size);
		Iterator<Integer> itr = values.iterator();
		while (itr.hasNext()) {
			int val = itr.next();

			tree.insert(val);
		}

		tree.displayTree();

		Node key = tree.find(23);
		if (key != null)
			System.out.println(key.data);
		else
			System.out.println("cannot find value: " + 23);

		tree.insert(77);

		boolean flag = tree.delete(77);
		System.out.println("delete value[77]: " + flag);

		tree.traverse(1);
		tree.traverse(2);
		tree.traverse(3);
	}

	private static Set<Integer> genInts(int size) {
		Set<Integer> values = new HashSet<Integer>();

		while (values.size() < size) {
			int val = (int) (Math.random() * MAX);
			values.add(val);
		}

		return values;
	}

}
