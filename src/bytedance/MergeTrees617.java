package bytedance;

import common.TreeNode;

public class MergeTrees617 {
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		return dfs(root1, root2);
	}

	private TreeNode dfs(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return null;
		}

		int val = 0;
		if (root1 != null)
			val += root1.val;
		if (root2 != null)
			val += root2.val;

		TreeNode root = new TreeNode(val);
		root.left = dfs(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
		root.right = dfs(root1 == null ? null : root1.right, root2 == null ? null : root2.right);

		return root;
	}
}
