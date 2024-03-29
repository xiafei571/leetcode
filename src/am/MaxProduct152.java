package am;

public class MaxProduct152 {
	public int maxProduct(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int res = nums[0];
		// int[] max = new int[nums.length];
		// int[] min = new int[nums.length];
		int max = nums[0];
		int min = nums[0];

		// max[0] = nums[0];
		// min[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {

			// max[i] = Math.max(nums[i], Math.max(nums[i] * max[i-1], nums[i] * min[i-1]));
			// min[i] = Math.min(nums[i], Math.min(nums[i] * min[i-1], nums[i] * max[i-1]));
			int temp = max;
			max = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
			min = Math.min(nums[i], Math.min(nums[i] * min, nums[i] * temp));
			res = Math.max(res, max);
		}

		return res;
	}
}
