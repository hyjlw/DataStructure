/**
 * 
 */
package com.wei.ds.sort;

/**
 * @author LL
 *
 */
public class TestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size = 2<<28;
		DSSorter sorter = new DSSorter(size);
		for(int i=0;i<size;i++){
			sorter.insert((int) (Math.random()*size));
		}
		System.out.println("init finished");
		
		long start = System.currentTimeMillis();
//		sorter.display();
//		sorter.bubbleSort();
//		sorter.selectSort();
//		sorter.insertSort();
//		sorter.mergeSort();
//		sorter.shellSort();
//		sorter.partition(0, size - 1, 10);
//		sorter.quickSort();
		sorter.quickSort2();
		long time = System.currentTimeMillis() - start;
		System.out.println(time/1000.0 + " seconds");
//		sorter.display();
	}

}
