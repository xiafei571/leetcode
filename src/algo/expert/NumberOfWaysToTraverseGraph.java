package algo.expert;

public class NumberOfWaysToTraverseGraph {
	public int numberOfWaysToTraverseGraph(int width, int height) {
		// Write your code here.
		int[][] dp = new int[height][width];
		dp[0][0] = 1;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (i == 0 && j == 0) {
					continue;
				}

				if (i == 0 && j > 0) {
					dp[i][j] = dp[i][j - 1];
				} else if (j == 0 && i > 0) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				}
			}
		}
		return dp[height - 1][width - 1];
	}
}
