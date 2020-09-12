package daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * longestPre最长公共前缀
 * DFS BFS 二叉树遍历
 * @author user
 *
 */
public class Demo0905 {
	
	/*
	 * 找到“好”节点的数量, "good-node": 从树的根节点到该节点的路径上，没有比该节点大的节点，那么该节点就是一个“好”节点
	 * 
	 * 	    1
	 *   2      3 
	 *    5    6 7
	 * good:
	 * 1
	 * 1->2
	 * 1->2->5
	 * 1->3
	 * 1->3->6
	 * 1->3->7
	 * 
	 *     3
	 *   1    4
	 * 5     2  8
	 * good:
	 * 3
	 * 3->1->5
	 * 3->4
	 * 3->4->8
	 * DFS
	 */
	private static int countGoodNode(int max, TreeNode root) {
		if(root == null) {
			return 0;
		}
		int count = 0;
		if(root.val > max) {
			count++;
			max = root.val;
		}
		if(null != root.left) {
			count += countGoodNode(max, root.left);
		}
		if(null != root.right) {
			count += countGoodNode(max, root.right);
		}
		return count;
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t5 = new TreeNode(5);
		
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		t3.left = t6;
		t3.right = t7;
		t2.right = t5;
		t1.left = t2;
		t1.right = t3;
		DFS(t1);// 1 2 5 3 6 7
		System.out.println();
		BFS(t1);//1 2 3 5 6 7 
		System.out.println();
		List<String> paths = findTreePath(t1);
		for(String path : paths) {
			System.out.println(path);
		}
		System.out.println(countGoodNode(0, t1));
		
		TreeNode s1 = new TreeNode(3);
		TreeNode s2 = new TreeNode(1);
		TreeNode s3 = new TreeNode(4);
		TreeNode s4 = new TreeNode(5);
		TreeNode s5 = new TreeNode(2);
		TreeNode s6 = new TreeNode(8);
		s1.left = s2;
		s1.right = s3;
		s2.left = s4;
		s3.left = s5;
		s3.right = s6;
		
		System.out.println(countGoodNode(0, s1));
	}
	
	/*
	 * 	返回所有从根节点(1)到叶子节点(left和right都是null的 5 6 7 )的路径
	 * 	List : "1->2->5", "1->3->6", "1->3->7"
	 * 	Tips: DFS
	 *	如果到了发现是叶子节点，name把当前路径拼接的字符串加到List中

	 */
	private static List<String> findTreePath(TreeNode root){
		List<String> result = new ArrayList<String>();
		get_path("", result, root);
		return result;
	}
	
	/*
	 * 1.值传递：方法调用的时候，实际的参数把它的值传给对应形式参数，方法执行中形式参数的值不影响实际参数的值
	 * 	- 基本数据类型 + String
	 * 2.引用传递: 也叫地址传递。 方法调用的时候，实际参数的引用（其实是地址），被传递给方法中对应的形式参数，这时候对形式参数的操作就是对实际参数的操作
	 *	DFS
	 *      1
	 *   2      3 
	 *    5    6 7
	 */
	private static void get_path(String path, List<String> result, TreeNode root) {
		StringBuilder strb = new StringBuilder(path);
		if(null != root) {
			strb.append(root.val);
			
			if(null == root.left && null == root.right) {//说明是一个叶子节点
				result.add(strb.toString());
			}else {
				strb.append("->");
				if(null != root.left) {
					get_path(strb.toString(), result, root.left);
				}
				
				if(null !=root.right) {
					get_path(strb.toString(), result, root.right);
				}
			}
		}
	}

	private static void BFS(TreeNode root) {//1->2->3->5
		//队列： 先进先出
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(null != root) {
			queue.add(root);
		}
		
		while(!queue.isEmpty()) {
			//出队
			TreeNode treeNode = queue.poll();
			System.out.print(treeNode.val + "->");
			if(null != treeNode.left) {
				queue.add(treeNode.left);
			}
			if(null != treeNode.right) {
				queue.add(treeNode.right);
			}
		}
	}
	
	private static void DFS(TreeNode root) {// 1->2->5->3
		if(root == null) {
			return;
		}
		System.out.print(root.val +"->");
		
		if(null != root.left) {
			DFS(root.left);
		}
		if(null != root.right) {
			DFS(root.right);
		}
	}

	/*
	 * 	String[] strs = { "arable", "arachnoid", "arbiter", "arab" };
		// 返回ar
		System.out.println(longestPre(strs));

		String[] anmals = { "lion", "tiger", "cat", "dog" };
		System.out.println(longestPre(anmals));
		
		String[] people = { "tom", "tomm"};
		System.out.println(longestPre(people));

		String s = "hello";
		// 如何取字符串长度?
		System.out.println(s.length());
		// 如何根据下标取字符串中第几个字母？
		System.out.println(s.charAt(0));
		char c = 'h';
		System.out.println(String.valueOf(c));
	 */
	private static String longestPre(String[] strs) {
		if (null == strs || strs.length == 0) {
			return "";
		}

		String result = null;
		for (String s : strs) {
			if (null == result) {
				result = s;
			} else {
				for (int i = 0; i < result.length() && i < s.length(); i++) {
					if (result.charAt(i) != s.charAt(i)) {
						result = result.substring(0, i);
						break;
					}
				}
			}
		}
		return result;
	}
}
