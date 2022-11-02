package am;

public class MaxSubArray53 {
	public int maxSubArray(int[] nums) {

		if (nums.length <= 1) {
			return nums[0];
		}

		// dp[i] = dp[i-1] > 0? nums[i]+dp[i-1] : nums[i]
		int max = nums[0];
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (dp[i - 1] > 0) {
				dp[i] = dp[i - 1] + nums[i];
			} else {
				dp[i] = nums[i];
			}
			max = Math.max(max, dp[i]);
		}

		return max;
	}
}
