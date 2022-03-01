package bb;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth662 {

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

	class TreeNodeLoc extends TreeNode {
		int loc;

		TreeNodeLoc(TreeNode selfNode, int loc) {
			this.val = selfNode.val;
			this.left = selfNode.left;
			this.right = selfNode.right;
			this.loc = loc;
		}
	}

	public int widthOfBinaryTree(TreeNode root) {
		Queue<TreeNodeLoc> queue = new LinkedList<TreeNodeLoc>();
		queue.offer(new TreeNodeLoc(root, 0));
		int max = 0;

		while (queue.size() != 0) {
			int size = queue.size();
			int startIdx = 0;
			int endIdx = 0;

			for (int i = 0; i < size; i++) {
				TreeNodeLoc node = queue.poll();
				if (i == 0) {
					startIdx = node.loc;
				}

				if (i == size - 1) {
					endIdx = node.loc;
				}

				if (node.left != null) {
					queue.offer(new TreeNodeLoc(node.left, node.loc * 2 + 1));
				}

				if (node.right != null) {
					queue.offer(new TreeNodeLoc(node.right, node.loc * 2 + 2));
				}
			}

			max = Math.max(max, endIdx - startIdx + 1);
		}

		return max;
	}
}
