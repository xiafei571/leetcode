package algo.expert;

public class ThreeNumberSort {
	public int[] threeNumberSort(int[] array, int[] order) {
		// Write your code here.
		int idx = 0;

		for (int i = 0; i < order.length - 1; i++) {
			for (int j = idx; j < array.length; j++) {

				if (array[j] == order[i]) {
					if (j == idx) {
						idx++;
					} else {
						swap(idx, j, array);
						idx++;
					}
				}
			}
		}
		return array;
	}

	private static void swap(int i, int j, int[] array) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
}
