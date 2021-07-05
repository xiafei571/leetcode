package leetcode.bfs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder103 {
	/*
	 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
	 * 
	 * 例如： 给定二叉树 [3,9,20,null,null,15,7],
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root){
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		
		if(root == null) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		boolean orderLeft = true;
		// 0:left->right, 1:right -> left
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			Deque<Integer> deque = new LinkedList<Integer>();
			while(n > 0) {
				TreeNode node = queue.poll();
				if(orderLeft) {
					deque.addLast(node.val);
				}else {
					deque.addFirst(node.val);
				}
				
				if(node.left != null) {
					queue.add(node.left);
				}
				
				if(node.right != null) {
					queue.add(node.right);
				}
				
				n--;
			}
			
			orderLeft = !orderLeft;
			result.add(new LinkedList<Integer>(deque));
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
