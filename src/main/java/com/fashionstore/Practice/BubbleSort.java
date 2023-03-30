package com.fashionstore.Practice;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		
		int[] arr= {21,20,65,56,1};
		
		for(int i=0;i<arr.length;i++) {
			
			for(int j=1;j<arr.length-i;j++) {
				
				System.out.println(arr[j]+","+arr[j-1]);
				
				if(arr[j]<arr[j-1]) {
					
					int temp=arr[j];
					System.out.println(temp);
					
					arr[j]=arr[j-1];
					
					arr[j-1]=temp;
				}
			}
			
		
		}
		System.out.println(Arrays.toString(arr));
	}

}
