package amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestor236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Map<TreeNode, TreeNode> parents = new HashMap<TreeNode, TreeNode>();
		dfs(parents, root);
		Set<Integer> set = new HashSet<Integer>();

		while (p != null) {
			set.add(p.val);
			p = parents.get(p);
		}

		while (q != null) {
			if (set.contains(q.val)) {
				return q;
			}
			q = parents.get(q);
		}

		return null;
	}

	private static void dfs(Map<TreeNode, TreeNode> parents, TreeNode root) {
		if (root == null) {
			return;
		}

		if (root.left != null) {
			parents.put(root.left, root);
			dfs(parents, root.left);
		}

		if (root.right != null) {
			parents.put(root.right, root);
			dfs(parents, root.right);
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
