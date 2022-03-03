package bb;

import java.util.HashMap;
import java.util.Map;

public class BuildTree105 {
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

	Map<Integer, Integer> inorderIdx = new HashMap<Integer, Integer>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			inorderIdx.put(inorder[i], i);
		}

		return buildHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}

	private TreeNode buildHelper(int[] preorder, int[] inorder, int PL, int PR, int IL, int IR) {
		if (PL > PR || IL > IR) {
			return null;
		}
		// System.out.println(PL+","+PR+","+IL+","+IR);
		int rootValue = preorder[PL];
		TreeNode root = new TreeNode(rootValue);
		if (PR - PL == 0) {
			return root;
		}

		int idx = inorderIdx.get(rootValue);
		root.left = buildHelper(preorder, inorder, PL + 1, PL + idx - IL, IL, idx - 1);
		root.right = buildHelper(preorder, inorder, PL + idx - IL + 1, PR, idx + 1, IR);
		return root;
	}
}
