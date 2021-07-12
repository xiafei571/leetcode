package am;

public class MaxProfit121 {
	public int maxProfit(int[] prices) {
		int max = 0;
		int j = 1;
		int min = prices[0];

		while (j < prices.length) {
			if (prices[j] > min) {
				max = Math.max(max, prices[j] - min);
			}

			min = Math.min(min, prices[j]);
			j++;
		}

		return max;
	}
}
