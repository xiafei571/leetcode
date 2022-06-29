package am;

import common.TreeNode;

public class SortedArrayToBST108 {
	public TreeNode sortedArrayToBST(int[] nums) {
		return dfs(0, nums.length - 1, nums);
	}

	private static TreeNode dfs(int l, int r, int[] nums) {
		if (l > r) {
			return null;
		}

		int m = (l + r) / 2;
		TreeNode root = new TreeNode(nums[m]);
		root.left = dfs(l, m - 1, nums);
		root.right = dfs(m + 1, r, nums);
		return root;
	}
}
