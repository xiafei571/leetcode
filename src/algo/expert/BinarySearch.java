package algo.expert;

public class BinarySearch {
	public static int binarySearch(int[] array, int target) {
		return binarySearchHelper(array, target, 0, array.length - 1);
	}

	private static int binarySearchHelper(int[] array, int target, int left, int right) {
		if (left > right) {
			return -1;
		}

		int m = (left + right) / 2;

		if (array[m] == target) {
			return m;
		} else if (array[m] > target) {
			return binarySearchHelper(array, target, left, m - 1);
		} else {
			return binarySearchHelper(array, target, m + 1, right);
		}
	}
}
