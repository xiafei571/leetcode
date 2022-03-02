package am;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTree {

	class Node {
		int data;
		Node left;
		Node right;
	}

	public static int height(Node root) {
		int height = 0;
		if (root.left == null && root.right == null) {
			return height;
		}
		// Write your code here.
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
			}
			height++;
		}

		return height - 1;
	}
}
