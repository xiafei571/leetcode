package algo.expert;

public class BubbleSort {
	public static int[] bubbleSort(int[] array) {
		if (array.length == 0) {
			return new int[] {};
		}

		boolean sorted = false;
		int counter = 0;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < array.length - 1 - counter; i++) {
				if (array[i] > array[i + 1]) {
					swap(array, i, i + 1);
					sorted = false;
				}
			}
			counter++;
		}
		return array;
	}

	public static int[] bubbleSort_2(int[] array) {
		if (array.length == 0) {
			return new int[] {};
		}
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					swap(array, i, j);
				}
			}
		}
		return array;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
