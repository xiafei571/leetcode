package algo.expert;

public class SortedSquaredArray {

	// O(n) time, O(n) space
	public int[] sortedSquaredArray(int[] array) {
		// Write your code here.
		int minIdx = 0;
		int maxIdx = array.length - 1;

		int[] result = new int[array.length];
		for (int i = result.length - 1; i >= 0; i--) {
			if (Math.abs(array[minIdx]) > Math.abs(array[maxIdx])) {
				result[i] = array[minIdx] * array[minIdx];
				minIdx++;
			} else {
				result[i] = array[maxIdx] * array[maxIdx];
				maxIdx--;
			}
		}
		return result;
	}
}
