package practice.striever.recurssion;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashSet;
//import java.util.LinkedList;
import java.util.List;

public class BackTracking {

	public static void permutationsOfString(String stringGiven, String nullString) {

		// base case
		if (stringGiven.length() == 0) {
			System.out.println(nullString);
			return;
		}

		// for loop for getting all start
		for (int i = 0; i < stringGiven.length(); i++) {

			String ch = String.valueOf(stringGiven.charAt(i));

			// if condition to check non repeating
			// if we want repeating : don't use if the o/p : aaa aab aac
			String newstringGiven = stringGiven.substring(0, i) + stringGiven.substring(i + 1);
			permutationsOfString(newstringGiven, nullString + ch);
		}
	}

	public static void subSetOfString(String string, int index, String nullString) {

		// base
		if (index == string.length()) {
			if (nullString.length() == 0) {
				System.out.println("null");
			} else {
				System.out.println(nullString);
			}
			return;
		}

		// take next element
		subSetOfString(string, index + 1, nullString + string.charAt(index));

		// Don't take next element : skip it
		subSetOfString(string, index + 1, nullString);
	}

	// n queens N sq

	public static void nqueen(int row, char[][] board) {

		// base
		if (row == board.length) {
			System.out.println("-----");
			for (int i = 0; i < board.length; i++) {
				System.out.println(board[i]);
			}
			return;
		}

		// each row then next row
		for (int col = 0; col < board.length; col++) {
			if (safeBoard(board, row, col)) {
				board[row][col] = 'Q';
				nqueen(row + 1, board);
				board[row][col] = '.';
			}
		}
	}

	private static boolean safeBoard(char[][] board, int row, int col) {
		// check straight up
		for (int i = row - 1; i >= 0; i--) {
			if (board[i][col] == 'Q') {
				return false;
			}
		}

		// if row wise q already there
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] == 'Q') {
				return false;
			}
		}

		// if left up diagonally
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}

		// if right diagonal
		for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}

		return true;
	}

	// তোর কাছে একটা N x N সাইজের মেজ (Maze) বা গ্রিড আছে।1 মানে রাস্তা খোলা (ইঁদুর
	// যেতে পারে)।
	// 0 মানে রাস্তা বন্ধ বা দেওয়াল (ইঁদুর যেতে পারবে না)।ইঁদুরটা দাঁড়িয়ে আছে একদম
	// শুরুর পয়েন্ট (0, 0)-তে,
	// আর তাকে পৌঁছাতে হবে একদম শেষের পয়েন্ট (N-1, N-1)-তে।ইঁদুর ৪ দিকে যেতে পারে
	// :D (Down / নিচে)L (Left / বাঁয়ে)R (Right / ডানে)U (Up / ওপরে)
	// লক্ষ্য: ইঁদুরটা শুরুর পয়েন্ট থেকে শেষের পয়েন্টে পৌঁছানোর যতগুলো ভ্যালিড পথ
	// (Paths) আছে,
	// সবকটা স্ট্রিং আকারে প্রিন্ট করতে হবে (যেমন: "DDRR" বা "RRDD"
	// ইত্যাদি)।এক্সাম্পল:
	// ধরে নে একটা
	// 1 0 0 0
	// 1 1 0 1
	// 0 1 0 0
	// 1 1 1 1
	// ইঁদুর (0,0) থেকে শুরু করবে এবং (3,3)-তে পৌঁছাবে।যদি ও পথ খুঁজে পায়, আউটপুট
	// হবে: DRDDRR

	public static void getRoute(int[][] maze, int row, int col, String ans) {

		// base
		if (row == maze.length - 1 && col == maze.length - 1) {
			System.out.println(ans);
			return;
		}

		// ২. বর্তমান ঘরটাকে ব্লক (Mark) করো, যাতে ইঁদুর ফিরে না আসে
		maze[row][col] = 0;

		// if go down
		if (row + 1 < maze.length && maze[row + 1][col] != 0) {
			String newans = ans + "D";
			getRoute(maze, row + 1, col, newans);
		}

		// if go right
		if (col + 1 < maze.length && maze[row][col + 1] != 0) {
			String newans = ans + "R";
			getRoute(maze, row, col + 1, newans);
		}

		// if go up
		if (row - 1 >= 0 && maze[row - 1][col] != 0) {
			String newans = ans + "U";
			getRoute(maze, row - 1, col, newans);
		}

		// if go left
		if (col - 1 >= 0 && maze[row][col - 1] != 0) {
			String newans = ans + "L";
			getRoute(maze, row, col - 1, newans);
		}

		// ৩. ব্যাকট্র্যাকিং! ফিরে আসার সময় রাস্তাটা আবার খুলে দিয়ে যাও (Unmark)
		maze[row][col] = 1;

	}

	// Tor kachhe ekta array achhe: arr = [2, 3, 5], ar target = 8.
	// Toke emon combination khujte hobe jar jogfol 8 hoy (jemon: [2, 2, 2, 2], [3,
	// 5]).

	// Twist: Tui eki number jotobar khushi pick korte parish (unlimited times).

	public static void multipleSubSet(int[] given, int index, int sum, int target, ArrayList<Integer> ans) {

		// base
		if (sum == target) {
			System.out.println(ans);
			return;
		}

		if (index == given.length || sum > target) {
			return;

		}

		// ekta el 3 to option nijeke neoya (bar bar nile index egobo nuh)
		// nijeke na niye porer ta neoya
		// option 2 : no for loop

		sum = sum + given[index];
		ans.add(given[index]);
		multipleSubSet(given, index, sum, target, ans);
		// backtrack
		ans.remove(ans.size() - 1);
		sum = sum - given[index];

		multipleSubSet(given, index + 1, sum, target, ans);

	}

	// তোকে ডুপ্লিকেট সংখ্যাসহ একটা অ্যারে দেওয়া আছে।
	// তোকে তার সবকটা ইউনিক সাবসেট বের করতে হবে। কোনো ডুপ্লিকেট সাবসেট উত্তরে থাকা
	// চলবে না।
	// ইনপুট: nums = [1, 2, 2]

	// আউটপুট:
	//
	// []
	// [1]
	// [1, 2]
	// [1, 2, 2]
	// [2]
	// [2, 2]

	public static void uniqueSubSet(int[] arr, int index, List<Integer> list, HashSet<List<Integer>> hash) {
		// base : index == arr.length hye gelei return
		if (index == arr.length) {
			hash.add(new ArrayList<>(list));
			return;
		}

		// 2 to option list e dhukabo list e dhukabo nuh
		// dhukabo

		list.add(arr[index]);
		uniqueSubSet(arr, index + 1, list, hash);
		list.remove(list.size() - 1);

		// dhukabo nuh
		uniqueSubSet(arr, index + 1, list, hash);
	}

	// তোকে একটা অ্যারে আর একটা টার্গেট যোগফল দেওয়া আছে। তোকে এমন সব কম্বিনেশন
	// খুঁজতে হবে যাদের যোগফল ঠিক target-এর সমান হবে।

	// শর্ত ১: প্রতিটি সংখ্যা সর্বোচ্চ একবারই ব্যবহার করা যাবে (নন-রিপিটিং, মানে
	// Pick করার পর index + 1 হবে)।
	//
	// শর্ত ২: রেজাল্টে কোনো ডুপ্লিকেট কম্বিনেশন থাকা চলবে না (তোর চেনা HashSet
	// দিয়েই হ্যান্ডেল করবি)।
	//
	// এক্সাম্পল:
	// ইনপুট: arr = [2, 1, 2, 1], target = 3
	//
	// আউটপুট (ইউনিক): [1, 2]
	//
	public static void combinationSum2(int[] arr, int index, int sum, int target, List<Integer> list,
			HashSet<List<Integer>> ans) {

		// base
		if (sum == target) {
			ans.add(new ArrayList<>(list));
			return;
		}
		if (index == arr.length || sum > target) {
			return;
		}

		// option ki ekta pick korbo tapor r ta pick korbo ektakei bar bar pick korbo
		// nuh mane index+1 always
		// option 2 toi too r for loop laga66i nuh
		sum = sum + arr[index];
		list.add(arr[index]);
		combinationSum2(arr, index + 1, sum, target, list, ans);
		sum = sum - arr[index];
		list.remove(list.size() - 1);
		combinationSum2(arr, index + 1, sum, target, list, ans);
	}

	// =========================================================================
	// Problem: Combination Sum III (LeetCode 216)
	//
	// তোকে শুধুমাত্র ১ থেকে ৯ পর্যন্ত সংখ্যাগুলো ব্যবহার করতে হবে (1, 2, 3, ...,
	// 9)।
	// তোকে এমন সব কম্বিনেশন বের করতে হবে যাতে:
	// ১. কম্বিনেশনে ঠিক k-খানা সংখ্যা থাকে (মানে list.size() == k)।
	// ২. সংখ্যাগুলোর যোগফল ঠিক n হয় (মানে sum == n)।
	// ৩. প্রতিটি সংখ্যা সর্বোচ্চ একবারই ব্যবহার করা যাবে (1 to 9 এর মধ্যে কোনো
	// রিপিটেশন নেই)।
	// ৪. রেজাল্টে কোনো ডুপ্লিকেট কম্বিনেশন থাকা চলবে না।
	//
	// এক্সাম্পল ১:
	// Input: k = 3, n = 7
	// Output: [[1, 2, 4]] (কারণ 1 + 2 + 4 = 7 এবং মোট ৩টে সংখ্যা)
	//
	// এক্সাম্পল ২:
	// Input: k = 3, n = 9
	// Output: [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
	//
	// এক্সাম্পল ৩:
	// Input: k = 4, n = 1
	// Output: [] (৪টে সংখ্যা নিয়ে যোগফল ১ বানানো অসম্ভব)
	// =========================================================================

	public static void combinationSum3(int num, int size, int sum, int targetSum, List<Integer> list, List<List<Integer>> ans) {

		// base
		if (list.size() == size) {
			if (sum == targetSum) {
				ans.add(new ArrayList<Integer>(list));
			}

			return;
		}

		if (num < 10) // karon 0-9
		{
			// add to the list
			sum = sum + num;
			list.add(num);
			combinationSum3(num+1, size, sum, targetSum, list, ans);
			
			// remove korbo current ta karon size soman hye ge6e
			
			sum = sum - num;
			list.remove(list.size() - 1);
			
			combinationSum3(num+1, size, sum, targetSum, list, ans);
			
		}

	}

	
	//count ways to go from 0,0 to N-1,M-1
	public static int countWays(int row , int col , int DestinationRow , int DestinationCol) {
		
		//base jdi ami pouche jai destination e 
		if(row == DestinationRow && col == DestinationCol) {
			//no of steps hole return 0 but ekhane no of ways 
			return 1;
		}
		
		int count = 0;
		
		//Diagonal
		if (row < DestinationRow && col < DestinationCol) {
	        count += countWays(row + 1, col + 1, DestinationRow, DestinationCol);
	    }
		
		//Down
		if(row < DestinationRow ) {
			
			count += countWays(row+1, col, DestinationRow, DestinationCol) ;
			 
		} 
		
		//Side
		if(col < DestinationCol) {
			count += countWays(row, col+1, DestinationRow, DestinationCol);
			
		}
		
		return count;
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(countWays(0,0,1,1));
		
		int k = 3;
		int n = 9;
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> ans = new ArrayList<>();
		// num শুরু হবে ১ থেকে
		combinationSum3(1, k, 0, n, list, ans);
		System.out.println("Result: " + ans);

//		int[] arr = { 2, 1, 2, 1 };
//		int target = 3;
//		List<Integer> list = new ArrayList<>();
//		HashSet<List<Integer>> ans = new HashSet<>();
//		Arrays.sort(arr);
//		combinationSum2(arr, 0, 0, target, list, ans);
//		System.out.println("Result: " + ans);

//		int[] arrSubSetUnique = { 1, 2, 2 };
//		List<Integer> list = new LinkedList<Integer>();
//		HashSet<List<Integer>> hash = new HashSet<List<Integer>>();
//		uniqueSubSet(arrSubSetUnique, 0, list, hash);
//		System.out.println(hash);

//		permutationsOfString("abc", "");
//		subSetOfString("abc", 0, "");
//
//		int n = 4;
//		char[][] board = new char[n][n];
//		for (int i = 0; i < n; i++) {
//			Arrays.fill(board[i], '.');
//		}
//		System.out.println("\nN-Queens 4x4 Solutions:");
//		nqueen(0, board);
//
//		int[][] maze = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
//		getRoute(maze, 0, 0, "");
//
//		int[] arr = { 2, 3, 5 };
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		multipleSubSet(arr, 0, 0, 8, list);
	}

}
