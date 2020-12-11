package algo.expert;

public class FindThreeLargestNumbers {
	public static int[] findThreeLargestNumbers(int[] array) {
		int threeLagest[] = { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE };
		for (int num : array) {
			updateLagest(threeLagest, num);
		}
		return threeLagest;
	}

	private static void updateLagest(int threeLagest[], int num) {
		if (num > threeLagest[2]) {
			shiftAndUpdate(threeLagest, num, 2);
		} else if (num > threeLagest[1]) {
			shiftAndUpdate(threeLagest, num, 1);
		} else if (num > threeLagest[0]) {
			shiftAndUpdate(threeLagest, num, 0);
		}
	}

	private static void shiftAndUpdate(int threeLagest[], int num, int idx) {
		for (int i = 0; i < idx + 1; i++) {
			if (i == idx) {
				threeLagest[i] = num;
			} else {
				threeLagest[i] = threeLagest[i + 1];
			}
		}
	}
}
