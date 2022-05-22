package bytedance;

public class BestTimetoBuyandSellStock121_123 {

	public int maxProfit(int[] prices) {// maxProfit = max（当前max，当前价格-今天以前的最低价格）
		if (prices.length == 0) {
			return 0;
		}

		int maxProfit = 0;
		int minPrice = prices[0];
		for (int i = 1; i < prices.length; i++) {
			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
			minPrice = Math.min(minPrice, prices[i]);
		}

		return maxProfit;
	}

	public int maxProfit2(int[] prices) { // 只要第二天比第一天高就加进去
		if (prices.length == 0) {
			return 0;
		}

		int maxProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				maxProfit += prices[i] - prices[i - 1];
			}
		}

		return maxProfit;

	}

	public int maxProfit3(int[] prices) {
		// buy1[i] = min(buy1[i-1], price) // 最小买入
		// sell1[i] = max(sell1[i-1], price - buy1[i]) // 最大盈利
		// buy2[i] = min(buy2[i-1], price - sell1[i]) // 最小成本买入
		// sell2[i] = max(sell2[i], price - buy2[i]) // 最大盈利

		if (prices.length == 0) {
			return 0;
		}

		int buy1 = Integer.MAX_VALUE;
		int maxProfit1 = 0;
		int buy2 = Integer.MAX_VALUE;
		int maxProfit2 = 0;

		for (int price : prices) {
			buy1 = Math.min(buy1, price);
			maxProfit1 = Math.max(maxProfit1, price - buy1);
			buy2 = Math.min(buy2, price - maxProfit1);
			maxProfit2 = Math.max(maxProfit2, price - buy2);

			// System.out.println(buy1+","+sell1+","+buy2+","+sell2);
		}

		return maxProfit2;
	}
}
