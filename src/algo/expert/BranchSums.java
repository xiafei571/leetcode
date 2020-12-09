package algo.expert;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {
	public static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		BinaryTree(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	public static List<Integer> branchSums(BinaryTree root) {
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		branchSumsHelp(root, list, sum);
		return list;
	}

	private static void branchSumsHelp(BinaryTree tree, List<Integer> list, int sum) {
		sum += tree.value;

		if (tree.left == null && tree.right == null) {
			list.add(sum);
			return;
		}

		if (tree.left != null) {
			branchSumsHelp(tree.left, list, sum);
		}

		if (tree.right != null) {
			branchSumsHelp(tree.right, list, sum);
		}

	}
}
