package bb;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring3 {
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0;
		int right = 0;
		int res = 0;

		while (right < s.length()) {
			char r = s.charAt(right);
			if (map.containsKey(r)) {
				int last = map.get(r);// 1
				map.put(r, right); // 2
				left = Math.max(last + 1, left); // left = 2
			} else {
				map.put(r, right);// a:0 b:1
			}
			// System.out.println(left+"~"+right);
			res = Math.max(res, right - left + 1);
			right++;
		}
		return res;
	}
}
