package algo.expert;

public class GlobMatching2 {
	public static boolean globMatching(String fileName, String pattern) {
		// Write your code here.
		// * look left and look up
		// ? or equal look left up
		int[][] dp = new int[fileName.length() + 1][pattern.length() + 1];
		// init first line
		dp[0][0] = 1;
		for (int idx = 1; idx < dp[0].length; idx++) {
			if (pattern.charAt(idx - 1) == '*') {
				dp[0][idx] = dp[0][idx - 1];
			}
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (pattern.charAt(j - 1) == '*') {
					if (j > 0 && dp[i][j - 1] == 1) {// look left
						dp[i][j] = 1;
					} else if (i > 0 && dp[i - 1][j] == 1) {// look up
						dp[i][j] = 1;
					} else if (i == 0 && j == 0) {
						dp[i][j] = 1;
					}
				} else if (pattern.charAt(j - 1) == '?' || pattern.charAt(j - 1) == fileName.charAt(i - 1)) {
					if (i > 0 && j > 0 && dp[i - 1][j - 1] == 1) {
						dp[i][j] = 1;
					} else if (i == 0 && j == 0) {
						dp[i][j] = 1;
					} else if (i == 0 && j > 0) {
						dp[i][j] = dp[i][j - 1];
					}
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1] == 1;
	}
}
