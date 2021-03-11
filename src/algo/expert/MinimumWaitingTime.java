package algo.expert;

import java.util.Arrays;

public class MinimumWaitingTime {
	public int minimumWaitingTime(int[] queries) {
		// Write your code here.
		Arrays.sort(queries);
		int sum = 0;
		for (int i = 1; i < queries.length; i++) {
			queries[i] += queries[i - 1];
			sum += queries[i - 1];
		}
		return sum;
	}
}
