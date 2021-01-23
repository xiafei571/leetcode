package algo.expert;

public class RemoveIslands {
	public int[][] removeIslands(int[][] matrix) {
		// Write your code here.
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1 && isBorder(matrix, i, j)) {
					dfs(matrix, i, j);
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == -1) {
					matrix[i][j] = 1;
				} else if (matrix[i][j] == 1) {
					matrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}

	private boolean isBorder(int[][] matrix, int i, int j) {
		return i == 0 || i == matrix.length - 1 || j == 0 || j == matrix[0].length - 1;
	}

	private void dfs(int[][] matrix, int i, int j) {
		matrix[i][j] = -1;
		// right
		if (j < matrix[0].length - 1 && matrix[i][j + 1] == 1) {
			dfs(matrix, i, j + 1);
		}

		// left
		if (j > 0 && matrix[i][j - 1] == 1) {
			dfs(matrix, i, j - 1);
		}

		// down
		if (i < matrix.length - 1 && matrix[i + 1][j] == 1) {
			dfs(matrix, i + 1, j);
		}

		// top
		if (i > 0 && matrix[i - 1][j] == 1) {
			dfs(matrix, i - 1, j);
		}
	}
}
