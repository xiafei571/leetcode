package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		// -4 -1 -1 0 1 2
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums.length < 3) {
			return result;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				if (nums[i] + nums[left] + nums[right] > 0) {
					right--;
				} else if (nums[i] + nums[left] + nums[right] < 0) {
					left++;
				} else {
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[left]);
					list.add(nums[right]);
					if (!result.contains(list)) {
						result.add(list);
					}

					right--;
					left++;
				}
			}
		}

		return result;
	}
}
