package algo.expert;

public class FindClosestValueInBST {
	public static int findClosestValueInBst(BST tree, int target) {
		int closest = tree.value;

		while (tree != null) {

			if (Math.abs(tree.value - target) < Math.abs(closest - target)) {
				closest = tree.value;
			}

			if (tree.left != null && target < tree.value) {
				tree = tree.left;
			} else if (tree.right != null && target >= tree.value) {
				tree = tree.right;
			} else {
				return closest;
			}
		}

		return closest;
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}
	}
}
