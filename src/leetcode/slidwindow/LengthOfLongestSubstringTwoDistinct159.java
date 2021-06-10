package leetcode.slidwindow;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringTwoDistinct159 {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			while (map.size() > 2) {
				char left_c = s.charAt(left);
				if (map.get(left_c) == 1) {
					map.remove(left_c);
				} else {
					map.put(left_c, map.get(left_c) - 1);
				}
				left++;
			}
			res = Math.max(res, i - left + 1);
		}

		return res;
	}
}
