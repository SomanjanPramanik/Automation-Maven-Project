package practice.striever.recurssion;

import java.util.Arrays;

public class Sort {

	public static void mergeSort(int[] arr) {
		
		if(arr.length <=1 ) {
			return;
		}
		
		Sort sort = new Sort();
		
		sort.helper(arr , 0 , arr.length-1);
		
	}
	
	private  void helper(int[] arr, int si, int ei) {
		
		if(si>=ei) {
			return;
		}
		
		int mid = si+(ei-si)/2;
		
		helper(arr , si , mid);
		helper(arr, mid+1 , ei);
		
		merge(arr , si , mid , ei);
	}

	private  void merge(int[] arr, int si, int mid, int ei) {
		int i = si;
		int j = mid+1;
		int k =0;
		int[] temp = new int[ei-si+1];
		
		while(i<=mid && j<=ei) {
			if(arr[i]<=arr[j]) {
				temp[k++] = arr[i++];
			}
			else {
				temp[k++] = arr[j++];
			}
		}
		while(i<=mid) {
			temp[k++] = arr[i++];
		}
		while(j<=ei) {
			temp[k++] = arr[j++];
		}
		for(int j1= 0 , i1 = si ; j1<temp.length ; j1++ ,i1++) {
			arr[i1] = temp[j1];
		}
	}
	
	private static  void quickSort(int[] arr, int si , int ei) {
		if(arr.length<=1){
			return;
		}
		// base
		if(si>=ei){
			
			return;
			
		}
		
		int pivotIndex = partition(arr , si , ei);
		
		quickSort(arr, si, pivotIndex-1);
		quickSort(arr, pivotIndex+1 ,ei);
		
	}
	
	private static int partition(int[] arr, int si, int ei) {
		int i = si -1;
		int pivot = arr[ei];
		for(int j = si ; j < ei ; j++) {
			if(arr[j]<pivot) {
				i = i+1;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		i = i+1;
		int temp = arr[ei];
		arr[ei] = arr[i];
		arr[i] = temp;
		return i;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1,5,2,8,3,9,4};
		System.out.println(Arrays.toString(arr));
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
		
		int[] arr2 = new int[] {9,2,5,4,7,3,6,6,1};
		
		System.out.println(Arrays.toString(arr2));
		quickSort(arr2, 0, arr2.length-1);
		System.out.println(Arrays.toString(arr2));
	}

}
