/**
 * 
 */
package com.wei.ds.sort;

/**
 * @author LL
 * 
 */
public class DSSorter {
	private int[] arr;
	private int index;

	public DSSorter(int size) {
		arr = new int[size];
		index = 0;
	}

	public DSSorter() {
		this(16);
	}

	public void mergeSort() {
		recMergeSort(new int[arr.length], 0, index - 1);
	}

	private void recMergeSort(int[] array, int lowerBound, int upperBound) {
		if (lowerBound == upperBound) {
			return;
		} else {
			int mid = (lowerBound + upperBound) / 2;
			recMergeSort(array, lowerBound, mid);
			recMergeSort(array, mid + 1, upperBound);
			merge(array, lowerBound, mid + 1, upperBound);
		}
	}

	private void merge(int[] array, int lowPtr, int highPtr, int upperBound) {
		int j = 0;
		int lowerBound = lowPtr;
		int mid = highPtr - 1;
		int n = upperBound - lowerBound + 1;

		while (lowPtr <= mid && highPtr <= upperBound) {
			if (arr[lowPtr] < arr[highPtr]) {
				array[j++] = arr[lowPtr++];
			} else {
				array[j++] = arr[highPtr++];
			}
		}
		while (lowPtr <= mid) {
			array[j++] = arr[lowPtr++];
		}
		while (highPtr <= upperBound) {
			array[j++] = arr[highPtr++];
		}
		for (j = 0; j < n; j++) {
			arr[lowerBound + j] = array[j];
		}
	}

	public void bubbleSort() {
		int out, in;
		for (out = index - 1; out > 1; out--) {
			for (in = 0; in < out; in++) {
				if (arr[in] > arr[in + 1]) {
					swap(in, in + 1);
				}
			}
		}
	}

	public void insertSort() {
		int in, out;
		for (out = 1; out < index; out++) {
			int temp = arr[out];
			in = out;
			while (in > 0 && arr[in - 1] >= temp) {
				arr[in] = arr[in - 1];
				--in;
			}
			arr[in] = temp;
		}
	}

	public void selectSort() {
		int out, in, min;
		for (out = 0; out < index - 1; out++) {
			min = out;
			for (in = out + 1; in < index; in++) {
				if (arr[in] < arr[min]) {
					min = in;
				}
			}
			swap(out, min);
		}
	}

	public void shellSort() {
		int inner, outer;
		int temp;
		int h = 1;
		while (h <= index / 3) {
			h = h * 3 + 1;
		}
		while (h > 0) {
			for (outer = h; outer < index; outer++) {
				temp = arr[outer];
				inner = outer;
				while (inner > h - 1 && arr[inner - h] >= temp) {
					arr[inner] = arr[inner - h];
					inner -= h;
				}
				arr[inner] = temp;
			}
			h = (h - 1) / 3;
		}
	}
	
	public void quickSort(){
		recQuickSort(0, index - 1);
	}
	
	private void recQuickSort(int left, int right) {
		if(left >= right)
			return;
		else {
			int pivot = arr[right];
			int partition = partition(left, right, pivot);
			recQuickSort(left, partition - 1);
			recQuickSort(partition + 1, right);
		}
	}

	public int partition(int left, int right, int pivot){
		int leftPtr = left - 1;
		int rightPtr = right;
		while(true){
			while(arr[++leftPtr] < pivot);
			while(arr[--rightPtr]> pivot);
			if(leftPtr>=rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right);
		return leftPtr;
	}
	
	public void quickSort2(){
		recQuickSort2(0, index - 1);
	}

	private void recQuickSort2(int left, int right) {
		int size = right - left + 1;
		if(size <= 10){
//			manualSort(left, right);
			insertSort(left, right);
		} else {
			int median = median3(left, right);
			int partition = partition(left, right, median);
			recQuickSort2(left, partition - 1);
			recQuickSort2(partition + 1, right);
		}
	}

	private void insertSort(int left, int right) {
		int in, out;
		for(out = left+1; out<=right; out++){
			int temp = arr[out];
			in = out;
			while(in>left && arr[in - 1] >= temp){
				arr[in] = arr[in - 1];
				--in;
			}
			arr[in] = temp;
		}
	}

	private int median3(int left, int right) {
		int center = (left + right)/2;
		if(arr[left] > arr[center]){
			swap(left, center);
		}
		if(arr[left]>arr[right]){
			swap(left, right);
		}
		if(arr[center] > arr[right]){
			swap(center, right);
		}
		swap(center, right - 1);
		
		return arr[right - 1];
	}

	private void manualSort(int left, int right) {
		int size = right - left + 1;
		if(size <= 1)
			return;
		if(size == 2){
			if(arr[left] > arr[right])
				swap(left, right);
			return;
		} else {
			if(arr[left] > arr[right - 1])
				swap(left, right - 1);
			if(arr[left] > arr[right])
				swap(left, right);
			if(arr[right - 1] > arr[right])
				swap(right - 1, right);
		}
	}

	public void insert(int value) {
		arr[index++] = value;
	}

	public void display() {
		for (int i = 0; i < index; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private void swap(int one, int two) {
		/*int temp = arr[one];
		arr[one] = arr[two];
		arr[two] = temp;*/
		
		arr[one] = arr[one] + arr[two];
		arr[two] = arr[one] - arr[two];
		arr[one] = arr[one] - arr[two];
	}
}
