package am;

public class GoodNodes1448 {

	class TreeNode {
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

	public int goodNodes(TreeNode root) {
		return dfs(root, root.val);
	}

	private int dfs(TreeNode root, int currMax) {
		if (root == null) {
			return 0;
		}

		int count = 0;

		if (root.val >= currMax) {
			count++;
		}

		if (root.left != null) {
			count += dfs(root.left, Math.max(currMax, root.left.val));
		}

		if (root.right != null) {
			count += dfs(root.right, Math.max(currMax, root.right.val));
		}

		return count;
	}
}
