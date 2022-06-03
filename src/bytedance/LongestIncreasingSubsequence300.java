package bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence300 {
	private static int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int res = 1;

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					res = Math.max(res, dp[i]);
				}
			}
		}

		return res;
	}
	
	public static void main(String[] args) {
		int[] input = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(input));
		System.out.println(lengthOfLIS2(input));
	}
	
	private static int lengthOfLIS2(int[] nums) {
		List<Integer> res = new ArrayList<>();
		
		for(int i = 0; i < nums.length-1; i++) {
			List<Integer> curr = new ArrayList<>();
			curr.add(nums[i]);
			backtrack(nums, curr, i+1, res);
			curr.remove(curr.size()-1);
		}
		
		for(Integer num : res) {
			System.out.println(num);
		}
		
		return res.size();
	}
	
	private static void backtrack(int[] nums, List<Integer> curr, int idx, List<Integer> res) {
		for(int j = idx; j < nums.length; j++) {
			if(nums[j] > curr.get(curr.size() - 1)) {
				curr.add(nums[j]);
				if(curr.size() > res.size()) {
					res.clear();
					res.addAll(curr);
				}
				backtrack(nums, curr, j+1, res);
				curr.remove(curr.size()-1);
			}
		}
	}
	
}
