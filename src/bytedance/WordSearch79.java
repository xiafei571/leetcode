package bytedance;

public class WordSearch79 {
	public boolean exist(char[][] board, String word) {
		if (word == null || word.length() == 0) {
			return false;
		}

		int idx = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				boolean[][] visited = new boolean[board.length][board[0].length];

				if (dfs(board, visited, word, i, j, idx)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int idx) {

		if (idx == word.length()) {
			return true;
		}

		if (!inArea(board, i, j) || visited[i][j]) {
			return false;
		}

		if (board[i][j] != word.charAt(idx)) {
			return false;
		}

		visited[i][j] = true;

		boolean up = dfs(board, visited, word, i - 1, j, idx + 1);
		boolean down = dfs(board, visited, word, i + 1, j, idx + 1);
		boolean left = dfs(board, visited, word, i, j - 1, idx + 1);
		boolean right = dfs(board, visited, word, i, j + 1, idx + 1);

		visited[i][j] = false;

		return up || down || left || right;
	}

	private boolean inArea(char[][] board, int i, int j) {
		return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
	}
}
