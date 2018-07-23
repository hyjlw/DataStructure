/**
 * 
 */
package com.wei.ds.al;

/**
 * @author LL
 * 
 */
public class DSList {
	private static final int DEFAULT_SIZE = 16;
	private int[] array;
	private int index = 0;

	public DSList() {
		this(DEFAULT_SIZE);
	}

	public DSList(int size) {
		array = new int[size];
		index = 0;
	}

	public void add(int data) {
		if (index >= array.length) {
			resize(array);
		}
		array[index++] = data;
	}

	public void add(int pos, int data) {
		if (pos < 0 || pos > array.length - 1) {
			throw new RuntimeException("pos: " + pos + " is invalid.");
		}
		index++;
		if (index >= array.length) {
			resize(array);
		}
		System.arraycopy(array, pos, array, pos + 1, array.length - pos - 1);
		array[pos] = data;
	}

	private void resize(int[] array0) {
		int[] newArray = new int[array0.length * 2];
		System.arraycopy(array0, 0, newArray, 0, array0.length);
		array = newArray;
	}

	public boolean delete(int value) {
		int j;
		for (j = 0; j < index; j++) {
			if (value == array[j]) {
				break;
			}
		}
		if (j == index) {
			return false;
		} else {
			for (int k = j; j < index; k++) {
				array[k] = array[k + 1];
			}
			index--;
			return true;
		}
	}

	public boolean deleteByPosition(int pos) {
		if (pos < 0 || pos > index) {
			throw new RuntimeException("pos: " + pos + " is invalid.");
		}

		System.arraycopy(array, pos + 1, array, pos, array.length - pos - 1);
		array[index--] = 0;

		return true;
	}

	public int size() {
		return index;
	}

	public boolean find(int key) {
		int j;
		for (j = 0; j < index; j++) {
			if (array[j] == key) {
				break;
			}
		}
		if (j == index) {
			return false;
		} else {
			return true;
		}
	}

	public boolean binaryFind(int key) {
		int lower = 0;
		int upper = index - 1;
		int cur;
		while (true) {
			cur = (lower + upper) / 2;
			if (array[cur] == key) {
				return true;
			} else if (lower > upper) {
				return false;
			} else {
				if (array[cur] < key) {
					lower = cur + 1;
				} else {
					upper = cur - 1;
				}
			}
		}
	}
	
	public boolean recFind(int key){
		return recFind(key, 0, index - 1);
	}
	
	private boolean recFind(int key, int lower, int upper){
		int cur = (lower+upper)/2;
		
		if(array[cur] == key){
			return true;
		}
		else if(lower>upper){
			return false;
		}
		else{
			if(array[cur] < key){
				return recFind(key, cur + 1, upper);
			}else{
				return recFind(key, lower, cur -1);
			}
		}
		
	}

	public void display() {
		for (int i = 0; i < index; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
