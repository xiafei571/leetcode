package am;
/**
 * 
 * 695 DFS
 *
 */
public class MaxAreaOfInsland {
	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		System.out.println(maxAreaOfIsland(grid));
	}

	public static int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int currMax = 0;
				if (grid[i][j] == 1) {
					currMax = dfs(i, j, grid);
					System.out.println(currMax);
				}

				maxArea = Math.max(maxArea, currMax);
			}
		}
		return maxArea;
	}

	public static int dfs(int i, int j, int[][] grid) {
		if (!inArea(i, j, grid)) {
			return 0;
		}

		if (grid[i][j] == 1) {
			grid[i][j] = -1;
			int currMax = 1;
			// up
			currMax += dfs(i - 1, j, grid);
			// down
			currMax += dfs(i + 1, j, grid);
			// left
			currMax += dfs(i, j - 1, grid);
			// right
			currMax += dfs(i, j + 1, grid);
			return currMax;
		} else {
			return 0;
		}

	}

	private static boolean inArea(int i, int j, int[][] grid) {
		return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
	}
}
