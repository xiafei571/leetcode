package algo.expert;

import java.util.*;

public class FindSuccessor {
	// This is an input class. Do not edit.
	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;
		public BinaryTree parent = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
		// Write your code here.
		return findSuccessorByinOrder(tree, node);
	}

	public BinaryTree findSuccessor2(BinaryTree tree, BinaryTree node) {
		// Write your code here.
		if (node.right != null) {
			return getLeftmostChild(node.right);
		}
		return getRightmostParent(node);
	}

	private BinaryTree getLeftmostChild(BinaryTree node) {
		BinaryTree currentNode = node;
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}

		return currentNode;
	}

	private BinaryTree getRightmostParent(BinaryTree node) {
		BinaryTree currentNode = node;
		while (currentNode.parent != null && currentNode == currentNode.parent.right) {
			currentNode = currentNode.parent;
		}

		return currentNode.parent;
	}

	private BinaryTree findSuccessorByinOrder(BinaryTree tree, BinaryTree node) {
		List<BinaryTree> list = new ArrayList<BinaryTree>();
		inOrder(tree, list);
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).value == node.value) {
				return list.get(i + 1);
			}
		}
		return null;
	}

	private void inOrder(BinaryTree tree, List<BinaryTree> list) {
		// left val right
		if (tree.left != null) {
			inOrder(tree.left, list);
		}
		list.add(tree);
		if (tree.right != null) {
			inOrder(tree.right, list);
		}

	}
}
