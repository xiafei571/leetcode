package am;

import java.util.Arrays;

public class ThreeSumClosest16 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);

		int closest = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int num = nums[i] + nums[j] + nums[k];
				if (num > target) {
					k--;
				} else if (num < target) {
					j++;
				} else {
					return target;
				}

				if (Math.abs(num - target) < Math.abs(closest - target)) {
					closest = num;
				}
			}
		}

		return closest;
	}
}
