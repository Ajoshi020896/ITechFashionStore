package com.fashionstore.Practice;

public class BinarySearch {
	public static void main(String[] args) {

		// for binary search the array should be in the sorted form
		// if it is not sorted first sort it then apply binary search algorithm
		int[] arr = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
		int check = 10;
		int beg = 0;
		int end = arr.length - 1;

		while (beg <= end) {

			int mid = (beg + end) / 2;   //8
			
			if (check == arr[mid]) {
				System.out.println("element is at index " + mid);
				break;
			}
			if (check > arr[mid]) {
				beg = mid + 1; //7				
			}
			if(check<arr[mid]) {
				end=mid-1;
			}
			if(beg==end) {
				mid=(beg+end)/2;
				System.out.println("element present at "+ mid);
				break;
			}

		}

	}
}
