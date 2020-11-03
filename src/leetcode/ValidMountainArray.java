package leetcode;

public class ValidMountainArray {
	/*
	 * 941. Given an array A of integers, return true if and only if it is a valid
	 * mountain array.
	 * 
	 * Recall that A is a mountain array if and only if:
	 * 
	 * A.length >= 3 There exists some i with 0 < i < A.length - 1 such that: A[0] <
	 * A[1] < ... A[i-1] < A[i] A[i] > A[i+1] > ... > A[A.length - 1]
	 * 
	 */

	public static boolean validMountainArray(int[] A) {
		if (A.length < 3)
			return false;

		int i = 0;
		int j = A.length - 1;
		for (int k = 0; k < A.length; k++) {
			if (i == A.length - 1 || j == 0) {
				return false;
			} else if (i == j) {
				return true;
			}

			if (i == k && A[i] < A[i + 1]) {
				i++;
			}

			if (j == A.length - k - 1 && A[j] < A[j - 1]) {
				j--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] case1 = { 2, 1 };
		int[] case2 = { 3, 5, 5 };
		int[] case3 = { 0, 3, 2, 1 };
		System.out.println(validMountainArray(case1));
		System.out.println(validMountainArray(case2));
		System.out.println(validMountainArray(case3));
	}
}
