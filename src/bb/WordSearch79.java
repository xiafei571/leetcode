package bb;

public class WordSearch79 {
	/*
	 * O(N*3^L) where N is the number of cells(n*m) in the board and L is the length
	 * of the word to be matched.
	 */
	public boolean exist(char[][] board, String word) {// time limit exceeded
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) { // O(n*m)
				if (dfs(board, i, j, word, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, int i, int j, String word, int idx) {// O(3^L)
		if (idx == word.length()) {
			return true;
		}

		if (!inArea(board, i, j)) {
			return false;
		}

		char ch = board[i][j];
		if (word.charAt(idx) != ch) {
			return false;
		}

		board[i][j] = '*';
		boolean left = dfs(board, i, j - 1, word, idx + 1);
		boolean right = dfs(board, i, j + 1, word, idx + 1);
		boolean up = dfs(board, i - 1, j, word, idx + 1);
		boolean down = dfs(board, i + 1, j, word, idx + 1);
		board[i][j] = ch;

		return left || right || up || down;
	}

	private boolean inArea(char[][] board, int i, int j) {
		return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
	}
}
