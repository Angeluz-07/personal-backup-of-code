/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy;

import java.util.PriorityQueue;

class Connect_N_Ropes {
 
	public static void main(String[] args) {
 
		int ropes[] = {4, 3, 2, 6};
		printArray(ropes);
		minHeap(ropes);
		System.out.println("Connect n ropes with minimum cost of : "+getMinCost(ropes));
	}
 
	private static int getMinCost(int arr[]){
		int totalMinCost =0;
		int heapSize = arr.length;
		//it will iterate until last element left in heap
		while(heapSize-1>0){
 
			int tempMinCost = arr[0];
			swap(arr, heapSize-1,0);
 
			for(int i=heapSize-1/2-1;i>=0;i--){
				heapify(arr,heapSize-1,i);
			}		
 
			arr[0]=tempMinCost+arr[0];
			totalMinCost = totalMinCost+arr[0];
			//n/2-1 its last non child node
			for(int i=heapSize-1/2-1;i>=0;i--){
				heapify(arr,heapSize-1,i);
			}	
			heapSize--;
		}
		return totalMinCost;
	}
  //build min heap
	private static void minHeap(int arr[]){
 
		int n= arr.length;
		//n/2-1 its last non child node
		for(int i=n/2-1;i>=0;i--){
			heapify(arr,n,i);
		}
	}
	//heapify min heap 
	private static void heapify(int arr[], int n, int i){
 
		int left = 2*i+1;
		int right = 2*i+2;
		int smalest =i;
 
		if(left<n&&arr[left]<arr[smalest]){
			smalest = left;
		}
		if(right<n&&arr[right]<arr[smalest]){
			smalest=right;
		}
		if(smalest!=i){
			swap(arr, smalest, i);
			heapify(arr, n, smalest);
		}
	}
 
	private static void swap(int arr[], int largest, int i){
 
		int temp = arr[i];
		arr[i] = arr[largest];
		arr[largest] = temp;
	}
 
	private static void printArray(int arr[]){
 
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
 
}
