package bb;

import common.TreeNode;

public class IsValidBST98 {
	public boolean isValidBST(TreeNode root) {
		return isValid(root, null, null);
	}

	private boolean isValid(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}

		if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
			return false;
		}

		return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
	}
}
