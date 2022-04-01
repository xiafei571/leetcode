package bb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class WordBreak140 {
	private static Map<String, List<String>> cache;
	
	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> list = new ArrayList<String>();
		//wordDict = ["cat","cats","and","sand","dog"]
		list.add("cat");
		list.add("cats");
		list.add("and");
		list.add("sand");
		list.add("dog");
		
		wordBreak(s, list);
	}

	public static List<String> wordBreak(String s, List<String> wordDict) {
		cache = new HashMap<String, List<String>>();
		HashSet<String> dict = new HashSet<String>(wordDict);
		return backtrack(s, dict);
	}

	private static List<String> backtrack(String s, HashSet<String> dict) {
		if (cache.containsKey(s)) {
			return cache.get(s);
		}

		List<String> res = new ArrayList<String>();
		for (String word : dict) {
			if (s.startsWith(word)) {
				String next = s.substring(word.length());
				if (next.isEmpty()) {
					res.add(word);
					continue;
				}

				List<String> subList = backtrack(next, dict);
				for (String sub : subList) {
					res.add(word + " " + sub);
				}
			}
		}
		cache.put(s, res);
		return res;
	}
}
