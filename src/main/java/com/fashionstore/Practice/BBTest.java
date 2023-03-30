package com.fashionstore.Practice;

public class BBTest {

	public static void main(String[] args) {
		int[] arr = { 32, 24, 26, 28, 52 };
		int check = 28;
		int beg = 0;
		int end = 0;
		int mid;

		while (beg <= end) {

			end = arr.length - 1;
			mid = (beg + end) / 2; // 26

			if (check == arr[mid]) {
				System.out.println("Element found at index " + mid+" with value "+arr[mid]);
				break;
			}

			if (check > arr[mid]) {
				beg = mid + 1;

			}
			if(check<arr[mid]) {
				end=mid-1;
			}
			if(beg==end) {
				mid=(beg+end)/2;
				System.out.println("Element is at "+mid);
			}
		}

	}

}
