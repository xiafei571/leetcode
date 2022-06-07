package bytedance;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum560 {
	public int subarraySum(int[] nums, int k) {
		// sum([0-i])
		int[] pre_sum = new int[nums.length + 1];

		for (int i = 0; i < nums.length; i++) {
			pre_sum[i + 1] = pre_sum[i] + nums[i];
		}

		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j <= nums.length; j++) {
				if (pre_sum[j] - pre_sum[i] == k) {
					count++;
				}
			}
		}

		return count;
	}

	public static int subarraySum2(int[] nums, int k) {
		int count = 0, sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(subarraySum2(new int[] { 1 }, 0));
	}
}
