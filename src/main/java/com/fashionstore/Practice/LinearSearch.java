package com.fashionstore.Practice;

public class LinearSearch {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 5, 6, 8 };
		int c = 0;
		int i;

		int check = 5;

		for (i = 0; i < a.length; i++) {

			if (a[i] == check) {
				c++;
				break;

			}
		}
		if(c>0) {
			System.out.println("Item exists at index "+i);
		}
		else {
			System.out.println("item doesn't exists");
		}
	}

}
