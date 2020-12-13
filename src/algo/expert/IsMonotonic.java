package algo.expert;

public class IsMonotonic {
	public static boolean isMonotonic(int[] array) {
		if (array.length <= 1) {
			return true;
		}
		// 0:equal 1:up -1:down
		int direction = 0;
		int i = 0;
		int j = 1;

		while (direction == 0 && j < array.length) {
			if (array[i] > array[j]) {
				direction = -1;
			} else if (array[i] < array[j]) {
				direction = 1;
			} else {
				direction = 0;
			}
			i++;
			j++;
		}

		if (direction == 0)
			return true;

		for (int idx = 0; idx < array.length - 1; idx++) {
			if (direction == 1 && array[idx] > array[idx + 1])
				return false;
			if (direction == -1 && array[idx] < array[idx + 1])
				return false;
		}

		return true;
	}
}
