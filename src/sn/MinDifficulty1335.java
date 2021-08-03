package sn;

public class MinDifficulty1335 {
	public static void main(String[] args) {
		int[] arr = { 6, 5, 4, 3, 2, 1 };
		int d = 2;
		System.out.println(minDifficulty(arr, d));
	}
	// dp[i][k] 1-i job, k days
	// 1...i(k)
	// 1...j(k-1), j+1...i(k)
	// dp[i][k] = Math.min(dp[i][k], dp[j][k-1] + max(j+1:i))
	// i > j >= k-1

	public static int minDifficulty(int[] jobDifficulty, int d) {
		int len = jobDifficulty.length;
		if (len < d) {
			return -1;
		}

		int[][] max = new int[len][len];
		int[][] dp = new int[len + 1][d + 1];

		for (int i = 0; i < len; i++) {
			int maxVal = jobDifficulty[i];
			for (int j = i; j < len; j++) {
				maxVal = Math.max(maxVal, jobDifficulty[j]);
				max[i][j] = maxVal;
			}
		}

		for (int i = 1; i <= len; i++) {
			for (int k = 1; k <= d; k++) {
				for (int j = k - 1; j < i; j++) {
					if(k == 1) {
						dp[i][k] = max[0][i - 1];
					}else if (dp[i][k] == 0) {
						dp[i][k] = dp[j][k - 1] + max[j][i - 1];
					} else {
						dp[i][k] = Math.min(dp[i][k], dp[j][k - 1] + max[j][i - 1]);
					}

				}
			}
		}

//		print2DArray(dp);
		return dp[len][d];
	}

	private static void print2DArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
