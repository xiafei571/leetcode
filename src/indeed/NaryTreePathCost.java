package indeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NaryTreePathCost {
	/*
	 * coding 树遍历根到叶⼦path min sum. follow up是DAG的最短路
	 */
	/*
	 * 两个面试官一个主面试官一个shadow（后来发现他是老大），一进门看到白板上的图楼主开始窃喜，果然是原题，注明一下在这之前楼主把地里所有的面经刷了三遍，
	 * 包括所有的代码手写了一遍，可以说是各种follow
	 * up倒背如流。第一问没有任何问题，秒解。问程序能不能提前退出，答当一个node的值已经比你存的最小值大的时候推出。问时间复杂度，
	 * 这里楼主脑子一热想到follow
	 * up去了，导致第一次打错了，面试官说你在想一想，回答O(M),这是由于打错了一个问题，楼主的心态发生了变化，有点儿焦虑，因为之前来的时候很自信，
	 * 觉得可以全程无bug结束，事实证明这是不可能的，保持心态最重要。然后跟地里说的一样，变成图，你的方法还能用么，答：能用但是效率很低。 问：那怎么改进？
	 * 答：memory search 或者dijkstra。 面试官：（点头）两个方法都可以，你随便写一个。由于觉得memory
	 * search好写，就写了memory
	 * search，用的是地里大神的方法。这里出现了巨大的bug，也就是我标题所说的，我按照写的滚瓜烂熟的方法写完了之后，非常自信。这时主面试官表情有点难看，
	 * 若有所思状，然后画了个图，说你跑一下这个用例，跑完了没错，然后又画了一个，还是没错，他有点儿脸色难看了，支支吾吾的不知道在说什么，
	 * 开始寻求shadow的帮助，shadow说你这方法不行，我惊。“为什么不行，用例不是跑了么？“，”你说是用了memory
	 * research但其实并没有解决效率问题， 你应该自底向上搜索，而不是自顶向下“，
	 * 这里我已经很着急了，非常想急切的证明我的方法是对的，然后开始重复之前我的思路给他听，他不听，说你的不对。我说我的对，不信我给你跑用例。他说你的不对，
	 * 于是我们两个争论这个问题到脸红耳赤，最后我也不是特别明白为什么我的方法不行，我倒是明白他的方法也是可行的了，但我没有说服他，这轮面完我心态已经炸了，
	 * 基本gg。
	 */

	/*
	 * Root to Leaf Min Cost Given a tree,(binary tree possibily) every tree edge
	 * has a cost， find the least cost or find the leaf node that the cost of path
	 * that from root to leaf is the least. 基础版: dfs就⾏
	 */

	/*
	 * 扩展到dag, 其实就是个dag的dp 做拓扑排序的时候dp就⾏了，我看⽹上的题解都是dijkstra，但我觉得拓扑排序可做⽽且复杂度还低
	 */

	/*
	 * 立刻给出DFS解法，后序遍历一遍拿到最短路径。写出了个小bug，及时纠正过来，三叔不以为然。接着问了问复杂度，改成DAG之后，这个方法复杂度是多少。是O(
	 * V!)，也是三叔给了点儿提示，不过真的就是一点儿。接下来说改成图之后怎么优化，时间这时候已经快不够了，提出用map来记录，避免重复计算。复杂度是O(V+E
	 * )，就被送下楼了
	 */

	/*
	 * min path to leaf
	 * followup：改成DAG行不行---再优化一下（解：加一个hashmap），时间复杂度是多少？（DAG优化之前是O(V!)优化之后是O(V+E)）
	 * 【我用DFS做，面试官说改成bfs优化一下，我就没弄出来】
	 * 
	 */

	/*
	 * 找从root到叶节点cost之和最小的路径，返回该leaf node。（dfs） follow-up：如果不是binary
	 * tree的结构，而是任意的单向图，问代码还是否work（yes）
	 * 有没有优化的地方？（我用hashmap存下每个节点到叶节点的distance，这样再次访问到该叶节点就不必dfs下去）。时间复杂度？（优化后是O（V+E）
	 * ）
	 * 
	 */

	/*
	 * 面是Root to Leaf Min
	 * Cost那题。两个美国小哥，都挺年轻的。我用的bottom-up的方法，改成DAG后加了个memorization来存储之前的结果，其他什么都不用变。
	 * 不提dijkstra完全没问题。有趣的是我cache的是边，主面试官表示赞同，shadow说这样cache不行，要cache
	 * node。但主面试官表示可以，然后他们争论了一分钟，结论是我的方案可行
	 */
	static class TreeNode {
		int val;
		TreeNode[] children;

		public TreeNode(int val, int n) {
			this.val = val;
			this.children = new TreeNode[n];
		}
	}

	private static int minCost = Integer.MAX_VALUE;

	public List<Integer> findMinCostFromRootToLeaf(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> curNode = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}

		int curCost = 0;
		DFS(root, curCost, curNode, result);

		return result;
	}

	private void DFS(TreeNode root, int curCost, List<Integer> curNode, List<Integer> result) {
		curNode.add(root.val);
		curCost += root.val;
		//Tips 1 当一个curCost的值已经比你存的最小值大的时候return，不用往下看了
		if(curCost >= minCost) {
			return;
		}
		TreeNode[] children = root.children;
		if (null == children || children.length == 0) {// is leaf
			if (curCost < minCost) {
				minCost = curCost;
				result.clear();
                result.addAll(curNode);
			}
			return;
		}

		for (TreeNode node : children) {
			DFS(node, curCost, curNode, result);
			curNode.remove(curNode.size() - 1);
		}
	}

	public static void main(String[] args) {
		NaryTreePathCost sol = new NaryTreePathCost();

		TreeNode root = new TreeNode(1, 2);
		root.children[0] = new TreeNode(2, 2);
		root.children[1] = new TreeNode(3, 3);
		root.children[0].children[0] = new TreeNode(4, 0);
		root.children[0].children[1] = new TreeNode(2, 0);
		root.children[1].children[0] = new TreeNode(3, 0);
		root.children[1].children[1] = new TreeNode(2, 0);
		root.children[1].children[2] = new TreeNode(0, 0);
		List<Integer> result = sol.findMinCostFromRootToLeaf(root);

		for (Integer e : result) {
			System.out.print(e + " ");
		}

		System.out.println("");
		System.out.println(minCost);
	}
}
