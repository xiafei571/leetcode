package bb;

import java.util.PriorityQueue;

public class KthSmallest378 {
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Block> heap = new PriorityQueue<Block>((a, b) -> a.val - b.val);
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		heap.add(new Block(0, 0, matrix[0][0]));

		for (int i = 0; i < k - 1; i++) {
			Block top = heap.poll();
			if (top.i + 1 < matrix.length && !visited[top.i + 1][top.j]) {
				heap.add(new Block(top.i + 1, top.j, matrix[top.i + 1][top.j]));
				visited[top.i + 1][top.j] = true;
			}

			if (top.j + 1 < matrix[0].length && !visited[top.i][top.j + 1]) {
				heap.add(new Block(top.i, top.j + 1, matrix[top.i][top.j + 1]));
				visited[top.i][top.j + 1] = true;
			}

		}

		return heap.poll().val;

	}

	class Block {
		int i;
		int j;
		int val;

		public Block(int i, int j, int val) {
			this.i = i;
			this.j = j;
			this.val = val;
		}
	}
}
