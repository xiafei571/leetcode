package am;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum560 {

	public static void main(String[] args) {
		System.out.println(subarraySum(new int[] { -1, -1, 1 }, 0));
	}

	public static int subarraySum(int[] nums, int k) {
		//扫描一遍数组, 使用map记录出现同样的和的次数, 对每个i计算累计和sum并判断map内是否有sum-k
		if (nums.length == 1) {
			return nums[0] == k ? 1 : 0;
		}
		// <sum, index>
		// <sum, count>
		Map<Integer, Integer> loc = new HashMap<Integer, Integer>();
		loc.put(0, 1);
		int sum = 0;
//			int max = 0;
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			if (loc.containsKey(sum - k)) {
//					max = Math.max(max, i - loc.get(sum - k));
				count += loc.get(sum - k);
			}
			
			loc.put(sum, loc.getOrDefault(sum, 0) + 1);
		}

		return count;
	}
}
