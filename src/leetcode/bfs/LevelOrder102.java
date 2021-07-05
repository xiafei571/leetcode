package leetcode.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrder102 {
	/*
	 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
	 * 
	 *  
	 * 
	 * 示例： 二叉树：[3,9,20,null,null,15,7],
	 */
	
	public static void main(String[] args) {
		
	}
	
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null){
            return result;
        }
		
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int n = queue.size();
			List<Integer> currLayer = new ArrayList<Integer>();
			while(n >=0) {
				TreeNode node = queue.poll();
				currLayer.add(node.val);
				
				if(node.left != null) {
					queue.add(node.left);
				}
				
				if(node.right != null) {
					queue.add(node.right);
				}
				n--;
			}
			
			result.add(currLayer);
			
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
