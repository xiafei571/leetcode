package bytedance;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

public class SerializeDeserializeBinaryTree297 {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		return dfs(root, "");
	}

	private String dfs(TreeNode root, String str) {
		if (root == null) {
			str += "null,";
		} else {
			str += String.valueOf(root.val) + ",";
			str = dfs(root.left, str);
			str = dfs(root.right, str);
		}
		// System.out.println(str);
		return str;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Queue<String> queue = new LinkedList<String>();
		String[] data_array = data.split(",");
		for (String str : data_array) {
			queue.add(str);
		}
		return deserializeHelper(queue);
	}

	private TreeNode deserializeHelper(Queue<String> queue) {
		if (queue.peek().equals("null")) {
			queue.poll();
			return null;
		}

		try {
			TreeNode root = new TreeNode(Integer.valueOf(queue.poll()));
			root.left = deserializeHelper(queue);
			root.right = deserializeHelper(queue);
			return root;
		} catch (Exception e) {
			return null;
		}

	}
}
