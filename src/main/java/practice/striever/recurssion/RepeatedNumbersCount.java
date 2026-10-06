package practice.striever.recurssion;

public class RepeatedNumbersCount {
	
	public static int repeatedCount(int[] arr) {
		int count = 0 ;
		
		//get Index
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = arr[i] -1 ;
		}
		
		//add number
		for(int i = 0 ; i< arr.length ; i++) {
			int index = arr[i] % arr.length;
			arr[index] += arr.length;
		}
		
		//check each count
		for(int i = 0 ; i < arr.length ; i++) {
			int freq = arr[i]/arr.length;
			if(freq > 1) {
				count++;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		System.out.println(repeatedCount(new int[]{1,2,2,1,3,4,5,7,7}));
	}

}
