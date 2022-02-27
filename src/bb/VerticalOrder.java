package bb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VerticalOrder {
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

	// 3
	// 9 8
	// 4 0 1 7
	// 2 5
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		List<OrderNode> list = new ArrayList<OrderNode>();
		dfs(root, 0, 0, list);
		Collections.sort(list, new Comparator<OrderNode>() {
			@Override
			public int compare(OrderNode ob1, OrderNode ob2) {
				if (ob1.col == ob2.col) {
					return ob1.row - ob2.row;
				}
				return ob1.col - ob2.col;
			}
		});

		List<Integer> columnList = new ArrayList<Integer>();
		columnList.add(list.get(0).val);

		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).col == list.get(i - 1).col) {
				columnList.add(list.get(i).val);
			} else {
				result.add(columnList);
				columnList = new ArrayList<Integer>();
				columnList.add(list.get(i).val);
			}
		}
		result.add(columnList);

		return result;
	}

	private void dfs(TreeNode root, int col, int row, List<OrderNode> list) {
		if (root == null) {
			return;
		}

		list.add(new OrderNode(col, row, root.val));
		dfs(root.left, col - 1, row + 1, list);
		dfs(root.right, col + 1, row + 1, list);
	}

	class OrderNode {
		int col;
		int row;
		int val;

		public OrderNode(int col, int row, int val) {
			this.col = col;
			this.row = row;
			this.val = val;
		}
	}
}
