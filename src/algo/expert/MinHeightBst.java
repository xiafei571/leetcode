package algo.expert;

import java.util.List;

public class MinHeightBst {
	public static BST minHeightBst(List<Integer> array) {
		// Write your code here.
		return minHeightBst(array, null, 0, array.size() - 1);
	}

	public static BST minHeightBst(List<Integer> array, BST root, int start, int end) {
		if (start > end) {
			return null;
		}
		int midIdx = (start + end) / 2;
		int midValue = array.get(midIdx);
		if (root == null) {
			root = new BST(midValue);
		} else {
			root.insert(midValue);
		}

		minHeightBst(array, root, start, midIdx - 1);
		minHeightBst(array, root, midIdx + 1, end);
		return root;
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
			left = null;
			right = null;
		}

		public void insert(int value) {
			if (value < this.value) {
				if (left == null) {
					left = new BST(value);
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					right = new BST(value);
				} else {
					right.insert(value);
				}
			}
		}
	}
}
