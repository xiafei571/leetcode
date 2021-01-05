package leetcode;

import java.util.*;

public class WordBreak139 {

	static int[] dp = null;

	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("a");
		wordDict.add("aa");
		wordDict.add("aaa");
		wordDict.add("aaaa");
		wordDict.add("aaaaa");
		wordDict.add("aaaaaa");
		wordDict.add("aaaaaaa");
		wordDict.add("aaaaaaaa");
		wordDict.add("aaaaaaaaa");
		wordDict.add("aaaaaaaaaa");
		dp = new int[s.length() + 1];
		System.out.println(wordBreak(s, wordDict));
	}

	private static boolean wordBreak(String s, List<String> wordDict) {
		dp[0] = 1;
		Set<String> set = new HashSet<String>(wordDict);
		return wordBreakHelper(s, set);
	}

	private static boolean wordBreakHelper(String s, Set<String> wordDict) {
		for (int i = 0; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] == 1 && wordDict.contains(s.substring(j, i))) {
					dp[i] = 1;
					break;
				}
			}
		}
		return dp[s.length()] == 1;
	}

	private static boolean wordBreak_deprecated(String s, List<String> wordDict) {
		Set<String> set = new HashSet<String>(wordDict);
		return wordBreakHelper_deprecated(s, set);

	}

	private static boolean wordBreakHelper_deprecated(String s, Set<String> wordDict) {
		if (s.length() == 0 || wordDict.contains(s)) {
			return true;
		}

		for (int i = 1; i < s.length(); i++) {
			String b = s.substring(i, s.length());
			boolean right = wordDict.contains(b);
			if (right) {
				String a = s.substring(0, i);
				boolean left = wordBreakHelper(a, wordDict);
				if (left) {
					return true;
				}
			} else {
				continue;
			}
		}
		return false;
	}
}
