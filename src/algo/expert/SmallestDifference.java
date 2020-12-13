package algo.expert;

import java.util.Arrays;

public class SmallestDifference {
	public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int left = 0;
		int right = 0;
		int smallest = Integer.MAX_VALUE;
		int current = Integer.MAX_VALUE;
		int[] smallestPair = new int[2];

		while (left < arrayOne.length && right < arrayTwo.length) {
			if (arrayOne[left] == arrayTwo[right]) {
				return new int[] { arrayOne[left], arrayTwo[right] };
			} else if (arrayOne[left] > arrayTwo[right]) {
				current = arrayOne[left] - arrayTwo[right];
				if (current < smallest) {
					smallest = current;
					smallestPair = new int[] { arrayOne[left], arrayTwo[right] };
				}

				right++;
			} else {
				current = arrayTwo[right] - arrayOne[left];
				if (current < smallest) {
					smallest = current;
					smallestPair = new int[] { arrayOne[left], arrayTwo[right] };
				}

				left++;
			}
		}
		return smallestPair;
	}
}
