package algo.expert;

public class KadanesAlgorithm {
	public static int kadanesAlgorithm(int[] array) {
		// Write your code here.
		int sum = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {
			if (sum < 0 && array[i] > sum) {
				sum = array[i];
			} else {
				sum = sum + array[i];
			}
			max = Math.max(max, sum);
		}

		return max;
	}

	public static int kadanesAlgorithm2(int[] array) {
		int maxEndingHere = array[0];
		int maxSoFar = array[0];
		for (int i = 1; i < array.length; i++) {
			maxEndingHere = Math.max(array[i], maxEndingHere + array[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}
}
