package am;

import java.util.Arrays;

public class LengthOfLongestSubstring3 {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("dvdf"));
		System.out.println(lengthOfLongestSubstring("tmmzuxt"));
	}

	public static int lengthOfLongestSubstring(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		if (s.length() < 2) {
			return s.length();
		}

		int max = 1;
		int left = 0;
		int right = 1;

		int[] loc = new int[128];
		Arrays.fill(loc, -1);

		loc[s.charAt(left)] = 0;

		while (right < s.length()) {
			char ch = s.charAt(right);
			if (loc[ch] == -1 || loc[ch] < left) {
				loc[ch] = right;
				max = Math.max(right - left + 1, max);
			} else {
				left = Math.min(loc[ch] + 1, right);
				loc[ch] = right;
			}
			right++;
		}

		return max;

	}
}
