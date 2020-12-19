package algo.expert;

import java.util.ArrayDeque;

public class InvertBinaryTree {
	public static void invertBinaryTree(BinaryTree tree) {
		// Write your code here.
		ArrayDeque<BinaryTree> queue = new ArrayDeque<BinaryTree>();
		queue.addLast(tree);
		while (queue.size() > 0) {
			BinaryTree current = queue.pollFirst();
			swap(current);
			if (current.left != null) {
				queue.addLast(current.left);
			}
			if (current.right != null) {
				queue.addLast(current.right);
			}
		}
	}

	private static void swap(BinaryTree tree) {
		BinaryTree left = tree.left;
		tree.left = tree.right;
		tree.right = left;
	}

	static class BinaryTree {
		public int value;
		public BinaryTree left;
		public BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
		}
	}
}
