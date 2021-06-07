package leetcode.dfs;

public class MaxPathSum124 {
	/*
	 * -10 9 20 15 7
	 */

	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		maxGain(root);
		return max;
	}

	private int maxGain(TreeNode node) {
		if (node == null) {
			return 0;
		}

		// if it is a negative number, gain is 0.
		int leftMax = Math.max(maxGain(node.left), 0);
		int rightMax = Math.max(maxGain(node.right), 0);

		max = Math.max(max, node.val + leftMax + rightMax);

		return node.val + Math.max(leftMax, rightMax);
	}

	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
