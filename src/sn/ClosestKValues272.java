package sn;

import java.util.ArrayList;
import java.util.List;
import common.TreeNode;

public class ClosestKValues272 {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> res = new ArrayList<>();
		inorder(root, res);

		List<Double> distance = new ArrayList<Double>();
		for (int i = 0; i < res.size(); i++) {
			distance.add(Math.abs(target - res.get(i)));
		}

		quickSelect(k, res, distance, 0, res.size() - 1);
		return res.subList(0, k);
	}

	private void quickSelect(int k, List<Integer> res, List<Double> distance, int left, int right) {
		if (left == right || k >= res.size()) {
			return;
		}
		int p = pagination(res, distance, left, right);
		if (p == k) {
			return;
		} else if (p < k) {
			quickSelect(k, res, distance, p + 1, right);
		} else {
			quickSelect(k, res, distance, left, p - 1);
		}
	}

	private int pagination(List<Integer> res, List<Double> distance, int left, int right) {
		double p = distance.get(right);
		int i = left;
		for (int j = i; j < right; j++) {
			if (distance.get(j) < p) {
				swap(res, distance, i, j);
				i++;
			}
		}
		swap(res, distance, i, right);
		return i;
	}

	private void swap(List<Integer> res, List<Double> distance, int i, int j) {
		Integer temp1 = res.get(i);
		res.set(i, res.get(j));
		res.set(j, temp1);

		Double temp2 = distance.get(i);
		distance.set(i, distance.get(j));
		distance.set(j, temp2);
	}

	private void inorder(TreeNode root, List<Integer> res) {
		if (root != null) {
			inorder(root.left, res);
			res.add(root.val);
			inorder(root.right, res);
		}
	}
}
