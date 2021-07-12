package id;

public class FindLength718 {

	/**
	 * 输入： A: [1,2,3,2,1] B: [3,2,1,4,7] 输出：3 [3,2,1]
	 */

	public static int findLength(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		int dp[][] = new int[l1 + 1][l2 + 1];
		int max = 0;
		for (int i = l1 - 1; i >= 0; i--) {
			for (int j = l2 - 1; j >= 0; j--) {
				dp[i][j] = nums1[i] == nums2[j] ? dp[i + 1][j + 1] + 1 : 0;
				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(findLength(new int[] { 1, 2, 3, 2, 1 }, new int[] { 3, 2, 1, 4, 7 }));
	}
}
