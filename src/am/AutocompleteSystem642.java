package am;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutocompleteSystem642 {
	
	public static void main(String[] args) {
//		String[] s = {"i love you", "island","ironman", "i love leetcode"};
//		int[] times = {5,3,2,2};
//		AutocompleteSystem642 as = new AutocompleteSystem642(s, times);
//		List<String> list = as.input("i");
	}

	private Trie root;

	class Trie {
		int times;
		String sentence;
		Trie[] childs;

		public Trie() {
			times = 0;
			sentence = null;
			childs = new Trie[27];// 26 + space
		}
	}

	public static int getIndex(char c) {
		return c == ' ' ? 26 : c - 'a';
	}
	
	public static int getChar(int idx) {
		return idx == 26 ? ' ' : (char)('a'+idx);
	}

	private void insert(String sentence, Trie node, int times) {
		for (int i = 0; i < sentence.length(); i++) {
			if (node.childs[getIndex(sentence.charAt(i))] == null) {
				node.childs[getIndex(sentence.charAt(i))] = new Trie();
			}
			node = node.childs[getIndex(sentence.charAt(i))];
		}
		node.times += times;
		node.sentence = sentence;
	}

	public AutocompleteSystem642(String[] sentences, int[] times) {
		root = new Trie();
		for (int i = 0; i < sentences.length; i++) {
			insert(sentences[i], root, times[i]);
		}
	}

	String pre = "";

	public List<String> input(char c) {
		List<String> res = new ArrayList<String>();
		if (c == '#') {
			insert(pre, root, 1);
			pre = "";
		} else {
			pre += c;
			List<Node> list = search(root, pre);
			Collections.sort(list, (a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
			for (int i = 0; i < Math.min(3, list.size()); i++)
				res.add(list.get(i).sentence);
		}
		return res;
	}

	private List<Node> search(Trie t, String input) {
		List<Node> res = new ArrayList<Node>();
		for (int i = 0; i < input.length(); i++) {
			if (t.childs[getIndex(input.charAt(i))] == null) {
				return res;
			}
			t = t.childs[getIndex(input.charAt(i))];
		}
		dfs(input, t, res);
		return res;
	}

	private void dfs(String s, Trie t, List<Node> list) {
		if (t.times > 0) {
			list.add(new Node(t.times, t.sentence));
		}
		
		for(int i = 0; i < 27; i++) {
			if(t.childs[i] != null) {
				dfs(s+getChar(i), t.childs[i], list);
			}
		}
		
	}

	static class Node {
		int times;
		String sentence;

		public Node(int times, String sentence) {
			this.times = times;
			this.sentence = sentence;
		}
	}

}
