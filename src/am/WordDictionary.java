package am;

/**
 * 
 * 211
 *
 */
public class WordDictionary {

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		System.out.println(wordDictionary.search("pad")); // return False
		System.out.println(wordDictionary.search("bad")); // return True
		System.out.println(wordDictionary.search(".ad")); // return True
		System.out.println(wordDictionary.search("b..")); // return True
	}

	class Trie {
		Trie[] childs = new Trie[26];
		char c;
		boolean isEnd = false;

		public Trie() {

		}

		public Trie(char c) {
			this.c = c;
		}
	}

	private Trie root;

	public WordDictionary() {
		root = new Trie();
	}

	public void addWord(String word) {
		Trie curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			Trie next = curr.childs[c - 'a'];
			if (next == null) {
				next = new Trie(c);
			}
			curr.childs[c - 'a'] = next;
			curr = next;
		}
		curr.isEnd = true;
	}

	private static boolean dfs(String word, int idx, Trie curr) {
		if (curr == null) {
			return false;
		}
		
		if (idx == word.length()) {
			return curr.isEnd ? true : false;
		}

		char c = word.charAt(idx);
		if (c == '.') {
			Trie[] childs = curr.childs;
			for (Trie child : childs) {
				if (dfs(word, idx + 1, child)) {
					return true;
				}
			}
			return false;
		} else {
			return dfs(word, idx + 1, curr.childs[c - 'a']);
		}
	}

	public boolean search(String word) {
		Trie curr = root;
		return dfs(word, 0, curr);
	}
}
