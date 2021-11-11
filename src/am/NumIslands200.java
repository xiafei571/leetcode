package am;

public class NumIslands200 {
	public int numIslands(char[][] grid) {
		int num = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					num++;
					dfs(i, j, grid);
				}
			}
		}

		return num;
	}

	private static boolean inArea(int i, int j, char[][] grid) {
		return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
	}

	private static void dfs(int i, int j, char[][] grid) {
		if (!inArea(i, j, grid) || grid[i][j] != '1') {
			return;
		}

		// visited
		grid[i][j] = 'v';

		// up
		dfs(i - 1, j, grid);
		// down
		dfs(i + 1, j, grid);
		// left
		dfs(i, j - 1, grid);
		// right
		dfs(i, j + 1, grid);
	}
}
