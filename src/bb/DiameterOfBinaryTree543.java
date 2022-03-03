package bb;

import common.TreeNode;

public class DiameterOfBinaryTree543 {
	int diameter;

	public int diameterOfBinaryTree(TreeNode root) {
		diameter = 0;
		dfs(root);
		return diameter;
	}

	private int dfs(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int left = dfs(node.left);
		int right = dfs(node.right);
		diameter = Math.max(left + right, diameter);

		return Math.max(left, right) + 1;
	}
}
