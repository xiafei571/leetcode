package leetcode;

public class MaxSubArray53 {
	public int maxSubArray(int[] nums) {//O(n)空间

		if (nums.length == 1) {
			return nums[0];
		}

		int[] dp = new int[nums.length];
		dp[0] = nums[0];

		int max = dp[0];

		for (int i = 1; i < dp.length; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			max = Math.max(max, dp[i]);
		}

		return max;
	}
	
	 public int maxSubArray1(int[] nums) {//O(1)空间
	        
	        if(nums.length == 1){
	            return nums[0];
	        }
	        
	        int pre = nums[0];
	        int max = nums[0];

	        for(int i = 1; i < nums.length; i++){
	            pre = Math.max(pre + nums[i], nums[i]);
	            max = Math.max(pre, max);
	        }

	        return max;
	    }
}
