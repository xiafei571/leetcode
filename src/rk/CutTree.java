package rk;

public class CutTree {
	public static void main(String[] args) {
		int[] nums1 = { 5, 4, 3, 2, 6 };
		int[] nums2 = { 3, 7, 4, 5 };
		int[] nums3 = { 7, 5, 5, 1, 2, 1 };
//		System.out.println(getMinCuts(nums1));
//		System.out.println(getMinCuts(nums2));
		System.out.println(solution(nums1));
		System.out.println(solution(nums2));
		System.out.println(solution(nums3));
	}

	public static int solution(int[] A) {
		int res = 0;
		int res1 = 0;
		boolean B = true;

		for (int i = 1; i < A.length; i++) {
			if ((A[i] > A[i - 1]) == B) {
				res++;
			} else {
				res1++;
			}

			B = !B;
		}

		return res > res1 ? A.length - 1 - res : A.length - 1 - res1;
	}

	private static int getMinCuts(int[] nums) {
		int[] dp1 = new int[nums.length], dp2 = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp1[i] = Math.max(dp1[i], dp1[j] + 1);
				}
			}
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					dp2[i] = Math.max(dp2[i], dp2[j] + 1);
				}
			}
		}
		int res = Integer.MAX_VALUE;
		for (int i = 1; i < nums.length - 1; i++) {
			if (dp1[i] > 0 && dp2[i] > 0)
				res = Math.min(res, nums.length - (dp1[i] + dp2[i]) - 1);
		}
		return res;
	}
}
