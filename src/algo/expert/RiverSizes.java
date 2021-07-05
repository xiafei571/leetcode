package algo.expert;

import java.util.ArrayList;
import java.util.List;

public class RiverSizes {
	public static List<Integer> riverSizes(int[][] matrix) {
		// Write your code here.
		List<Integer> list = new ArrayList<Integer>();
		if (matrix.length == 1 && matrix[0].length == 1) {
			if (matrix[0][0] == 1) {
				list.add(1);
			}
			return list;
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 1) {// && isOriginal(i, j, matrix)
					list.add(dfs(i, j, matrix));
				}
			}
		}
		return list;
	}

	private static int dfs(int i, int j, int[][] matrix) {
		int river = 1;
		matrix[i][j] = 0;
		if (isEnd(i, j, matrix)) {
			return river;
		}

		if (j + 1 < matrix[0].length && matrix[i][j + 1] == 1) {
			river += dfs(i, j + 1, matrix);
		}

		if (j - 1 >= 0 && matrix[i][j - 1] == 1) {
			river += dfs(i, j - 1, matrix);
		}

		if (i + 1 < matrix.length && matrix[i + 1][j] == 1) {
			river += dfs(i + 1, j, matrix);
		}

		if (i - 1 >= 0 && matrix[i - 1][j] == 1) {
			river += dfs(i - 1, j, matrix);
		}

		return river;
	}

	private static boolean isEnd(int i, int j, int[][] matrix) {
		if (matrix.length == 1) {
			// only one row
			if (j == 0) {
				return matrix[i][j + 1] == 0;
			} else if (j == matrix[0].length - 1) {
				return matrix[i][j - 1] == 0;
			} else {
				return matrix[i][j + 1] == 0 && matrix[i][j - 1] == 0;
			}
		} else if (matrix[0].length == 1) {
			// only one col
			if (i == 0) {
				return matrix[i + 1][j] == 0;
			} else if (i == matrix.length - 1) {
				return matrix[i - 1][j] == 0;
			} else {
				return matrix[i + 1][j] == 0 && matrix[i - 1][j] == 0;
			}
		} else if (i == matrix.length - 1) {
			// last row
			if (j == 0) {
				return matrix[i - 1][j] == 0 && matrix[i][j + 1] == 0;
			} else if (j == matrix[0].length - 1) {
				return matrix[i - 1][j] == 0 && matrix[i][j - 1] == 0;
			} else {
				return matrix[i - 1][j] == 0 && matrix[i][j + 1] == 0 && matrix[i][j - 1] == 0;
			}

		} else if (i == 0) {
			// first row
			if (j == 0) {
				return matrix[i + 1][j] == 0 && matrix[i][j + 1] == 0;
			} else if (j == matrix[0].length - 1) {
				return matrix[i + 1][j] == 0 && matrix[i][j - 1] == 0;
			} else {
				return matrix[i + 1][j] == 0 && matrix[i][j + 1] == 0 && matrix[i][j - 1] == 0;
			}
		} else {
			if (j == 0) {
				return matrix[i + 1][j] == 0 && matrix[i - 1][j] == 0 && matrix[i][j + 1] == 0;
			} else if (j == matrix[0].length - 1) {
				return matrix[i + 1][j] == 0 && matrix[i - 1][j] == 0 && matrix[i][j - 1] == 0;
			} else {
				return matrix[i + 1][j] == 0 && matrix[i - 1][j] == 0 && matrix[i][j + 1] == 0 && matrix[i][j - 1] == 0;
			}
		}
	}

	@Deprecated
	private static boolean isOriginal(int i, int j, int[][] matrix) {
		// whether the point is the original of river
		if (i == 0) {
			if (j == 0 || matrix[i][j - 1] == 0) {
				return true;
			}
			return false;
		} else if (j == 0) {
			if (matrix[i - 1][j] == 0) {
				return true;
			}
			return false;
		} else {
			if (matrix[i][j - 1] == 0 && matrix[i - 1][j] == 0) {
				return true;
			}
			return false;
		}
	}
}
