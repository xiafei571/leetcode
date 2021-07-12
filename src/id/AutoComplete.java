package id;

import java.util.ArrayList;
import java.util.List;

public class AutoComplete {
	public static void main(String[] args) {
		Trie trieTree = new Trie();
		trieTree.insert("app");
		trieTree.insert("apple");
		trieTree.insert("blue");

		List<String> list = trieTree.autoComplete("appl");
		for (String s : list) {
			System.out.println(s);
		}
	}
	/*
	 * Auto complete,Say I'm typing on a phone. Given a prefix String,and a
	 * dictionary.Find all auto-complete word for the given prefix string
	 */

	/*
	 * 前缀树
	 */
	static class Trie {
		private Trie[] children;
		private boolean isEnd;
		private char val;

		public Trie() {
			children = new Trie[26];
			isEnd = false;
		}

		public void insert(String word) {
			//insert and search Time O(S), S:每次插入的字符串的长度
			//Space O(N*M), N:字符串长度，M:children大笑
			Trie node = this;
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				int index = ch - 'a';
				node.val = ch;
				if (node.children[index] == null) {
					node.children[index] = new Trie();
				}
				node = node.children[index];
			}
			node.isEnd = true;
		}

		public List<String> autoComplete(String prefix) {
			List<String> result = new ArrayList<String>();
			Trie node = this;
			for (int i = 0; i < prefix.length(); i++) {
				char ch = prefix.charAt(i);
				if (node.children[ch - 'a'] == null) {
					return result;
				}

				node = node.children[ch - 'a'];
			}

			dfs(prefix, node, result);
			return result;
		}

		private void dfs(String prefix, Trie node, List<String> result) {
			if (node.isEnd) {
				result.add(prefix);
			}
			
			for (Trie child : node.children) {
				if (child != null) {
					dfs(prefix+String.valueOf(node.val), child, result);
				}
			}
		}
	}
}
