package id;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak140 {

	public static void main(String[] args) {
		/*
		 * "pineapplepenapple"
["apple","pen","applepen","pine","pineapple"]
		 */
		List<String> wordDict = new ArrayList<String>();
//		wordDict.add("cat");
//		wordDict.add("cats");
//		wordDict.add("and");
//		wordDict.add("sand");
//		wordDict.add("dog");
//		String s = "catsanddog";
		String s = "pineapplepenapple";
		wordDict.add("apple");
		wordDict.add("pen");
		wordDict.add("applepen");
		wordDict.add("pine");
		wordDict.add("pineapple");
		
		List<String> result = wordBreak(s, wordDict);

		for (String str : result) {
			System.out.println(str);
		}
	}

	public static List<String> wordBreak(String s, List<String> wordDict) {
		List<String> result = new ArrayList<String>();
		for (int i = 1; i < s.length() + 1; i++) {
			if (wordDict.contains(s.substring(0, i))) {
				int[] dp = new int[s.length() + 1];
				dp[0] = 1;
				dp[i] = 1;
				wordBreakHelper(s, wordDict, dp, i, result);
			}
		}
		return result;
	}

	private static void wordBreakHelper(String s, List<String> wordDict, int[] dp, int start, List<String> result) {

		if (start == s.length()) {
			if (dp[start] == 1) {
				result.add(dpToString(s, dp));
			}
			return;
		}

		for (int i = start + 1; i < s.length() + 1; i++) {
			if (wordDict.contains(s.substring(start, i))) {
				int[] new_dp = (int[]) Arrays.copyOf(dp, dp.length);
				new_dp[i] = 1;
				wordBreakHelper(s, wordDict, new_dp, i, result);
			}
		}
	}

	private static String dpToString(String s, int[] dp) {
		StringBuilder sb = new StringBuilder();
		int start = 0;
		int end = 1;
		while (end < dp.length) {
			if (dp[end] == 1) {
				sb.append(s.subSequence(start, end)).append(" ");
				start = end;
			}
			end++;
		}
		return sb.toString().substring(0, sb.length() - 1);
	}
}
