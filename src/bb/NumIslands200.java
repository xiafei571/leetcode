package bb;

public class NumIslands200 {
	public int numIslands(char[][] grid) {
		int num = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					num++;
				}
			}
		}

		return num;
	}

	private void dfs(char[][] grid, int i, int j) {
		if (!inArea(grid, i, j) || grid[i][j] != '1') {
			return;
		}
		// visited
		grid[i][j] = '2';

		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
	}

	private static boolean inArea(char[][] grid, int i, int j) {
		return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
	}
}
