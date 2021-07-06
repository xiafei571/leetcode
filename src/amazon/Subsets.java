package amazon;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		// backtrack算法
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		backtrack(nums, 0, list, res);
		return res;
	}

	private static void backtrack(int[] nums, int idx, List<Integer> list, List<List<Integer>> res) {
		res.add(new ArrayList<Integer>(list));
		for (int i = idx; i < nums.length; i++) {
			list.add(nums[i]);
			backtrack(nums, i + 1, list, res);
			list.remove(list.size() - 1);
		}
	}
}
