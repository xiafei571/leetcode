package algo.expert;

import java.util.Arrays;

public class NonConstructibleChange {
	public int nonConstructibleChange(int[] coins) {
		// Write your code here.
		if (coins.length == 0)
			return 1;

		Arrays.sort(coins);
		int change = 0;
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] > change + 1) {
				return change + 1;
			}
			change += coins[i];
		}

		return change + 1;
	}
}
