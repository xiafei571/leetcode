package kt;

import java.util.ArrayList;
import java.util.List;

public class WordSearch3 {
	static class Trie {
		String word;
		char val;
		Trie[] child;

		public Trie(char val) {
			this.word = null;
			this.child = new Trie[26];
			this.val = val;
		}

	}

	private static void buildTrie(Trie root, String[] words) {
		for (String word : words) {
			Trie cur = root;
			for (char ch : word.toCharArray()) {
				if (cur.child[ch - 'a'] == null)
					cur.child[ch - 'a'] = new Trie(ch);
				cur = cur.child[ch - 'a'];
			}
			cur.word = word;
		}
	}

	public List<String> findWords(char[][] board, String[] words) {
		Trie root = new Trie(' ');
		buildTrie(root, words);
		List<String> res = new ArrayList<String>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (root.child[board[i][j] - 'a'] != null)
					dfs(board, i, j, root, res);
			}
		}

		return res;
	}

	private static void dfs(char[][] board, int i, int j, Trie cur, List<String> res) {
		if (!inArea(board, i, j)) {
			return;
		}

		char ch = board[i][j];
		if (ch == '*' || cur.child[ch - 'a'] == null) {
			return;
		}

		cur = cur.child[ch - 'a'];
		if (cur.word != null) {
			res.add(cur.word);
			cur.word = null;
		}

		board[i][j] = '*';
		dfs(board, i + 1, j, cur, res);
		dfs(board, i - 1, j, cur, res);
		dfs(board, i, j + 1, cur, res);
		dfs(board, i, j - 1, cur, res);
		board[i][j] = ch;
	}

	private static boolean inArea(char[][] board, int i, int j) {
		return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
	}
}
