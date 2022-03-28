package kt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch1 {
	/*
	 * 第一题是给出一个string数组，一个string，返回string中字母可以构成的数组中的string，比 如[ "cat", "baby",
	 * "dog", "bird", "car", "ax" ]，"tcabnihjs" 将返回"cat"。 题是这个，但是 具体，是需要考虑到 里面字符的个数，
	 * 我第一次出了bug，没考虑清楚，比 如，'catt' 就不能出现在 tacc， 因为，t被拥有了两次，然后返回一个就好了。
	 */
	public static void main(String[] args) {
		String[] words = { "cat", "baby", "dog", "bird", "car", "ax", "catt" };
		String s = "tcabnihjsy";
		List<String> res = wordSearch(words, s);
		for(String str : res) {
			System.out.println(str);
		}
	}

	private static List<String> wordSearch(String[] words, String s) {
		List<String> res = new ArrayList<String>();
		Map<Character, Integer> counter = new HashMap<Character, Integer>();
		for (Character ch : s.toCharArray()) {
			Integer cnt = counter.getOrDefault(ch, 0);
			counter.put(ch, cnt + 1);
		}

		for (String word : words) {
			Map<Character, Integer> temp = new HashMap<Character, Integer>(counter);
			for (int i = 0; i < word.length(); i++) {
				Character ch = word.charAt(i);
				if (!temp.containsKey(ch) || temp.get(ch) <= 0) {
					break;
				}

				if (i == word.length() - 1) {
					res.add(word);
				} else {
					Integer cnt = temp.get(ch);
					temp.put(ch, cnt - 1);
				}
			}
		}

		return res;
	}

}
