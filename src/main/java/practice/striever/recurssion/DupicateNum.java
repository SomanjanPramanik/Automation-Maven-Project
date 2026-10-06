package practice.striever.recurssion;

public class DupicateNum {
	
	public static int duplicate(int[] arr) {
		int count = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			int index = Math.abs(arr[i]) - 1;
			
			if(arr[index] < 0) {
				System.out.println(Math.abs(arr[index]));
				count++;
			} else {
				arr[index] = - arr[index];
			}
		}
		return count;
	}
	
	public static int repeated(int[] arr) {
		
		//index 
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = arr[i] - 1;
		}
		
		//n add to the index 
		for(int i = 0 ; i < arr.length ; i++) {
			int index = arr[i]%arr.length;
			arr[index] = arr[index] + arr.length;
		}
		
		int count = 0 ;
		//count freq
		for(int i = 0 ; i < arr.length ; i++) {
			int freq = arr[i]/arr.length;
			if(freq > 1) {
				count ++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(duplicate(new int[] {1,2,3,3,4,2,4,1}));
		System.out.println(repeated(new int[] {1,2,3,4,2,4,1}));
	}

}
