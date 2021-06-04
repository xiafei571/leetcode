package leetcode.bfs;

public class IsSymmetric101 {
	public boolean isSymmetric(TreeNode root) {
		return check(root, root);
	}
	
	private static boolean check(TreeNode left, TreeNode right) {
		if(left == null && right == null) {
			return true;
		}
		
		if(left == null || right == null) {
			return false;
		}
		
		if(left.val == right.val && check(left.left, right.right) && check(left.right, right.left)) {
			return true;
		}
		
		return false;
	}
	
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
}
