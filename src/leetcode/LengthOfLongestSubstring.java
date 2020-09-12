package leetcode;

import java.util.HashSet;

public class LengthOfLongestSubstring {
	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		HashSet<Character> set = new HashSet<>();
		int left = 0, right = 0;
		while (right < s.length()) {
			while (set.contains(s.charAt(right)))
				set.remove(s.charAt(left++));
			set.add(s.charAt(right++));
			max = Math.max(max, right - left);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("dvdf"));
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}
}
