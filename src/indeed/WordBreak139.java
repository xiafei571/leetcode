package indeed;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak139 {
	public static void main(String[] args) {
		String s = "leetcode";
		String[] wordDict = { "leet", "code" };
		List<String> wordDictList = new ArrayList<String>();
		for (String str : wordDict) {
			wordDictList.add(str);
		}

		System.out.println(wordBreak(s, wordDictList));
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<String>(wordDict);
		int[] dp = new int[s.length()+1];
		dp[0] = 1;
		//dp[i] = dp[j] && contains[j:i]
		for(int i = 1; i < s.length() + 1; i++) {
			for(int j = 0; j < i; j++) {
				if(dp[j] == 1 && set.contains(s.subSequence(j, i))) {
					dp[i] = 1;
					break;
				}
			}
		}
		return dp[dp.length - 1] == 1;
	}
}
