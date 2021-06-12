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
	 * 如果是sparse(稀疏)的Bt tree， 则类似Leetcode的297,转成字符串
	 */
	
	/*
	 * 二叉树 转成 数组 节约空间， 
	 * 参考:考虑类似heap的构造⽅方法 
	 * 如果是dense的BT tree ⽤⼀个数组 假设父亲节点index为i,
	 * 则左⼉子 i * 2 + 1 右⼉子 i * 2 + 2 这个思路一定要先讲
	 */
	
	/*
	 * 存树。用什么办法可以节省空间，如果比较full的tree，用heap的实现方式。
	 * 比较sparse的tree就用tree本身。
	 * 介于中间的可以用两个数组，一个表示value，一个表示这个节点在第一种表示方式下的index。
	 * (稀疏的tree就用preorder转就好了，null节点存None)
	 */
	
	/*
	 * 我的理解是如果只存binary tree的话，一个TreeNode 要存一个value, 已经两个pointer to left and right
	 * child, 大约占 12 byte。如果假设一个Pointer 也是４byte的话（３２位系统）。 我看网上大家的答案大部分都是用一个heap.
	 * 大体意思是如果这个tree 比较满的话，用一个array 来存就行, Node i 的 两个孩子的index 是 2*i, 2 * i + 1. 如果 i
	 * 从１开始的话。这样子一个node 只存值，也就是只用了4 byte空间，原来的1/3. 但是如果这个tree比较稀疏的话，可以把这个稀疏Array 转化成
	 * dense format，也就是说用两个array, 一个存值，一个存 值对应的index.
	 * 
	 */
	
	/*
	 * follow up1: 就是如果树不full怎么办 (稀疏)
	 * 
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
