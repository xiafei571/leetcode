package sn.oa;

public class NumIslands {
	
	final static int WALKED = -1;
	final static int DEFAULT_COLOR = 0;

	public int numIslands(char[][] grid) {
		int num = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					num++;
					dfs(grid, i, j);
				}
			}
		}

		return num;
	}

	private static void dfs(char[][] grid, int i, int j) {
		if (!inArea(grid, i, j)) {
			return;
		}

		grid[i][j] = '2';

		dfs(grid, i - 1, j);
		dfs(grid, i + 1, j);
		dfs(grid, i, j - 1);
		dfs(grid, i, j + 1);

	}

	private static boolean inArea(char[][] grid, int i, int j) {
		return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1';
	}
}
