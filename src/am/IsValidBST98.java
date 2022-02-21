package am;

public class IsValidBST98 {
	public class TreeNode {
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

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
	}

	public boolean isValidBST(TreeNode root, Integer min_val, Integer max_val) {
		if (root == null) {
			return true;
		}

		if (min_val != null && root.val <= min_val) {
			return false;
		}

		if (max_val != null && root.val >= max_val) {
			return false;
		}

		return isValidBST(root.left, min_val, root.val) && isValidBST(root.right, root.val, max_val);
	}
}
