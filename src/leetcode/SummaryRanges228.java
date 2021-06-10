package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {
	public static void main(String[] args) {
		summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 });
	}

	public static List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		if (nums.length == 0) {
			return result;
		}

		if (nums.length == 1) {
			result.add(String.valueOf(nums[0]));
			return result;
		}

		int left = 0;
        int right = left;
		while (left < nums.length) {
			if (right < nums.length - 1 && nums[right] + 1 == nums[right+1]) {
				right++;
			} else {
				if (right == left) {
					result.add(String.valueOf(nums[left]));
				} else {
					result.add(nums[left] + "->" + nums[right]);
				}
                left = right+1;
                right = left;
			}
		}

		return result;
	}
}
