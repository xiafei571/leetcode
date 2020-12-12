package algo.expert;

public class SelectionSort {

	public static int[] selectionSort(int[] array) {
		if (array.length == 0)
			return new int[] {};

		for (int i = 0; i < array.length - 1; i++) {
			int smallestIdx = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[smallestIdx]) {
					smallestIdx = j;
				}
			}
			swap(array, i, smallestIdx);
		}
		return array;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
