package bb;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCitySchedCost1029 {
	public int twoCitySchedCost(int[][] costs) {//Greedy 算出局部最优解（对比AB花费差值），然后扩展到全局
		Arrays.sort(costs, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				// costA = priceA - priceB
				return (o1[0] - o1[1]) - (o2[0] - o2[1]);
			}
		});

		int sum = 0;
		int n = costs.length / 2;
		for (int i = 0; i < costs.length; i++) {
			if (i < n) {
				sum += costs[i][0];
			} else {
				sum += costs[i][1];
			}
		}
		return sum;
	}
}
