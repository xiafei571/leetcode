package amazon;

public class IsSubtree572 {
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

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null) {
			return false;
		} else {
			if (root.val == subRoot.val && isSame(root, subRoot)) {
				return true;
			} else {
				return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
			}
		}
	}

	private static boolean isSame(TreeNode tree1, TreeNode tree2) {
		if (null == tree1 && null == tree2) {
			return true;
		} else if (tree1 != null && tree2 != null) {
			if (tree1.val == tree2.val) {
				return isSame(tree1.left, tree2.left) && isSame(tree1.right, tree2.right);
			}
			return false;
		} else {
			return false;
		}
	}
}
