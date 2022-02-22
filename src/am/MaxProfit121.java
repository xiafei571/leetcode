package am;

public class MaxProfit121 {
	public static int maxProfit(int[] prices) {
		int max = Integer.MIN_VALUE;
		int j = 1;
		int min = prices[0];

		while (j < prices.length) {
			//if (prices[j] > min) {
			max = Math.max(max, prices[j] - min);
			//}

			min = Math.min(min, prices[j]);
			j++;
		}

		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] {7,6,5,4,3,1}));
	}
}
