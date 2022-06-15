package kt;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
	static List<Integer[]> res;

	public static void main(String[] args) {
		char[][] board = { { 'A', 'c', 'c', 'E' }, { 'S', 'c', 'c', 'S' }, { 'A', 'c', 'c', 'E' } };
		String word = "ccc";
		System.out.println(exist(board, word));
		for (Integer[] path : res) {
			System.out.println(path[0] + ":" + path[1]);
		}
	}

	public static boolean exist(char[][] board, String word) {// time limit exceeded
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				res = new ArrayList<Integer[]>();
				if (dfs(board, i, j, word, 0, res)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean dfs(char[][] board, int i, int j, String word, int idx, List<Integer[]> res) {
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
		res.add(new Integer[] { i, j });
		boolean left = dfs(board, i, j - 1, word, idx + 1, res);
		boolean right = dfs(board, i, j + 1, word, idx + 1, res);
		boolean up = dfs(board, i - 1, j, word, idx + 1, res);
		boolean down = dfs(board, i + 1, j, word, idx + 1, res);
		board[i][j] = ch;
		boolean next = left || right || up || down;
		if(!next) {
			res.remove(res.size() - 1);
		}
		return next;
	}

	private static boolean inArea(char[][] board, int i, int j) {
		return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
	}
}
