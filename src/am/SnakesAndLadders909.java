package am;

import java.util.ArrayDeque;
import java.util.Queue;

public class SnakesAndLadders909 {

	public int snakesAndLadders(int[][] board) {
		int n = board.length;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		boolean[] visited = new boolean[n * n + 1];
		int min = Integer.MAX_VALUE;
		int moves = 0;

		while (!q.isEmpty()) {
			// System.out.println("---");
			// BFS
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				// System.out.println(cur);
				if (cur == n * n) {// update min
					min = Math.min(min, moves);
				}

				for (int j = 1; j <= 6; j++) {
					int num = cur + j;
					// out
					if (num > n * n) {
						break;
					}

					if (visited[num] || num == cur) {
						continue;
					}

					visited[num] = true;
					int[] pos = getPos(num, n);
					int row = pos[0];
					int col = pos[1];

					if (board[row][col] == -1) {
						q.offer(num);
					} else {
						q.offer(board[row][col]);
					}

				}

			}
			// System.out.println("moves++"+moves);
			moves++;
		}

		return min == Integer.MAX_VALUE ? -1 : min;
	}

	static int[] getPos(int num, int n) {
		int row = n - (num - 1) / n - 1;
		int col = (n - row) % 2 != 0 ? (num - 1) % n : n - (num - 1) % n - 1;
		// System.out.println(row+","+col);
		return new int[] { row, col };
	}

}
