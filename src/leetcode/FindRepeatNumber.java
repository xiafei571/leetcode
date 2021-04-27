package leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {
	public int findRepeatNumber(int[] nums) {
		Set<Integer> num_set = new HashSet<Integer>();
		for (int num : nums) {
			if (num_set.contains(num)) {
				return num;
			} else {
				num_set.add(num);
			}
		}

		return -1;
	}
}
