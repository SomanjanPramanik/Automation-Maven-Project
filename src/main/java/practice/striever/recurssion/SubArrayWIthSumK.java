package practice.striever.recurssion;

import java.util.HashMap;

public class SubArrayWIthSumK {

	public static void main(String[] args) {
		int[] arr = {1, 2, 1, 2, 1};

		HashMap<Integer, Integer> seen = new HashMap<>();
		seen.put(0, 1); // (sum, count)

		int targetSum = 3;

		int count = 0;
		int currSum = 0;
		for (int i = 0; i < arr.length; i++) {
			currSum += arr[i];
			if (seen.containsKey(currSum - targetSum)) {
				
				count += seen.get(currSum - targetSum);
							
			}
			
			seen.put(currSum, seen.getOrDefault(currSum, 0) + 1);

		}

		System.out.println(count);
		
		
		seen.clear();
		
		
		// target Sum 0
		seen.put(0, -1); //{-2 , 2} never seen 0 before 
		
		int length  = 0 ;
		int cuurSum = 0;
		
		for(int i = 0 ; i < arr.length ; i++) {
			cuurSum += arr[i];
			if(seen.containsKey(cuurSum)) {
				length = Math.max(length, i - seen.get(cuurSum));
			} else {
				seen.put(cuurSum, i);
			}
			
		}
		
		System.out.println(length);
	
	
//		১. Longest Subarray with Equal 0s and 1s (ম্যাক্সিমাম লেংথ বের করতে হবে)
//
//		অ্যারে: 
		int[] arr1 = {0, 1, 0, 1, 1, 0, 1, 0};
//
//		আউটপুট: 7 (কারণ পুরো অ্যারেটাতেই সমান সংখ্যক 0 আর 1 আছে)।
//
//		লজিক ট্রিক: অ্যারের ভেতর যেখানে যেখানে 0 পাবে, লুপ চালানোর সময় মনে মনে সেটাকে -1 ধরে নেবে (if(arr[i] == 0) currSum += -1; else currSum += 1;)। এরপর একদম তোমার লেখা Largest Subarray with 0 Sum-এর হুবহু কোড বসিয়ে দেবে! কারণ 1 আর -1 যোগ করলে 0 হয়, আর 0 সাম পাওয়া মানেই 0 এবং 1 সমান সংখ্যায় আছে।
		
		seen.clear();
		seen.put(0, -1);
		
		int currSuminZeroOne = 0;
		
		int lnegthMax = 0;
		
		for(int i = 0 ; i< arr1.length ; i++) {
			if(arr1[i] == 0) {
				currSuminZeroOne += -1;
			}
			else {
				currSuminZeroOne += 1;
			}
			
			if(seen.containsKey(currSuminZeroOne)) {
				lnegthMax = Math.max(lnegthMax, i - seen.get(currSuminZeroOne));
			} else {
				seen.put(currSuminZeroOne, i);
			}
		}
		
		System.out.println(lnegthMax);
		
//		২. Subarray Sums Divisible by K (কাউন্ট বের করতে হবে)
//
//		অ্যারে: 
		int[] arr3 = {4, 5, 0, -2, -3, 1};
//
//		টার্গেট: K = 5
//
//		আউটপুট: 7 (এমন ৭টা সাব-অ্যারে আছে যাদের যোগফলকে ৫ দিয়ে ভাগ করলে ভাগশেষ 0 হয়)।
//
//		লজিক ট্রিক: এখানে currSum - K খোঁজার দরকার নেই। এখানে আমরা ম্যাপে ভাগশেষ (Remainder) স্টোর করব। অর্থাৎ currSum % K ম্যাপে খুঁজব। যদি কোনো ভাগশেষ আগে এসে থাকে, তার মানে মাঝখানের অংশটুকু K দিয়ে পুরোপুরি বিভাজ্য!
//
//		(প্রো টিপ: জাভাতে নেগেটিভ নাম্বারের মডিউলো নেগেটিভ আসতে পারে, তাই রিমাইন্ডার বের করার সময় int rem = (currSum % K + K) % K; ব্যবহার করবে। এরপর তোমার লেখা Subarray Sum Equals K (Count)-এর হুবহু লজিক!)
		
		seen.clear();
		
		seen.put(0, 1); // rem 0 ese6e 1 bar 
		
		int k = 5;
		int currSumdivByK = 0;
		int count1 = 0;
		
		for(int i = 0 ; i < arr3.length ; i++) {
			currSumdivByK += arr3[i];
			
			int rem = (currSumdivByK % k + k)%k;
			
			if(seen.containsKey(rem)) {
				count1+=seen.get(rem);
			}
				seen.put(rem, seen.getOrDefault(rem,0)+1);
			
		}
		
		System.out.println(count1);
	}

}
