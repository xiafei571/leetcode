package sn;

import java.util.ArrayList;
import java.util.List;
import common.TreeNode;

public class InorderTraversal94 {
	 public List<Integer> inorderTraversal(TreeNode root) {
	        List<Integer> res = new ArrayList<>();
	        inorder(root, res);
	        return res;
	    }
	    
	    private void inorder(TreeNode root, List<Integer> res){
	        if(root != null){
	            inorder(root.left, res);
	            res.add(root.val);
	            inorder(root.right, res);
	            
	        }
	    }
}
