package algo.mock;

public class LevenshteinDistance {
	
	public static int levenshteinDistance(String str1, String str2) {
		// Write your code here.
		int dp[][] = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 1; i < str2.length() + 1; i++) {
			dp[0][i] = i;
		}

		for (int j = 1; j < str1.length() + 1; j++) {
			dp[j][0] = j;
		}

		for (int i = 1; i < str1.length() + 1; i++) {
			for (int j = 1; j < str2.length() + 1; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int up = dp[i - 1][j];
					int left = dp[i][j - 1];
					int left_up = dp[i - 1][j - 1];
					dp[i][j] = Math.min(Math.min(up, left), left_up) + 1;
				}
			}
		}

		// for debug
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[str1.length()][str2.length()];
	}
}
