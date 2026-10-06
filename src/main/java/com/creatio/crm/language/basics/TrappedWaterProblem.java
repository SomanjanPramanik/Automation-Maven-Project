package com.creatio.crm.language.basics;

public class TrappedWaterProblem {

	public static void main(String[] args) {
		int[] matrix = { 1, 6, 6, 6, 12 };
		System.out.println(TrappedWaterProblem.sumOfTrappedWater(matrix));

	}

	public static int sumOfTrappedWater(int[] arr) {

		// Aux array
		int sumWater = 0;
		int width = 1;

		if (arr == null || arr.length <= 2) {
			return sumWater;
		}
		// Aux-array
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];

		left[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			left[i] = Math.max(arr[i], left[i - 1]);
		}

		right[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			right[i] = Math.max(arr[i], right[i + 1]);
		}

		for (int i = 0; i < arr.length; i++) {
			int waterLevel = Math.min(left[i], right[i]);
			sumWater = sumWater + (waterLevel - arr[i]) * width;
		}

		return sumWater;

	}

}
