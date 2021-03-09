package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CommonTraveral {

	public List<Integer> postorderTraversal(TreeNode root) {
		// left right root
		List<Integer> result = new ArrayList<Integer>();
		Deque<Guide> path = new ArrayDeque<Guide>();
		path.add(new Guide(0, root));
		while (!path.isEmpty()) {
			Guide curr = path.removeFirst();
			if (curr.node == null) {
				continue;
			}

			if (curr.operator == 1) {// print
				result.add(curr.node.val);
			} else if (curr.operator == 0) {// visit
				path.addFirst(new Guide(1, curr.node));
				path.addFirst(new Guide(0, curr.node.right));
				path.addFirst(new Guide(0, curr.node.left));
			}
		}

		return result;

	}

	private class Guide {
		// 0 visit, 1 print
		int operator;
		TreeNode node;

		public Guide(int operator, TreeNode node) {
			this.node = node;
			this.operator = operator;
		}

	}

	private class TreeNode {
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
