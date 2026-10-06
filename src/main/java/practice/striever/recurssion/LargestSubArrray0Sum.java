package practice.striever.recurssion;
import java.util.*;

public class LargestSubArrray0Sum {

	public static void main(String... args) {
		
		int[] arr = {15 , -2 , 2 , -8 , 1 , 7 , 10 , 23};
		
		HashMap<Integer , Integer> seenSum = new HashMap<>();
		
		int sum = 0;
		int lengthOfSubArray = 0;
		seenSum.put(0, -1); // {-2 , 2} edge case
		for(int i = 0 ; i < arr.length ; i++) {
			sum+= arr[i];
			if(seenSum.containsKey(sum)) {
				lengthOfSubArray = Math.max (i - seenSum.get(sum),lengthOfSubArray); 
			} else {
				seenSum.put(sum, i);
			}
		}
		
		System.out.println(lengthOfSubArray);
	}
}