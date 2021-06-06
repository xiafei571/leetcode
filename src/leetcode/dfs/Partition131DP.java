package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class Partition131DP {
	public static void main(String[] args) {
		String s1 = "aab";
		System.out.println("intput:" + s1);
		List<List<String>> result1 = partition(s1);
		printResult(result1);

		String s2 = "a";
		System.out.println("intput:" + s2);
		List<List<String>> result2 = partition(s2);
		printResult(result2);

		String s3 = "cdd";
		System.out.println("intput:" + s3);
		List<List<String>> result3 = partition(s3);
		printResult(result3);
	}

	private static void printResult(List<List<String>> result) {
		for (List<String> list : result) {
			for (String str : list) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}

	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> current = new ArrayList<String>();

		int[][] dp = new int[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = 1;
		}

		for (int j = 1; j < s.length(); j++) {
			for (int i = 0; i < j; i++) {
				if (s.charAt(i) == s.charAt(j)) {
					if (j - i < 3) {
						dp[i][j] = 1;
					} else if (dp[i + 1][j - 1] == 1) {
						dp[i][j] = 1;
					}
				}
			}
		}

		dfs(s, 0, dp, result, current);

		return result;
	}

	private static void dfs(String s, int start, int[][] dp, List<List<String>> result, List<String> current) {
		if (start == s.length()) {
			result.add(new ArrayList<String>(current));
			return;
		}

		for (int j = start; j < s.length(); j++) {
			if (dp[start][j] == 1) {
				String subStr = s.substring(start, j + 1);
				current.add(subStr);
				dfs(s, j + 1, dp, result, current);
				current.remove(current.size() - 1);
			}
		}
	}

}
