package bytedance;

public class HasPath490 {
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		return dfs(maze, start, destination, visited);

	}

	private static boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
		int x = start[0];
		int y = start[1];

		if (visited[x][y]) {
			return false;
		}

		if (x == destination[0] && y == destination[1]) {
			return true;
		}

		visited[x][y] = true;

		int up = x - 1;
		int down = x + 1;
		int left = y - 1;
		int right = y + 1;

		// up
		while (up >= 0 && maze[up][y] == 0) {
			up--;
		}
		if (dfs(maze, new int[] { up + 1, y }, destination, visited)) {
			return true;
		}
		// down
		while (down < maze.length && maze[down][y] == 0) {
			down++;
		}
		if (dfs(maze, new int[] { down - 1, y }, destination, visited)) {
			return true;
		}
		// left
		while (left >= 0 && maze[x][left] == 0) {
			left--;
		}
		if (dfs(maze, new int[] { x, left + 1 }, destination, visited)) {
			return true;
		}
		// right
		while (right < maze[0].length && maze[x][right] == 0) {
			right++;
		}
		if (dfs(maze, new int[] { x, right - 1 }, destination, visited)) {
			return true;
		}

		return false;

	}
}
