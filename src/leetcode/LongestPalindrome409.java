package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome409 {
	public int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int result = 0;
		for (Character c : map.keySet()) {
			int count = map.get(c);
			result += (count / 2) * 2;
			if (result % 2 == 0 && count % 2 == 1) {
				result++;
			}
		}

		return result;
	}
}
