package algo.expert;

import java.util.ArrayList;
import java.util.List;

public class NodeDepths {
	public static int nodeDepths(BinaryTree root) {
		int currentDepth = 0;
		int sumDepth = 0;
		List<Integer> depths = new ArrayList<Integer>();
		nodeDepthsHelp(root, currentDepth, depths);

		for (Integer depth : depths) {
			sumDepth += depth;
		}
		return sumDepth;
	}

	private static void nodeDepthsHelp(BinaryTree tree, int currentDepth, List<Integer> depths) {
		depths.add(currentDepth);
		if (tree.left != null) {
			int nextDepth = currentDepth + 1;
			nodeDepthsHelp(tree.left, nextDepth, depths);
		}

		if (tree.right != null) {
			int nextDepth = currentDepth + 1;
			nodeDepthsHelp(tree.right, nextDepth, depths);
		}
	}

	static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		BinaryTree t1 = new BinaryTree(1);
		BinaryTree t2 = new BinaryTree(2);
		BinaryTree t3 = new BinaryTree(3);
		BinaryTree t4 = new BinaryTree(4);
		BinaryTree t5 = new BinaryTree(5);
		BinaryTree t6 = new BinaryTree(6);
		BinaryTree t7 = new BinaryTree(7);
		BinaryTree t8 = new BinaryTree(8);
		BinaryTree t9 = new BinaryTree(9);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		t4.left = t8;
		t4.right = t9;
		System.out.println(nodeDepths(t1));
	}
}
