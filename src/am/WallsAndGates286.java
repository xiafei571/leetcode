package am;

public class WallsAndGates286 {
	final static int INF = 2147483647;

	public void wallsAndGates(int[][] rooms) {

		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {// gate
					int[][] visited = new int[rooms.length][rooms[0].length];
					dfs(i, j, rooms, visited, 0);
					// printMap(rooms);
				}
			}
		}
	}

	private static void printMap(int[][] rooms) {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == INF) {
					System.out.print(" - ");
				} else {
					System.out.print(" " + rooms[i][j] + " ");
				}

			}
			System.out.println("");
		}
		System.out.println("");
	}

	private void dfs(int i, int j, int[][] rooms, int[][] visited, int dist) {
		if (!inArea(i, j, rooms) || rooms[i][j] == -1) {
			return;
		}

		// System.out.println("curr i:"+i+" j:"+j+" dist:"+dist);

		if (rooms[i][j] == 0 && dist != 0) {
			return;
		}

		if (visited[i][j] == 1) {
			if (dist < rooms[i][j]) {// update
				rooms[i][j] = Math.min(rooms[i][j], dist);
			} else {
				return;
			}
		}

		visited[i][j] = 1;
		rooms[i][j] = Math.min(rooms[i][j], dist);
		// up
		dfs(i - 1, j, rooms, visited, dist + 1);
		// down
		dfs(i + 1, j, rooms, visited, dist + 1);
		// left
		dfs(i, j - 1, rooms, visited, dist + 1);
		// right
		dfs(i, j + 1, rooms, visited, dist + 1);

	}

	private boolean inArea(int i, int j, int[][] rooms) {
		return i >= 0 && j >= 0 && i < rooms.length && j < rooms[0].length;
	}
}
