package algo.expert;

public class BinaryTreeDiameter {
	// This is an input class. Do not edit.
	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	public int binaryTreeDiameter(BinaryTree tree) {
		// Write your code here.
		// 0: diameter, 1:height
		int[] treeInfo = getBinaryTreeInfo(tree);
		return treeInfo[0];
	}

	private static int[] getBinaryTreeInfo(BinaryTree tree) {
		if (tree.left == null && tree.right == null) {
			return new int[] { 0, 1 };
		}

		int[] leftInfo = new int[2];
		int[] rightInfo = new int[2];
		if (tree.left != null) {
			leftInfo = getBinaryTreeInfo(tree.left);
		}
		if (tree.right != null) {
			rightInfo = getBinaryTreeInfo(tree.right);
		}

		int longestPath = leftInfo[1] + rightInfo[1];
		int maxDiameter = Math.max(leftInfo[0], rightInfo[0]);
		int currentDiameter = Math.max(longestPath, maxDiameter);
		int currentHight = Math.max(leftInfo[1], rightInfo[1]) + 1;
		return new int[] { currentDiameter, currentHight };
	}
}
