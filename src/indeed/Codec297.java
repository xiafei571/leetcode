package indeed;

import java.util.LinkedList;
import java.util.Queue;

public class Codec297 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/*
	 * 选择前序遍历，是因为根左右的打印顺序，在反序列化时更容易定位出根节点的值。 
	 * 遇到 null 节点也要翻译成特定符号，反序列化时才知道这里是 null。
	 */
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		
		t1.left = t2;
		t1.right = t5;
		t2.left = t3;
		t2.right = t4;
		String seri = serialize(t1);
		System.out.println(seri);
		TreeNode node = deserialize(seri);
		String seri2 = serialize(node);
		System.out.println(seri2);
	}
	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		return preorder(root, "");
	}
	
	private static String preorder(TreeNode root, String str) {//root -> left -> right
		if(root == null) {
			str += "None,";
		}else {
			str += root.val+",";
			str = preorder(root.left, str);
			str = preorder(root.right, str);
		}
		return str;
	}

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		String[] strs = data.split(",");
		Queue<String> queue = new LinkedList<String>();
		for(String s : strs) {
			queue.add(s);
		}
		TreeNode root = deserializeHelper(queue);
		return root;
	}
	
	private static TreeNode deserializeHelper(Queue<String> queue) {
		if(queue.peek().equals("None")) {
			queue.poll();
			return null;
		}
		
		int val = Integer.valueOf(queue.poll());
		TreeNode root = new TreeNode(val);
		root.left = deserializeHelper(queue);
		root.right = deserializeHelper(queue);
		return root;
	}
}
