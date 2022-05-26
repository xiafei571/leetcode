package bytedance;

import java.util.HashMap;
import java.util.Map;

public class PredictTheWinner486 {
	Map<String, Integer> cache;

	public boolean PredictTheWinner(int[] nums) {
		cache = new HashMap<>();
		return maxScore(nums, 0, nums.length - 1) >= 0;
	}

	private int maxScore(int[] nums, int left, int right) {
		if (left == right) {
			return nums[left];
		}

		String key = left + "_" + right;
		if (cache.containsKey(key)) {
			return cache.get(key);
		}

		int max = Math.max(nums[left] - maxScore(nums, left + 1, right), nums[right] - maxScore(nums, left, right - 1));
		cache.put(key, max);
		return max;
	}
}
