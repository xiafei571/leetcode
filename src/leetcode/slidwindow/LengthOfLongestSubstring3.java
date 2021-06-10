package leetcode.slidwindow;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring3 {
	public static int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		int left = 0;
		int res = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				left = Math.max(map.get(c)+1, left);
				map.put(c, i);
			} else {
				map.put(c, i);
			}

			res = Math.max(res, i - left + 1);
		}

		return res;

	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abba"));
	}
}
