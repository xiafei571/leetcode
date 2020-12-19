package algo.expert;

public class MaxSubsetSumNoAdjacent {
	/*
	 * array = [75, 105, 120, 175, 90] 
	 * max_array = [75, 105, 195, 175+105, 90+195]
	 */
	public static int maxSubsetSumNoAdjacent(int[] array) {
		// Write your code here.
		if (array.length == 0) {
			return 0;
		}

		int[] maxArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if (i < 2) {
				maxArray[i] = array[i];
			} else {

				int preMax = maxArray[i - 2];
				if (i > 2 && maxArray[i - 3] > maxArray[i - 2]) {
					preMax = maxArray[i - 3];
				}

				if (array[i] + preMax > maxArray[i - 1]) {
					maxArray[i] = array[i] + preMax;
				} else {
					maxArray[i] = maxArray[i - 1];
				}
			}
		}

		return maxArray[array.length - 1];
	}
}
