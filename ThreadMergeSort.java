package com.walmart.ckp.cuid.test;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ThreadMergeSort extends RecursiveAction {

	private static final long serialVersionUID = 1L;

	private Integer arr[];
	private int low;
	private int high;

	public ThreadMergeSort(Integer arr[]) {
		this(arr, 0, arr.length - 1);
	}

	private ThreadMergeSort(Integer arr[], int low, int high) {
		this.arr = arr;
		this.low = low;
		this.high = high;
	}

	@Override
	protected void compute() {
		if (low < high) {
			int mid = (high + low) >>> 1;
			ThreadMergeSort left = new ThreadMergeSort(arr, low, mid);
			ThreadMergeSort right = new ThreadMergeSort(arr, mid + 1, high);
			invokeAll(left, right);
			merge(arr, low, mid, high);
		}
	}

	public void merge(Integer[] arr, int low, int mid, int high) {
		int n1 = mid - low + 1;
		int n2 = high - mid;
		int L[] = new int[n1];
		int M[] = new int[n2];

		for (int i = 0; i < L.length; i++) {
			L[i] = arr[low + i];
		}
		for (int i = 0; i < M.length; i++) {
			M[i] = arr[mid + i + 1];
		}

		int i = 0, j = 0, k = low;

		while (i < n1 && j < n2) {
			if (L[i] < M[j]) {
				arr[k++] = L[i++];
			} else {
				arr[k++] = M[j++];
			}
		}

		while (i < n1) {
			arr[k++] = L[i++];
		}

		while (j < n2) {
			arr[k++] = M[j++];
		}
	}

	public static void main(String[] args) {
		Integer arr[] = { 5, 2, 4, 2, 45, 6, 4, 2, 3, 8, 5, 6, 78, 3, 3 };

		System.out.println("Before: " + Arrays.toString(arr));
		ThreadMergeSort sort = new ThreadMergeSort(arr);
		ForkJoinPool pool = ForkJoinPool.commonPool();
		pool.invoke(sort);
		System.out.println("After: " + Arrays.toString(arr));

	}
}
