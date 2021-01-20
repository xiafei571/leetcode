package algo.expert;

public class SearchInSortedMatrix {
	public static int[] searchInSortedMatrix(int[][] matrix, int target) {
		// Write your code here.

		int i = 0;
		int j = matrix[0].length - 1;

		while (i < matrix.length && j >= 0) {
			if (matrix[i][j] > target) {
				j--;
			} else if (matrix[i][j] < target) {
				i++;
			} else {
				return new int[] { i, j };
			}
		}

		return new int[] { -1, -1 };
	}
}
