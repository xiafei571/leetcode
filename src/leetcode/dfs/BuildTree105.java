package leetcode.dfs;

import java.util.HashMap;
import java.util.Map;

public class BuildTree105 {

	public static void main(String[] args) {
		int[] preorder = new int[] { 3, 9, 20, 15, 7 };
		int[] inorder = new int[] { 9, 3, 15, 20, 7 };
		buildTree(preorder, inorder);
	}

	static Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();

	/*
	 * 前序遍历 preorder = [3,[9],[20,15,7]] 
	 * 中序遍历 inorder = [[9],3,[15,20,7]]
	 */
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = inorder.length;
		for (int i = 0; i < n; i++) {
			inorderMap.put(inorder[i], i);
		}

		return buildHelper(preorder, inorder, 0, n - 1, 0, n - 1);
	}

	private static TreeNode buildHelper(int[] preorder, int[] inorder, int p1, int p2, int i1, int i2) {
		int root = preorder[p1];
		int rootIdx = inorderMap.get(root);

		int leftCnt = rootIdx - i1;
		int rightCnt = i2 - rootIdx;

		TreeNode rootNode = new TreeNode(root);
		if(leftCnt > 0) {
			rootNode.left = buildHelper(preorder, inorder, p1 + 1, p1 + leftCnt, i1, rootIdx - 1);
		}
		
		if(rightCnt > 0) {
			rootNode.right = buildHelper(preorder, inorder, p1 + leftCnt + 1, p1 + leftCnt + rightCnt, rootIdx + 1,
					rootIdx + rightCnt);
		}
		return rootNode;
	}

	static public class TreeNode {
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
