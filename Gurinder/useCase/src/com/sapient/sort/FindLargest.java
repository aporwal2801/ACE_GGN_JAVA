package com.sapient.sort;

public class FindLargest {

	public static void main(String[] args) {
		int inputArr[] = { 3, 4, 6, 7, 45, 34, 34, 324, 2, 2, 1 };
		MergeSort sorter = new MergeSort();
		sorter.sort(inputArr);

		System.out.println("Largest Number -->" + inputArr[inputArr.length - 1]);
		System.out.println("Second Largest Number -->" + inputArr[inputArr.length - 2]);
	}
}
