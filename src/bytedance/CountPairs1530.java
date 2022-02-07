package bytedance;

import java.util.ArrayList;
import java.util.List;

public class CountPairs1530 {
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

	static int res = 0;

	public int countPairs(TreeNode root, int distance) {
		res = 0;
		dfs(root, distance);
		return res;
	}

	/*
	 * 定义递归意义：dfs返回从节点root到其所有叶子节点的距离数组
	 */
	private static List<Integer> dfs(TreeNode root, int distance) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		// 1 叶子结点
		if (root.left == null && root.right == null) {
			list.add(1);
			return list;
		}
		// 2 分别取出左右子树的所有叶子结点的距离数组；
		List<Integer> left = dfs(root.left, distance);
		List<Integer> right = dfs(root.right, distance);
		// 3 从左子树到右子树的叶子结点组合，找出距离小于等于distance的组合
		for (Integer l : left) {
			if (l >= distance) {
				continue;
			}
			for (Integer r : right) {
				if (r >= distance) {
					continue;
				}
				if (l + r <= distance) {
					res++;
				}
			}
		}

		// 4 当前结点的左右子树已处理完，把左右子树的结点统计到一起返回
		List<Integer> newList = new ArrayList<Integer>();
		for (Integer l : left) {
			newList.add(l + 1);
		}

		for (Integer r : right) {
			newList.add(r + 1);
		}

		// //debug
		// System.out.println(root.val+":");
		// for(Integer i : newList){
		// System.out.println(i+" ");
		// }
		// System.out.println();
		return newList;
	}
}
