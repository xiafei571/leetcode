package am;

public class CoinChange322 {
	// dp[j]代表含义：填满容量为j的背包最少需要多少硬币
	// dp[j] = dp[j - coin] + 1

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int amount = 11;
		System.out.println(coinChange(coins, amount));
	}

	public static int coinChange(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}

		int max = amount + 1;

		int[][] dp = new int[coins.length + 1][amount + 1];
		for (int j = 0; j < amount + 1; j++) {
			dp[0][j] = max;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				int coin = coins[i - 1];
				if (coin > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.min(dp[i][j - coin] + 1, dp[i - 1][j]);
				}
			}
		}

		return dp[coins.length][amount] == max ? -1 : dp[coins.length][amount];
	}
}
