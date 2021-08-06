package am;

public class TicTacToe348 {
	/** Initialize your data structure here. */
	static int[][] board;

	public TicTacToe348(int n) {
		board = new int[n][n];
	}

	/**
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row    The row of the board.
	 * @param col    The column of the board.
	 * @param player The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 */
	public int move(int row, int col, int player) {
		if (moveVaild(row, col)) {
			board[row][col] = player;
			if (checkWin(row, col, player)) {
				return player;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	private static boolean moveVaild(int row, int col) {
		return row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == 0;
	}

	private static boolean checkWin(int row, int col, int player) {
		return checkRow(row, player) || checkCol(col, player) || checkCro(row, col, player);
	}

	private static boolean checkRow(int row, int player) {
		int[] curr = board[row];
		for (int i = 0; i < curr.length; i++) {
			if (curr[i] != player) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkCol(int col, int player) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] != player) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkCro(int row, int col, int player) {
		boolean left = true;
		boolean right = true;
		for (int i = 0; i < board.length; i++) {
			if (board[i][i] != player) {
				left = false;
				break;
			}
		}

		if (left) {
			return true;
		}

		for (int i = 0; i < board.length; i++) {
			if (board[i][board.length - i - 1] != player) {
				right = false;
				break;
			}
		}

		return right;
	}
}
