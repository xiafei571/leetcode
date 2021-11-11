package am;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindow76 {
	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(minWindow("aa", "aa"));
		System.out.println(minWindow("bbaa", "aba"));
		System.out.println(minWindow("a", "aa"));
	}

	private static String updateMinStr(String minStr, String currWindow) {
		if (minStr == "") {
			return currWindow;
		} else if (minStr.length() > currWindow.length()) {
			return currWindow;
		} else {
			return minStr;
		}
	}

	public static String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		String minStr = "";

		for (int i = 0; i < t.length(); i++) {
			int count = map.getOrDefault(t.charAt(i), 1);
			map.put(t.charAt(i), count-1);
		}

		int l = 0;
		int r = 0;
		int t_size = map.keySet().size();
		int curr_size = 0;

		while (l <= r && (r < s.length() || curr_size == t_size) ) {
			if (curr_size < t_size) {
				char right = s.charAt(r);
				if (map.containsKey(right)) {
					int count = map.get(right);
					if (count == 0) {
						curr_size++;
					}
					map.put(right, count + 1);
				}
				r++;
			} else {
				char left = s.charAt(l);
				minStr = updateMinStr(minStr, s.substring(l, r));
				if (map.containsKey(left)) {
					int count = map.get(left);
					count--;
					if (count == 0) {
						curr_size--;
					}
					map.put(left, count);
				}
				l++;
			}
		}
		return minStr;
	}
}
