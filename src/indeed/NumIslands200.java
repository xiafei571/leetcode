package indeed;

public class NumIslands200 {
	public int numIslands(char[][] grid) {
		int result = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					result++;
				}
			}
		}
		return result;
	}

	public static void dfs(char[][] grid, int r, int c) {
		if (!inArea(grid, r, c)) {
			return;
		}

		if (grid[r][c] != '1') {
			return;
		}

		grid[r][c] = '2';

		dfs(grid, r + 1, c);
		dfs(grid, r, c + 1);
		dfs(grid, r - 1, c);
		dfs(grid, r, c - 1);
	}

	public static boolean inArea(char[][] grid, int r, int c) {
		return 0 <= r && r < grid.length && c >= 0 && c < grid[0].length;
	}

	public static void main(String[] args) {

	}
}
