package am;

import java.util.ArrayList;
import java.util.List;

public class FindWords212 {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();
		TrieNode root = new TrieNode(' ');
		buildTrie(root, words);

//         for(String word : words){
//             if(exist(board, word)){
//                 res.add(word);
//             }

//         }
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char ch = board[i][j];
				if (root.childs[ch - 'a'] != null) {
					dfs(board, i, j, root, res);
				}
			}
		}

		return res;
	}

	private void dfs(char[][] board, int i, int j, TrieNode cur, List<String> res) {
		if (!inArea(board, i, j)) {
			return;
		}

		char ch = board[i][j];

		if (ch == '*') {
			return;
		}

		if (cur.childs[ch - 'a'] == null) {
			return;
		}

		cur = cur.childs[ch - 'a'];
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

	private boolean exist(char[][] board, String word) {// time limit exceeded
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, i, j, word, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, int i, int j, String word, int idx) {
		if (idx == word.length()) {
			return true;
		}

		if (!inArea(board, i, j)) {
			return false;
		}

		if (word.charAt(idx) != board[i][j]) {
			return false;
		}

		char ch = board[i][j];
		board[i][j] = '*';
		boolean found = dfs(board, i, j - 1, word, idx + 1) || dfs(board, i, j + 1, word, idx + 1)
				|| dfs(board, i - 1, j, word, idx + 1) || dfs(board, i + 1, j, word, idx + 1);

		board[i][j] = ch;
		return found;
	}

	private boolean inArea(char[][] board, int i, int j) {
		return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
	}

	private void buildTrie(TrieNode root, String[] words) {
		for (String word : words) {
			TrieNode cur = root;
			for (char ch : word.toCharArray()) {
				if (cur.childs[ch - 'a'] == null) {
					cur.childs[ch - 'a'] = new TrieNode(ch);
				}
				cur = cur.childs[ch - 'a'];
			}
			cur.word = word;
		}
	}

	class TrieNode {
		char val;
		TrieNode[] childs;
		String word;

		public TrieNode(char val) {
			this.val = val;
			childs = new TrieNode[26];
			word = null;
		}
	}
}
