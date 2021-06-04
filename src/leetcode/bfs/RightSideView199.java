package leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView199 {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int n = queue.size();
			int m = n;
			while (m > 0) {
				TreeNode node = queue.poll();

				if (m == n) {
					result.add(node.val);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				m--;
			}
		}

		return result;
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
